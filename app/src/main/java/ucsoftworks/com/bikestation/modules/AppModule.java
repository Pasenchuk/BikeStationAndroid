package ucsoftworks.com.bikestation.modules;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ucsoftworks.com.bikestation.application.BikeApp;
import ucsoftworks.com.bikestation.main_screen.MainActivity;
import ucsoftworks.com.bikestation.web_service.BikeApi;
import ucsoftworks.com.bikestation.web_service.BikeServiceApi;

/**
 * Created by Pasenchuk Victor on 28.07.14 in IntelliJ Idea
 */

@Module(injects = {BikeApp.class, MainActivity.class})
public class AppModule {
    @Provides
    @Singleton
    BikeServiceApi provideBikeService() {
        return new BikeApi();
    }


    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }

}
