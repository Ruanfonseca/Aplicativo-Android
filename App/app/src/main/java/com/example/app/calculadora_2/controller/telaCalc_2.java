package com.example.app.calculadora_2.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.calculadora_2.view.TelaSecundariaCalc2;

public class telaCalc_2 extends AppCompatActivity {
    EditText edtPeso,edtAltura,edtImc,edtSituacao;
    RadioButton rbtFeminino,rbtMasculino;
    CheckBox chkIdade;
    Intent intent;
    static final int ACTIVITY_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calc2);
        edtPeso = (EditText) findViewById(R.id.edtV1);
        edtAltura = (EditText) findViewById(R.id.edtV2);
        edtImc = (EditText) findViewById(R.id.saidaImc);
        edtSituacao = (EditText) findViewById(R.id.editTextSituacao);
        rbtFeminino = (RadioButton) findViewById(R.id.radioButtonfem);
        rbtMasculino = (RadioButton) findViewById(R.id.radioButtonMasc);
        chkIdade = (CheckBox) findViewById(R.id.checkBoxIdade);
    }


    public void chamaTelaSecundaria(View v){
        double val1,val2;
        String val3,val4;
        val1 = Double.parseDouble(edtPeso.getText().toString());
        val2 = Double.parseDouble(edtAltura.getText().toString());


        intent = new Intent(getApplicationContext(), TelaSecundariaCalc2.class);
        intent.putExtra("valor1",String.valueOf(val1));
        intent.putExtra("valor2",String.valueOf(val2));

        if (rbtFeminino.isChecked()){
            val3 = "1";
            intent.putExtra("valor3", String.valueOf(val3));
        }else if(rbtMasculino.isChecked()){
            val3 = "0";
            intent.putExtra("valor3", String.valueOf(val3));
        }
        if (chkIdade.isChecked()){
            val3 = "1";
            intent.putExtra("valor4", String.valueOf(val3));
        }else{
            val3 = "0";
            intent.putExtra("valor4", String.valueOf(val3));
        }

        startActivityForResult(intent,ACTIVITY_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST && resultCode == RESULT_OK) {
            String retorno1 = data.getStringExtra("resp1");
            String retorno4 = data.getStringExtra("resp4");

            double soma = Double.parseDouble(retorno1);
            String situacao = String.valueOf(retorno4);
            //Coloca o valor da soma no EditText
            edtImc.setText(String.format("%.2f", soma));
            edtSituacao.setText(String.format(situacao));
        }
    }


}
