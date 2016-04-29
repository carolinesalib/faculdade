package com.example.root.loginconsultaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ConsultaActivity extends Activity implements View.OnClickListener {

    private Button buttonSair;
    private EditText textNome;
    private EditText textIdade;
    private EditText textSexo;
    private SeekBar seekBarPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        inicializar();

        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("nome")){
            textNome.setText(bundle.getString("nome"));
        }

        if (bundle.containsKey("idade")) {
            textIdade.setText(bundle.getString("idade"));
        }

        if (bundle.containsKey("sexo")) {
            textSexo.setText(bundle.getString("sexo"));
        }

        if (bundle.containsKey("peso")) {
            seekBarPeso.setProgress(bundle.getInt("peso"));
        }
    }

    private void inicializar() {
        setReferences();
        setEvents();
    }

    private void setReferences() {
        buttonSair = (Button) findViewById(R.id.buttonSair);
        textNome = (EditText) findViewById(R.id.editTextNome);
        textIdade = (EditText) findViewById(R.id.editTextIdade);
        textSexo = (EditText) findViewById(R.id.editTextSexo);
        seekBarPeso = (SeekBar) findViewById(R.id.seekBarPeso);
    }

    private void setEvents() {
        buttonSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonSair) {
            Intent it = new Intent(this, HomeActivity.class);
            startActivity(it);
        }

    }
}
