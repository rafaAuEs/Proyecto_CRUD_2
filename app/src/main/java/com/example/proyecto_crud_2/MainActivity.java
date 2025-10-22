package com.example.proyecto_crud_2;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.btnAgregar).setOnClickListener (new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AgregarContactos.class);
                    startActivity(intent);
            }
        });
        findViewById(R.id.btnLeer).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LeerContactos.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnModificar).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ModificarContactos.class);
            startActivity(intent);
            }
        });
        findViewById(R.id.btnEliminar).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, EliminarContactos.class);
                startActivity(intent);
            }
        });
    }
}