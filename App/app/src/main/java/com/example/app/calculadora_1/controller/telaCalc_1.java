package com.example.app.calculadora_1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.calculadora_1.view.TelaResultCalc_1;

public class telaCalc_1 extends AppCompatActivity {
    Spinner spinner;
    EditText edtValor1, edtValor2, edtResposta;

    static final int ACTIVITY_REQUEST = 1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calc1);
        spinner = (Spinner)findViewById(R.id.spinner);
        edtValor1 = (EditText) findViewById(R.id.edtV1);
        edtValor2 = (EditText) findViewById(R.id.editV2);
        edtResposta = (EditText) findViewById(R.id.edtResp);
    }
    public void chamaTelaSecundaria(View v){
        double val1 , val2,val3,val4,val5;
        val1 = Double.parseDouble(edtValor1.getText().toString());
        val2 = Double.parseDouble(edtValor2.getText().toString());

        intent = new Intent(getApplicationContext(), TelaResultCalc_1.class);
        intent.putExtra("valor1",String.valueOf(val1));
        intent.putExtra("valor2",String.valueOf(val2));
        startActivityForResult(intent,ACTIVITY_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST && resultCode == RESULT_OK) {

            String retorno1 = data.getStringExtra("resp1");
            String retorno2 = data.getStringExtra("resp2");
            String retorno3 = data.getStringExtra("resp3");

            double Valor_1 = Double.parseDouble(retorno1), Valor_2 = Double.parseDouble(retorno2), Valor_resp = Double.parseDouble(retorno3);

            //Coloca o valor da soma no EditText
            edtValor1.setText(String.format("%.2f", Valor_1));
            edtValor2.setText(String.format("%.2f", Valor_2));
            edtResposta.setText(String.format("%.2f", Valor_resp));

        }


    }
}