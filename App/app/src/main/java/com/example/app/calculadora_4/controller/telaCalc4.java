package com.example.app.calculadora_4.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.calculadora_4.view.TelaSecundariaCalc4;

public class telaCalc4 extends AppCompatActivity {
    EditText edtV1, edtV2, edtResult;
    RadioButton rbTriangulo,rbRetangulo;
    Intent intent;
    static final int ACTIVITY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calc4);
        edtV1 = (EditText) findViewById(R.id.editValor1);
        edtV2 = (EditText) findViewById(R.id.editValor2);
        edtResult=(EditText) findViewById(R.id.editResult);

        rbTriangulo = (RadioButton) findViewById(R.id.rbtTriangulo);
        rbRetangulo = (RadioButton) findViewById(R.id.rbtRetangulo);
    }
    public void chamaTelaSoma(View v){
        //Entrada de Dados
        double val1, val2;
        String val3 = "2";
        val1 = Double.parseDouble(edtV1.getText().toString());
        val2 = Double.parseDouble(edtV2.getText().toString());
        // Processamento de chamada da nova tela
        intent = new Intent(getApplicationContext(), TelaSecundariaCalc4.class);
        // Envia o nome para a segunda atividade
        intent.putExtra("valor1", String.valueOf(val1));
        intent.putExtra("valor2", String.valueOf(val2));

        if (rbTriangulo.isChecked()){
            val3 = "1";
            intent.putExtra("valor3", String.valueOf(val3));
        }else if(rbRetangulo.isChecked()){
            val3 = "0";
            intent.putExtra("valor3", String.valueOf(val3));
        }


        // chama a segunda atividade aguardando valores de retorno no request = 1
        startActivityForResult(intent, ACTIVITY_REQUEST);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST && resultCode == RESULT_OK) {
            String retorno1 = data.getStringExtra("resp1"),
                    retorno2 = data.getStringExtra("resp2"),
                     retorno3 = data.getStringExtra("resp3");
            double operacao = Double.parseDouble(retorno3),v2 = Double.parseDouble(retorno2),v1 = Double.parseDouble(retorno1);

            edtV1.setText(String.format("%.2f",v1));
            edtV2.setText(String.format("%.2f",v2));
            edtResult.setText(String.format("%.2f", operacao));
        }
    }

}