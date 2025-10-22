const express = require('express');
const cors = require('cors');
const fs = require('fs').promises;
const path = require('path');

const app = express();
app.use(cors());
app.use(express.json());

const DB_PATH = path.join(__dirname, 'contacts.json');
// Genera el siguiente id numérico disponible basado en los existentes
function getNextId(contacts) {
  let maxId = 0;
  for (const c of contacts) {
    const n = Number(c.id);
    if (!Number.isNaN(n) && n > maxId) maxId = n;
  }
  return String(maxId + 1);
}

async function readDb() {
  try {
    const data = await fs.readFile(DB_PATH, 'utf8');
    return JSON.parse(data);
  } catch (e) {
    if (e.code === 'ENOENT') {
      return { contacts: [] };
    }
    throw e;
  }
}

async function writeDb(db) {
  const json = JSON.stringify(db, null, 2);
  await fs.writeFile(DB_PATH, json, 'utf8');
}

app.get('/contacts', async (req, res) => {
  const db = await readDb();
  res.json(db.contacts);
});

app.post('/contacts', async (req, res) => {
  const { id, nombre, telefono } = req.body || {};
  if (!nombre || !telefono) return res.status(400).json({ error: 'nombre y telefono son obligatorios' });
  const db = await readDb();
  const newId = (id != null && String(id).trim() !== '') ? String(id) : getNextId(db.contacts);
  const newContact = { id: newId, nombre, telefono };
  db.contacts.push(newContact);
  await writeDb(db);
  res.status(201).json(newContact);
});

app.put('/contacts/:id', async (req, res) => {
  const idParam = String(req.params.id);
  const { nombre, telefono } = req.body || {};
  const db = await readDb();
  const idx = db.contacts.findIndex(c => String(c.id) === idParam);
  if (idx === -1) return res.sendStatus(404);
  if (nombre != null) db.contacts[idx].nombre = nombre;
  if (telefono != null) db.contacts[idx].telefono = telefono;
  await writeDb(db);
  res.json(db.contacts[idx]);
});

app.delete('/contacts/:id', async (req, res) => {
  const idParam = String(req.params.id);
  const db = await readDb();
  const before = db.contacts.length;
  db.contacts = db.contacts.filter(c => String(c.id) !== idParam);
  if (db.contacts.length === before) return res.sendStatus(404);
  await writeDb(db);
  res.sendStatus(204);
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`API escuchando en http://localhost:${PORT}`);
});


