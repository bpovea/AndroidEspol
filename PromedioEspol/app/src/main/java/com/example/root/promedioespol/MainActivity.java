package com.example.root.promedioespol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText porTeo, porPra, priPar, segPar, terPar, pract;
    Button btnSumar;
    TextView resultado;

    double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch(Exception e) {
                return -1;
            }
        }
        else return 0;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priPar = (EditText) findViewById(R.id.priPar);
        segPar = (EditText) findViewById(R.id.segPar);
        terPar = (EditText) findViewById(R.id.terPar);
        pract = (EditText) findViewById(R.id.pract);
        btnSumar = (Button) findViewById((R.id.calcular));
        resultado = (TextView) findViewById(R.id.result);

        porTeo = (EditText) findViewById(R.id.porTeo);
        porPra = (EditText) findViewById(R.id.porPra);

        porPra.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                double aux1 = ParseDouble(porPra.getText().toString());
                if (aux1 != 0) {
                    double diferencia = 100 - aux1;
                    porTeo.setText(diferencia + "");
                }else{
                    porTeo.setText("");
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    public void calcular(View v){

        priPar = (EditText) findViewById(R.id.priPar);
        segPar = (EditText) findViewById(R.id.segPar);
        terPar = (EditText) findViewById(R.id.terPar);
        pract = (EditText) findViewById(R.id.pract);
        resultado = (TextView) findViewById(R.id.result);

        porTeo = (EditText) findViewById(R.id.porTeo);
        porPra = (EditText) findViewById(R.id.porPra);
        
        double aux1 = ParseDouble(priPar.getText().toString());
        
        double aux2 = ParseDouble(segPar.getText().toString());
        
        double aux3 = ParseDouble(terPar.getText().toString());
        
        double aux4 = ParseDouble(pract.getText().toString());
        
        double pPra =  ParseDouble(porPra.getText().toString());
        
        double pTeo = ParseDouble(porTeo.getText().toString());


        double max = Math.max(aux1+aux2,Math.max(aux1+aux3,aux2+aux3));

        if (pPra != 0.0){
            if (max/2 >= 60){
                resultado.setText(String.format("Feliciadaes tu promedio es %1$f, Aprobado.",max/2));
            }else{
                resultado.setText(String.format("Lo siento tu promedio de %1$f, Reprobado.",max/2));
            }
        }else{
            double promedio_final = ((max/2)*pTeo/100)+((aux4/2)*pPra/100);
            if (promedio_final >= 60){
                resultado.setText(String.format("Feliciadaes tu promedio es %1$f, Aprobado.",promedio_final));
            }else{
                resultado.setText(String.format("Lo siento tu promedio de %1$f, Reprobado.",promedio_final));
            }
        }

    }
}
