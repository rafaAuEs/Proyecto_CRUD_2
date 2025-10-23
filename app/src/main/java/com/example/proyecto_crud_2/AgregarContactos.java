package com.example.proyecto_crud_2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;//alertas emergentes

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONException;// para manejar errores en JSON ejemplo: try catch
import org.json.JSONObject;//poder crear objetos JSON

import java.io.IOException;//para poder usar try catch

import okhttp3.Call;//usar okhttp
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AgregarContactos extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();//objeto okhttp
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");//'Mediatype.get' intancia de mediatype '(...,...)' formato y codificación
    private static final String SERVER_URL = "http://example.com/api/contactos";//URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_contactos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.btnAgregarVolver).setOnClickListener(v -> finish());//'findViewById' busca una referencia de una View por id, 'R.' coje una lista de recursos '.id....' indica buscar id y la id a buscar '.setOnClickListener()' registrar el listener al tocar el boton 'v' parametro que representa la view actual '-> finish()' finaliza la vista

        findViewById(R.id.guardarAgregarContactos).setOnClickListener( v -> {
            EditText etNombre = findViewById(R.id.editAgregarNombre);//objeto EditText
            EditText etTelefono = findViewById(R.id.editAgregarTelefono);

            String nuevoNombre = etNombre.getText().toString().trim();//convertimos en string
            String nuevoTelefono = etTelefono.getText().toString().trim();

            enviarContacto(nuevoNombre, nuevoTelefono);
        });
    }
    private void enviarContacto(String nombre, String telefono) {
        JSONObject json = new JSONObject();//objeto json
        try {
            json.put("nombre", nombre);
            json.put("telefono", telefono);
        } catch (JSONException e) {
            Toast.makeText(this, "Error al crear JSON", Toast.LENGTH_SHORT).show();//emergente error
            return;
        }

    }
}