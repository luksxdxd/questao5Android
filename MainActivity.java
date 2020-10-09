package com.example.questao5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnImc, btnCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregarTela();
    }

    public void CarregarTela(){
        setContentView(R.layout.activity_main);

        btnImc = findViewById(R.id.btnImc);
        btnImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaImc();
            }
        });

        btnCelsius = findViewById(R.id.btnCelsius);
        btnCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaCelsius();
            }
        });
    }

    public void CarregarTelaImc() {
        setContentView(R.layout.calc_imc);

        Button btnCalcular, btnVoltar;

        btnCalcular = findViewById(R.id.btnCalcular);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtAltura, edtPeso;
                edtAltura = findViewById(R.id.edtAltura);
                edtPeso = findViewById(R.id.edtPeso);

                Double alturas = Double.parseDouble(edtAltura.getText().toString());
                Double pesos = Double.parseDouble(edtPeso.getText().toString());
                Double total = pesos/(alturas*alturas);

                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Calculo de IMC");
                alerta.setMessage("Seu IMC é: " + total);
                alerta.setNeutralButton("OK", null);
                alerta.show();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTela();
            }
        });
    }

    public void CarregarTelaCelsius(){
        setContentView(R.layout.calc_celsius);

        Button btnCall, btnVoltar;

        btnCall = findViewById(R.id.btnCall);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtFare;
                TextView txtInfo, txtInfos;

                edtFare = findViewById(R.id.edtFare);
                txtInfo = findViewById(R.id.txtInfo);
                txtInfos = findViewById(R.id.txtInfos);

                Double faren = Double.parseDouble(edtFare.getText().toString());
                Double totalf = faren*1.8+32;

                txtInfo.setVisibility(View.VISIBLE);
                txtInfos.setVisibility(View.VISIBLE);
                txtInfos.setText("O gráu em fahrenheit: " + totalf);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTela();
            }
        });
    }
}
