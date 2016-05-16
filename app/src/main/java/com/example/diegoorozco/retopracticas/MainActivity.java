package com.example.diegoorozco.retopracticas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView cuenta=(TextView) findViewById(R.id.tcontador);
        Button Ventana2=(Button)  findViewById(R.id.bVentana);
        Button Borrar=(Button) findViewById(R.id.bBorrar);
        final EditText Texto=(EditText) findViewById(R.id.eTextoIngresado);

        SharedPreferences ajustes = getSharedPreferences("CANTIDADES", 0);
        final SharedPreferences.Editor editor= ajustes.edit();
        contador=ajustes.getInt("contador",0);
        contador++;
        editor.putInt("contador", contador);
        editor.commit();
        editor.apply();
        contador=ajustes.getInt("contador",0);

        cuenta.setText(String.valueOf(contador));

        Ventana2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable TextoIngresado= Texto.getText();
                Intent i = new Intent(getApplicationContext(),Main2Activity.class );
                i.putExtra("dato", TextoIngresado.toString());
                i.putExtra("contador",contador);
                startActivity(i);

            }
        });

        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("contador", 0);
                editor.commit();
                editor.apply();
                cuenta.setText("0");
            }
        });
    }

}
