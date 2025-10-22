package com.example.proyecto_crud_2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgregarContactos extends AppCompatActivity {

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
        findViewById(R.id.btnAgregarVolver).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.guardarAgregarContactos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNombre = findViewById(R.id.editAgregarNombre);
                EditText etTelefono = findViewById(R.id.editAgregarTelefono);

                String nombre = etNombre.getText().toString().trim();
                String telefono = etTelefono.getText().toString().trim();
            }
        });
    }
}