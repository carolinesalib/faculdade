package com.example.root.loginconsultaandroid;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class ConsultaService extends IntentService {

    private NotificationManager notificationManager;
    private Notification notification;
    private PendingIntent pi;

    public ConsultaService() {
        super("ConsultaService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (notificationManager == null)
            createNotification();

        if (intent.hasExtra("nome") && intent.hasExtra("idade")) {
            updateNotification("Nome: " +intent.getStringExtra("nome")+" Idade: "+intent.getStringExtra("idade"));
        }
    }

    protected void updateNotification(String text) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText(text);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        notificationManager.notify(1, builder.build());
    }

    protected void createNotification() {
        pi = PendingIntent.getActivity(this, 0, new Intent(this, CadastroActivity.class), Intent.FLAG_ACTIVITY_NEW_TASK);
        notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Cadastro PDM")
                .setContentText("Toque aqui para visualizar.")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

}
