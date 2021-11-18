package com.example.olanome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_nome;
    Button bt_ok;
    TextView tv_nomeInserido;
    Spinner sp_sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome = findViewById(R.id.et_nome);
        bt_ok = findViewById(R.id.bt_ok);
        tv_nomeInserido = findViewById(R.id.tv_nomeInserido);
        sp_sexo = findViewById(R.id.sp_sexo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.sexo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_sexo.setAdapter(adapter);

        final String[] sexo = new String[1];

        sp_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sexo[0] = parent.getItemAtPosition(position).toString();
                escondeTeclado(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = et_nome.getText().toString();
                if (sexo[0].equals("Masculino")) {
                    tv_nomeInserido.setText("Olá, Bem vindo " + nome);
                } else {
                    tv_nomeInserido.setText("Olá, Bem vinda " + nome);
                }
                escondeTeclado(v);
            }
        });

    }

    private void escondeTeclado(View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager)
                    getSystemService(MainActivity.this.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}