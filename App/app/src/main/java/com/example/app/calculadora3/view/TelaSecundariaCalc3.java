package com.example.app.calculadora3.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.calculadora3.model.Calculadora3;

import java.util.ArrayList;
import java.util.List;

public class TelaSecundariaCalc3 extends AppCompatActivity {
    EditText edtValor1, edtValor2,aux;
    TextView edtResposta;
    Spinner spinner;

    List<String> operacoes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria_calc3);
        edtValor1 = (EditText) findViewById(R.id.edtV1);
        edtValor2 = (EditText) findViewById(R.id.editV2);
        edtResposta = (TextView) findViewById(R.id.edtResp);
        spinner = (Spinner) findViewById(R.id.spinner);

        edtValor1.setText(getIntent().getExtras().getString("valor1"));
        edtValor2.setText(getIntent().getExtras().getString("valor2"));
        aux.setText(getIntent().getExtras().getString("valor3"));

        if (aux.equals("1")){
            operacoes.set(1,"Soma");
            spinner.setSelection(1);

        }else if (aux.equals("2")){
            operacoes.set(2,"Soma");
            spinner.setSelection(2);

        }else if (aux.equals("3")){
            spinner.setSelection(3);

        }else if (aux.equals("4")){
            spinner.setSelection(4);

        }else if (aux.equals("5")){
            spinner.setSelection(5);

        }else if (aux.equals("6")){
            spinner.setSelection(6);

        }

    }


    public void spinnerstatic(View v){
        Calculadora3 calc = new Calculadora3(
                Double.parseDouble(edtValor1.getText().toString()),
                Double.parseDouble(edtValor2.getText().toString())
        );

        if (spinner.getSelectedItemId()==1){
            //soma
            edtResposta.setText(calc.formatar(calc.somar(),3));
        }else if(spinner.getSelectedItemId()==2){
            //subtração
            edtResposta.setText(calc.formatar(calc.subt(),3));
        }else if(spinner.getSelectedItemId()==3) {
            //multiplicação
            edtResposta.setText(calc.formatar(calc.mult(),3));

        }else if(spinner.getSelectedItemId()==4){
            //divisão
            edtResposta.setText(calc.formatar(calc.divis(),3));

        }else if(spinner.getSelectedItemId()==5){
            //exponenciação
            edtResposta.setText(calc.formatar(calc.expo(),3));

        }else if(spinner.getSelectedItemId()==6){
            //Radiciação
            edtResposta.setText(calc.formatar(calc.radic(),3));
        }else {
            //opcao invalida (TOAST)
            edtResposta.setText("OPERAÇÃO INVALIDA");
        }

    }

    public void voltar(View v) {
        String operacao = edtResposta.getText().toString(),Valor_1 = edtValor1.getText().toString(),
                Valor_2 = edtValor2.getText().toString();

        // Prepara a Intent de retorno para o valor da soma
        Intent returnIntent = new Intent();
        // Define o parâmetro e o valor
        returnIntent.putExtra("resp1",Valor_1);
        returnIntent.putExtra("resp2",Valor_2);
        returnIntent.putExtra("resp3", operacao);
        setResult(RESULT_OK, returnIntent);
        // Encerra a atividade
        finish();
    }
}