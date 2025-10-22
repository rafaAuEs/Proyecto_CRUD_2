package com.example.proyecto_crud_2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModificarContactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_contactos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.btnModificarVolver).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.guardarModificarContactos).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editModificarID = findViewById(R.id.editModificar);
                EditText editModificarNombre = findViewById(R.id.editModificarNombre);
                EditText editModificarTelefono = findViewById(R.id.editModificarTelefono);

                String stringModificarID = editModificarID.getText().toString().trim();
                String stringModificarNombre = editModificarNombre.getText().toString().trim();
                String stringModificarTelefono = editModificarTelefono.getText().toString().trim();

            }
        });
    }
}