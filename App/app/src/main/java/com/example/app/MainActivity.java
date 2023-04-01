package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.calculadora3.controller.telaCalc_3;
import com.example.app.calculadora_1.controller.telaCalc_1;
import com.example.app.calculadora_2.controller.telaCalc_2;
import com.example.app.calculadora_4.controller.telaCalc4;
import com.example.app.calculadora_5.controller.telaCalc_5;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void chamaTelaCalc1(View v){
        Intent intent = null;
        intent = new Intent(getApplicationContext(),telaCalc_1.class);
        startActivity(intent);
    }
    public void chamaTelaCalc2(View v){
        Intent intent = null;
        intent = new Intent(getApplicationContext(), telaCalc_2.class);
        startActivity(intent);
    }
    public void chamaTelaCalc3(View v){
        Intent intent = null;
        intent = new Intent(getApplicationContext(), telaCalc_3.class);
        startActivity(intent);
    }public void chamaTelaCalc4(View v){
        Intent intent = null;
        intent = new Intent(getApplicationContext(), telaCalc4.class);
        startActivity(intent);
    }
    public void chamaTelaCalc5(View v){
        Intent intent = null;
        intent = new Intent(getApplicationContext(), telaCalc_5.class);
        startActivity(intent);
    }


}