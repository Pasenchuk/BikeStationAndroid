package ucsoftworks.com.bikestation;

import android.app.Application;
import android.util.Log;

import com.squareup.otto.Bus;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import dagger.ObjectGraph;
import ucsoftworks.com.bikestation.modules.AppModule;
import ucsoftworks.com.bikestation.modules.MockAppModule;

/**
 * Created by Pasenchuk Victor on 31.07.14
 */
public class BikeApp extends Application {

    private ObjectGraph objectGraph;

    @Inject
    Bus bus;


    final Timer timer = new Timer();

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new MockAppModule(), new AppModule());
        injectToObjectGraph(this);

        set30SecTimer();
    }

    public void injectToObjectGraph(Object object) {
        objectGraph.inject(object);
    }

    private void set30SecTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i("timer", "t");
            }
        }, 0, 30000);
    }


    public void onTerminate() {
        timer.cancel();
    }

}
