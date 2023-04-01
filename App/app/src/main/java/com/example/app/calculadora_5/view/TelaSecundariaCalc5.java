package com.example.app.calculadora_5.view;

import static java.lang.Math.pow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class TelaSecundariaCalc5 extends AppCompatActivity {
    EditText edtV1, edtV2, edtResult;
    RadioButton rbSoma, rbSub,rbDiv,rbMult,rbRad,rbExp;
    String aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria_calc5);
        edtV1= (EditText) findViewById(R.id.edtV1);
        edtV2=(EditText) findViewById(R.id.edtV2);
        edtResult=(EditText) findViewById(R.id.edtresult);

        rbSoma=(RadioButton) findViewById(R.id.rbtSoma);
        rbSub=(RadioButton) findViewById(R.id.rbtsub);
        rbDiv=(RadioButton) findViewById(R.id.rbtdiv);
        rbMult=(RadioButton) findViewById(R.id.rbtmult);
        rbExp=(RadioButton) findViewById(R.id.rbtexp);
        rbRad=(RadioButton) findViewById(R.id.rbtrad);

        // Pegar como String porque será colocado no EditText
        edtV1.setText(getIntent().getExtras().getString("valor1"));
        edtV2.setText(getIntent().getExtras().getString("valor2"));
        aux = getIntent().getExtras().getString("valor3");

        if (aux.equals("1")){
            rbSoma.setChecked(true); // Marca o RadioButto
        }else if (aux.equals("2")){
            rbSub.setChecked(true); // Marca o RadioButton
        }else if (aux.equals("3")){
            rbDiv.setChecked(true); // Marca o RadioButton
        }else if (aux.equals("4")){
            rbMult.setChecked(true); // Marca o RadioButton
        }else if (aux.equals("5")){
            rbExp.setChecked(true); // Marca o RadioButton
        }else if (aux.equals("6")){
            rbRad.setChecked(true); // Marca o RadioButton
        }

    }

    public void verificar(View v){
        //entrada
        double V1, V2,resultado;

        V1 = Double.parseDouble(edtV1.getText().toString());
        V2 = Double.parseDouble(edtV2.getText().toString());

        if(rbSoma.isChecked()){
            edtResult.setText(String.format("%.2f",(V1+V2)));
        } else if (rbDiv.isChecked()){
            edtResult.setText(String.format("%.2f",(V1/V2)));
        }else if (rbMult.isChecked()){
            edtResult.setText(String.format("%.2f",(V1*V2)));
        }else if (rbSub.isChecked()){
            edtResult.setText(String.format("%.2f",(V1-V2)));
        }else if (rbRad.isChecked()){
            edtResult.setText(String.format("%.2f",pow(V1,(1/V2))));
        }else if (rbExp.isChecked()){
            edtResult.setText(String.format("%.2f",pow(V1,V2)));
        }

    }


    public void voltar(View v) {
        String operacao = edtResult.getText().toString(),
                Valor_1 = edtV1.getText().toString(),Valor_2 = edtV2.getText().toString();
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