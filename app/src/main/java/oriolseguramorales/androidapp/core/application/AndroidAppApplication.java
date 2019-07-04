package oriolseguramorales.androidapp.core.application;

import android.app.Application;

import oriolseguramorales.androidapp.core.api.AppComponent;
import oriolseguramorales.androidapp.core.api.DaggerAppComponent;

public class AndroidAppApplication extends Application {

    private AppComponent appComponent;

    public AndroidAppApplication(){
        appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
