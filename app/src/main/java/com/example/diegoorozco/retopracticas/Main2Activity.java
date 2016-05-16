package com.example.diegoorozco.retopracticas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras=getIntent().getExtras();
        String dato= extras.getString("dato");
        int contador=extras.getInt("contador");
        setContentView(R.layout.activity_main2);

        TextView tsuma=(TextView) findViewById(R.id.suma);
        TextView tresta=(TextView) findViewById(R.id.resta);
        TextView tmultiplicacion=(TextView) findViewById(R.id.mult);
        TextView tdivision=(TextView) findViewById(R.id.div);
        TextView concatenacion=(TextView) findViewById(R.id.concate);
        TextView ExtrNumeros=(TextView) findViewById(R.id.extraNum);
        TextView GenerarNumeros=(TextView) findViewById(R.id.GeneNum);

        boolean boolNum=false;
        boolean boolLetras=false;
        float suma, resta, multiplicacion, division;

        int n=dato.length();
        String numeros="";
        String letras="";
        String letrasAs="";


        for(int i=0;i<n;i++)
        {
            if(Character.isDigit(dato.charAt(i)))
            {
                boolNum=true;
                numeros += dato.charAt(i); // extrayendo numeros
            }
            else
            {
                boolLetras=true;
                letras+= dato.charAt(i); // extrayendo letras

            }
        }
        if(boolNum)
        {
            if(boolLetras) //Numeros y Letras
            {
                ExtrNumeros.setVisibility(View.VISIBLE);
                GenerarNumeros.setVisibility(View.VISIBLE);
                int num= Character.getNumericValue(Integer.valueOf(numeros)); // numero a carateres Ascii
                n=letras.length();
                for(int i=0;i<n;i++) { //Letras a Numero Ascii
                    int letras1=letras.codePointAt(i);
                    letrasAs+= String.valueOf(letras1);
                }
                ExtrNumeros.setText("Numerros Extraidos en codigo ASCII= "+Integer.valueOf(num));
                GenerarNumeros.setText("Letras Extraidas conviriendo a numeros = "+letrasAs);
            }
            else //Numeros
            {
                suma=Integer.parseInt(dato)+contador;
                resta=Integer.parseInt(dato)-contador;
                multiplicacion=Integer.parseInt(dato)*contador;
                division=Integer.parseInt(dato)/contador;
                tsuma.setVisibility(View.VISIBLE);
                tresta.setVisibility(View.VISIBLE);
                tmultiplicacion.setVisibility(View.VISIBLE);
                tdivision.setVisibility(View.VISIBLE);
                tsuma.setText("Suma = " + String.valueOf(suma));
                tresta.setText("Resta = "+String.valueOf(resta));
                tmultiplicacion.setText("Multiplicacion = " + String.valueOf(multiplicacion));
                tdivision.setText("Division = "+String.valueOf(division));
            }
        }
        else
        {
            concatenacion.setVisibility(View.VISIBLE);
            concatenacion.setText(dato+String.valueOf(contador));
        }

    }
}
