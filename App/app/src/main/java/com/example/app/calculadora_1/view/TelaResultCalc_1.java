package com.example.app.calculadora_1.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.calculadora_1.model.Calculadora;

public class TelaResultCalc_1 extends AppCompatActivity {
    Spinner spinner;
    EditText edtValor1, edtValor2, edtResposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria_calc1);
    spinner = (Spinner)findViewById(R.id.spinner);
    edtValor1 = (EditText) findViewById(R.id.editV1);
    edtValor2 = (EditText) findViewById(R.id.editV2);
    edtResposta = (EditText) findViewById(R.id.edtResp);

    edtValor1.setText(getIntent().getExtras().getString("valor1"));
    edtValor2.setText(getIntent().getExtras().getString("valor2"));
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
    public void estatico(View v){
        double aux1,aux2;
        if (spinner.getSelectedItem().toString().toString().equals("Somar")){
            Calculadora calc = new Calculadora(
                    Double.parseDouble(edtValor1.getText().toString()),
                    Double.parseDouble(edtValor2.getText().toString())
            );

            edtResposta.setText(calc.formatar(calc.somar(),6));
        }else if (spinner.getSelectedItem().toString().toString().equals("Subtração")){
            Calculadora calc = new Calculadora(
                    Double.parseDouble(edtValor1.getText().toString()),
                    Double.parseDouble(edtValor2.getText().toString())
            );
            edtResposta.setText(calc.formatar(calc.subtracao(),6));

        }else if (spinner.getSelectedItem().toString().toString().equals("Multiplicação")){
            Calculadora calc = new Calculadora(
                    Double.parseDouble(edtValor1.getText().toString()),
                    Double.parseDouble(edtValor2.getText().toString())
            );
            edtResposta.setText(calc.formatar(calc.multiplicacao(),6));

        }else if(spinner.getSelectedItem().toString().toString().equals("Divisão")){
            Calculadora calc = new Calculadora(
                    Double.parseDouble(edtValor1.getText().toString()),
                    Double.parseDouble(edtValor2.getText().toString())
            );
            edtResposta.setText(calc.formatar(calc.divisao(),6));

        }else if(spinner.getSelectedItem().toString().toString().equals("Radiciação")){
            Calculadora calc = new Calculadora(
                    Double.parseDouble(edtValor1.getText().toString()),
                    Double.parseDouble(edtValor2.getText().toString())
            );
            edtResposta.setText(calc.formatar(calc.radiciacao(),6));
        }else if (spinner.getSelectedItem().toString().toString().equals("Exponenciação")){
            Calculadora calc = new Calculadora(
                    Double.parseDouble(edtValor1.getText().toString()),
                    Double.parseDouble(edtValor2.getText().toString())
            );
            edtResposta.setText(calc.formatar(calc.exponenciacao(),6));
        }
    }
}