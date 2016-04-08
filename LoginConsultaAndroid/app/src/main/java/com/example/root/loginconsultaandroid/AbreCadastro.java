package com.example.root.loginconsultaandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AbreCadastro extends Service{

    public AbreCadastro() {super();}

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
