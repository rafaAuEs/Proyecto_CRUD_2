const express = require('express');

const app = express();
const PORT = process.env.PORT || 3000;//si hay un proveedor de hosting le indica que use tu variable port, en vez de usar la suya genérica, || condicional si el processo es nulo da directamente el 3000

app.use(express.json);// indica a express que las peticiones recividas se conviertan en un onjeto json

app.post('/constactos', (req, res) => {//recibimos contactos y requiere respuesta
    const { nombre, telefono } = req.body;//indicamos que el body tenga nombre y telefono
    if ( !nombre || !telefono ){//condicion no nombre o no telefono
        return res.status(400).json({error: 'Faltan campos: nombre o telefono'});//'res' respuesta '.status(400)' estado 400 bad request, '.json' body formato json '{(error: )}' mensaje de error
    }

    console.log('contacto recibido', req.body);//comprobante
    return res.status(201).json({ message: 'contacto recibido'});//confirma recpcion 'res' respuesta '.status(201)' codigo HTTP Created, '.json' body formato json '{(message: )}' mensaje
});

app.listen(PORT, () => {//la aplicacion inicia escuchar, 'puerto,' '() =>' función callback que se ejecuta despues de empezar a escuchar
    console.log(`Servidor Express escuchando en http:/localhost:${PORT}`);
});

