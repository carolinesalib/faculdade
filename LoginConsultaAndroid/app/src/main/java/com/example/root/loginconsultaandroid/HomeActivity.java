package com.example.root.loginconsultaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity implements View.OnClickListener {

    private Button buttonCadastro;
    private Button buttonConsulta;
    private Button buttonSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        setReferences();
        inicializar();
    }

    private void inicializar() {
        setReferences();
        setEvents();
    }

    private void setReferences() {
        buttonCadastro = (Button) findViewById(R.id.buttonCadastro);
    }

    private void setEvents() {
        buttonCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

//        startService(new Intent(CadastroActivity.this, AbreCadastro.class));

        if (v.getId() == R.id.buttonCadastro) {
            Intent it = new Intent(this, CadastroActivity.class);
            startActivity(it);
        }

    }


}
