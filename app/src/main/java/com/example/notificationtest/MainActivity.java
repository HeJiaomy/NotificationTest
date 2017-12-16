package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(MainActivity.this, null)
                        .setContentTitle("This is Content Title")
//                        .setContentText("This is Content Text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pi)
//                        .setAutoCancel(true)  取消系统栏的图标
//                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg"))) //设置铃声
//                        .setVibrate(new long[]{0,1000,1000,1000})   //设置震动
//                        .setLights(Color.WHITE,1000,1000)   //设置LED灯
                        .setDefaults(NotificationCompat.DEFAULT_ALL)    //设置系统默认
                        //设置多文字
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn Notification,Learn Notification,Learn Notification,Learn Notification,Learn Notification,Learn Notification,Learn Notification,Learn Notification,Learn Notification,Learn Notification"))
                        //设置大图片
//                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round)))
                        .setPriority(NotificationCompat.PRIORITY_MAX)   //设置通知的重要程度
                        .build();
                manager.notify(1, notification);
                break;
        }
    }
}
