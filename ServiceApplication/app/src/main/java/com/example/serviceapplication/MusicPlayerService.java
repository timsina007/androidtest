package com.example.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;


public class MusicPlayerService extends Service {

    MediaPlayer mPlayer;

    public MusicPlayerService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Music Player Service Started",
                Toast.LENGTH_SHORT).show();

        mPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mPlayer.setLooping(true);
        mPlayer.start();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}