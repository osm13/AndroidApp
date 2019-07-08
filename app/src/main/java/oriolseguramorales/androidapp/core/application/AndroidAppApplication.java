package oriolseguramorales.androidapp.core.application;

import android.app.Application;

import oriolseguramorales.androidapp.core.di.AppComponent;
import oriolseguramorales.androidapp.core.di.DaggerAppComponent;

public class AndroidAppApplication extends Application {

    private AppComponent appComponent;

    public AndroidAppApplication(){
        appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
