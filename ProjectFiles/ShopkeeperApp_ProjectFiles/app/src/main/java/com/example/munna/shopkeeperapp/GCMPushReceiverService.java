package com.example.munna.shopkeeperapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by AbhishekSharma on 10/2/2016.
 */

public class GCMPushReceiverService extends GcmListenerService {
    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        String message=bundle.getString("message");
        String title=bundle.getString("title");
        String uname=bundle.getString("username");
        String umail=bundle.getString("umail");
        String ucntc=bundle.getString("contact");
        SharedPreferences.Editor editor = getSharedPreferences(getString(R.string.MY_PREFS_NAME), MODE_PRIVATE).edit();
        editor.putString("message", message);
        editor.putString("uname", uname);
        editor.putString("umail", umail);
        editor.putString("contact", ucntc);
        editor.commit();
        Log.v("Message receieved","Message"+message);
        sendNotification(message,title);
    }

    private void sendNotification(String message,String title){
        Intent i =new Intent( this, FinalPage.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        int requestCode=0;
        PendingIntent pendingIntent=PendingIntent.getActivity(this,requestCode,i,PendingIntent.FLAG_ONE_SHOT);

        Uri sound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mbuilder= (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("My msg ")
                    .setContentText(message)
                    .setContentTitle(title)
                    .setSound(sound)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,mbuilder.build());

    }
}
