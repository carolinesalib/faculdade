package com.example.root.loginconsultaandroid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class CadastroService extends Service {

    public CadastroService() { super(); }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, CadastroActivity.class), 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Cadastro PDM")
                .setContentText("Toque aqui para cadastrar.")
                .setContentIntent(pi)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
