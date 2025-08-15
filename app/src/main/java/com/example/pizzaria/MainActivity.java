package com.example.pizzaria;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNomeCliente, etTelefone, etSabor, etRua, etBairro, etNumero, etObservacao;
    Spinner spTipoPizza, spTipoBorda, spCidade;
    CheckBox cbQueijoExtra, cbSemGluten;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNomeCliente = findViewById(R.id.etNomeCliente);
        etTelefone = findViewById(R.id.etTelefone);
        etSabor = findViewById(R.id.etSabor);
        etRua = findViewById(R.id.etRua);
        etBairro = findViewById(R.id.etBairro);
        etNumero = findViewById(R.id.etNumero);
        etObservacao = findViewById(R.id.etObservacao);

        spTipoPizza = findViewById(R.id.spTipoPizza);
        spTipoBorda = findViewById(R.id.spTipoBorda);
        spCidade = findViewById(R.id.spCidade);

        cbQueijoExtra = findViewById(R.id.cbQueijoExtra);
        cbSemGluten = findViewById(R.id.cbSemGluten);

        btnEnviar = findViewById(R.id.btnEnviar);




        //esse o da cidade

        List<String> cidades = new ArrayList<>();
        cidades.add("-- SELECIONE --"); //nao pode
        cidades.add("Ivoti");
        cidades.add("Estância Velha");
        cidades.add("Novo Hamburgo");

        ArrayAdapter<String> adapterCidade = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, cidades) {

            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }
        };

        adapterCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCidade.setAdapter(adapterCidade);
        spCidade.setSelection(0);




        // esse o do tipo da pizza

        List<String> TipoPizza = new ArrayList<>();
        TipoPizza.add("-- SELECIONE --"); //nao pode
        TipoPizza.add("Massa Fina");
        TipoPizza.add("Tradicional");
        TipoPizza.add("Massa Grossa");

        ArrayAdapter<String> adapterTipoPizza = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, TipoPizza) {

            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }
        };

        adapterTipoPizza.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoPizza.setAdapter(adapterTipoPizza);
        spTipoPizza.setSelection(0);




        // esse o do tipo da borda

        List<String> TipoBorda = new ArrayList<>();
        TipoBorda.add("-- SELECIONE --"); //nao pode - 0
        TipoBorda.add("Sem Borda");
        TipoBorda.add("Sem Borda Recheada");
        TipoBorda.add("-- SABORES SALGADOS --"); //nao pode - 3
        TipoBorda.add("Borda com Catupiri");
        TipoBorda.add("Borda com Cheddar");
        TipoBorda.add("Borda com Cream cheese");
        TipoBorda.add("-- SABORES DOCES --"); //nao pode - 7
        TipoBorda.add("Borda com Chocolate ao leite");
        TipoBorda.add("Borda com Chocolate branco");
        TipoBorda.add("Borda com Nutella");


        ArrayAdapter<String> adapterTipoBorda = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, TipoBorda) {

            @Override
            public boolean isEnabled(int position) {
                return position != 0 && position != 3 && position != 7;
            }
        };

        adapterTipoBorda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoBorda.setAdapter(adapterTipoBorda);
        spTipoBorda.setSelection(0);



        // botao de fazer o pedido
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etNomeCliente.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe o nome do cliente", Toast.LENGTH_SHORT).show();
                }
                else if (etTelefone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe o telefone", Toast.LENGTH_SHORT).show();
                }
                else if (etSabor.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe o sabor da pizza", Toast.LENGTH_SHORT).show();
                }
                else if (etRua.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe a rua", Toast.LENGTH_SHORT).show();
                }
                else if (etBairro.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe o bairro", Toast.LENGTH_SHORT).show();
                }
                else if (etNumero.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe o número", Toast.LENGTH_SHORT).show();
                }
                else if (spCidade.getSelectedItemPosition() == 0) {
                    Toast.makeText(MainActivity.this, "Selecione a cidade", Toast.LENGTH_SHORT).show();
                }
                else if (spTipoPizza.getSelectedItemPosition() == 0) {
                    Toast.makeText(MainActivity.this, "Selecione o tipo da pizza", Toast.LENGTH_SHORT).show();
                }
                else if (spTipoBorda.getSelectedItemPosition() == 0 || spTipoBorda.getSelectedItemPosition() == 3 || spTipoBorda.getSelectedItemPosition() == 7) {
                    Toast.makeText(MainActivity.this, "Selecione um tipo válido de borda", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Pedido enviado - Aguarde confirmação no zap zap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}