package com.example.root.loginconsultaandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

    private Button buttonLogin;
    private String user;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        setReferences();
        setEvents();
    }

    private void setReferences() {
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
    }

    private void setEvents() {
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        user = ((EditText) findViewById(R.id.editTextUser)).getText().toString();
        pass = ((EditText) findViewById(R.id.editTextPass)).getText().toString();

        if (user.equals("admin") && pass.equals("admin")) {

        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Erro ao logar")
                    .setMessage("Não foi possível efetuar o login")
                    .setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
