package com.example.root.loginconsultaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Button buttonSalvar;
    private EditText editNome;
    private EditText editIdade;
    private Spinner spinnerSexo;
    private SeekBar seekBarPeso;
    private CheckBox checkboxPergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializar();

        Spinner spinner = (Spinner) findViewById(R.id.spinnerSexo);

        spinner.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<>();
        categories.add("Feminino");
        categories.add("Masculino");
        categories.add("Outros");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    private void inicializar() {
        setReferences();
        setEvents();
    }


    private void setReferences() {
        buttonSalvar     = (Button)findViewById(R.id.buttonSalvar);
        editNome         = (EditText)findViewById(R.id.editTextNome);
        editIdade        = (EditText)findViewById(R.id.editTextIdade);
        spinnerSexo      = (Spinner)findViewById(R.id.spinnerSexo);
        seekBarPeso      = (SeekBar)findViewById(R.id.seekBarPeso);
        checkboxPergunta = (CheckBox)findViewById(R.id.checkBox);
    }

    private void setEvents() {
        buttonSalvar.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonSalvar) {
            Intent it = new Intent(this, ConsultaActivity.class);
            it.putExtra("nome", editNome.getText().toString());
            it.putExtra("idade", editIdade.getText().toString());
            it.putExtra("sexo", spinnerSexo.getSelectedItem().toString());
            it.putExtra("peso", seekBarPeso.getProgress());
            it.putExtra("pergunta", checkboxPergunta.isChecked());
            startActivity(it);
        }

    }
}
