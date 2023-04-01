package com.example.app.calculadora_2.view;

import static java.lang.Math.pow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class TelaSecundariaCalc2 extends AppCompatActivity {
    EditText edt1, edt2, edtIMC;
    EditText edtPeso,edtAltura,edtSituacao;
    RadioButton rbtFeminino,rbtMasculino;
    CheckBox chkIdade;
    String aux,aux2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria_calc2);
        edt1 = (EditText) findViewById(R.id.edtV1);
        edt2 = (EditText) findViewById(R.id.edtV2);
        edtIMC = (EditText) findViewById(R.id.saidaImc);
        edtSituacao = (EditText) findViewById(R.id.editTextSituacao);
        rbtFeminino = (RadioButton) findViewById(R.id.radioButtonfem);
        rbtMasculino = (RadioButton) findViewById(R.id.radioButtonMasc);
        chkIdade = (CheckBox) findViewById(R.id.checkBoxIdade);

        // Pegar como String porque será colocado no EditText
        edt1.setText(getIntent().getExtras().getString("valor1"));
        edt2.setText(getIntent().getExtras().getString("valor2"));
        aux = getIntent().getExtras().getString("valor3");
        aux2 = getIntent().getExtras().getString("valor4");

        if (aux.equals("1")){
            rbtFeminino.setChecked(true); // Marca o RadioButton

        }else if (aux.equals("0")){
            rbtMasculino.setChecked(true); // Marca o RadioButton
        }
        if (aux2.equals("1")){
            chkIdade.setChecked(true); // Marca o RadioButton

        }else if (aux2.equals("0")){
            chkIdade.setChecked(false); // Marca o RadioButton
        }

    }

    public void voltar(View v) {
        String soma = edtIMC.getText().toString();
        String situacao = edtSituacao.getText().toString();


        // Prepara a Intent de retorno para o valor da soma
        Intent returnIntent = new Intent();
        // Define o parâmetro e o valor
        returnIntent.putExtra("resp1", soma);
        returnIntent.putExtra("resp4", situacao);

        setResult(RESULT_OK, returnIntent);
        // Encerra a atividade
        finish();
    }


    public void verfica(View v){

        double peso,altura,imc = 0.0;
        int idade; //true - marcado ,false - não marcado
        int sexo;  //1 - feminino e 2 - masculino
        String situacao = "NULL";
        peso = Double.parseDouble(edt1.getText().toString());
        altura = Double.parseDouble(edt2.getText().toString());
        if (chkIdade.isChecked()){
            idade = 1;
        }else{
            idade = 0;
        }

        if(rbtFeminino.isChecked()) {
            sexo = 1;
        }else{
            sexo = 2;
        }

        //processamento
        switch (idade){
            case 1:
                if(sexo == 1){
                    imc = peso/pow(altura,2);
                    if(imc < 19.1){
                        situacao = "Abaixo do Peso";
                    }else if ((imc > 19.1)&&(imc < 25.8)){
                        situacao = "No peso Normal";
                    }else if ((imc > 25.8)&&(imc < 27.3)){
                        situacao = "Marginalmente acima do peso";
                    }else if ((imc > 27.3)&&(imc < 32.3)){
                        situacao = "Acima do peso ideal";
                    }else if(imc > 32.3) {
                        situacao = "Obesa";
                    }
                }


                if(sexo == 2){
                    imc = peso/pow(altura,2);
                    if(imc < 20.7){
                        situacao = "Abaixo do Peso";
                    }else if ((imc > 20.7 )&&(imc < 26.4)){
                        situacao = "No peso Normal";
                    }else if ((imc > 26.4)&&(imc < 27.8)){
                        situacao = "Marginalmente acima do peso";
                    }else if ((imc > 27.8)&&(imc < 31.1)){
                        situacao = "Acima do peso ideal";
                    }else if(imc > 31.1){
                        situacao = "Obeso";
                    }

                }
                break;
            case 0:
                situacao = "idade Inválida !!";
                break;

        }
        //saida
        edtIMC.setText(String.format("%.2f",imc));
        edtSituacao.setText(situacao);
    }


}