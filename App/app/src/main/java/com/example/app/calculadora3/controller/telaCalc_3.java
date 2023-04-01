package com.example.app.calculadora3.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.calculadora_1.view.TelaResultCalc_1;

import java.util.ArrayList;
import java.util.List;


public class telaCalc_3 extends AppCompatActivity {
    EditText edtValor1, edtValor2;
    TextView edtResposta;
    Spinner spinner;
    static final int ACTIVITY_REQUEST = 1;
    Intent intent;
    List<String> operacoes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calc3);
        edtValor1 = (EditText) findViewById(R.id.edtV1);
        edtValor2 = (EditText) findViewById(R.id.editV2);
        edtResposta = (TextView) findViewById(R.id.edtResp);
        spinner = (Spinner) findViewById(R.id.spinner);
        preenche();
    }
    public void  preenche(){
        //operacoes.add("Faça sua escolha: ");
        operacoes.add("Soma");
        operacoes.add("Subtração");
        operacoes.add("Multiplicação");
        operacoes.add("Divisão");
        operacoes.add("Exponenciação");
        operacoes.add("Radiciação");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, operacoes);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }
    public void chamaTelaSecundaria(View v){
        double val1 , val2;
        val1 = Double.parseDouble(edtValor1.getText().toString());
        val2 = Double.parseDouble(edtValor2.getText().toString());
        Double val3 = Double.valueOf(2);
        intent = new Intent(getApplicationContext(), TelaResultCalc_1.class);
        intent.putExtra("valor1",String.valueOf(val1));
        intent.putExtra("valor2",String.valueOf(val2));

        if (spinner.getSelectedItem().equals("Soma")){
            //soma

            val3 = Double.valueOf(1);
            intent.putExtra("valor3", val3);
        }else if(spinner.getSelectedItem().equals("Subtração")){
            //subtração
            val3 = Double.valueOf(2);
            intent.putExtra("valor3", val3);
        }else if(spinner.getSelectedItem().equals("Multiplicação")) {
            //multiplicação
            val3 = Double.valueOf("3");
            intent.putExtra("valor3",val3);

        }else if(spinner.getSelectedItem().equals("Divisão")){
            //divisão
            val3 = Double.valueOf("4");
            intent.putExtra("valor3",val3);

        }else if(spinner.getSelectedItem().equals("Exponenciação")){
            //exponenciação
            val3 = Double.valueOf("5");
            intent.putExtra("valor3", val3);

        }else if(spinner.getSelectedItem().equals("Radiciação")){
            //Radiciação
            val3 = Double.valueOf("6");
            intent.putExtra("valor3", val3);
        }else {
            //opcao invalida (TOAST)
            edtResposta.setText("OPERAÇÃO INVALIDA");
        }

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