package com.example.trafficlight;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CounterService extends Service {
    public CounterService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}