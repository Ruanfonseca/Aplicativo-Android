package com.example.app.calculadora_4.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class TelaSecundariaCalc4 extends AppCompatActivity {
    EditText edtV1, edtV2, edtResult;
    String aux;
    RadioButton rbTriangulo,rbRetangulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria_calc4);
        edtV1 = (EditText) findViewById(R.id.editValor1);
        edtV2 = (EditText) findViewById(R.id.editValor2);
        edtResult=(EditText) findViewById(R.id.editResult);

        rbTriangulo = (RadioButton) findViewById(R.id.rbtTriangulo);
        rbRetangulo = (RadioButton) findViewById(R.id.rbtRetangulo);

        // Pegar como String porque será colocado no EditText
        edtV1.setText(getIntent().getExtras().getString("valor1"));
        edtV2.setText(getIntent().getExtras().getString("valor2"));
        aux = getIntent().getExtras().getString("valor3");

        if (aux.equals("1")){
            rbTriangulo.setChecked(true); // Marca o RadioButton
            rbRetangulo.setChecked(false);
        }else if (aux.equals("0")){
            rbRetangulo.setChecked(true); // Marca o RadioButton
            rbTriangulo.setChecked(false);
        }
    }

    public void calcular(View v){

        double V1, V2;

        V1 = Double.parseDouble(edtV1.getText().toString());
        V2 = Double.parseDouble(edtV2.getText().toString());


        if(rbTriangulo.isChecked()){
            edtResult.setText(String.format("%.2f",(V1*V2)/2));
        } else if (rbRetangulo.isChecked()){
            edtResult.setText(String.format("%.2f",(V1*V2)));
        }
    }

    public void voltar(View v) {
        String operacao = edtResult.getText().toString(),Valor_1 = edtV1.getText().toString(),Valor_2 = edtV1.getText().toString();
        // Prepara a Intent de retorno para o valor da soma
        Intent returnIntent = new Intent();
        // Define o parâmetro e o valor
        returnIntent.putExtra("resp1",Valor_1);
        returnIntent.putExtra("resp2",Valor_2);
        returnIntent.putExtra("resp3",operacao);
        setResult(RESULT_OK, returnIntent);
        // Encerra a atividade
        finish();
    }

}