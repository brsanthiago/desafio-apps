package infoglobo.com.br.infoglobo;

import android.app.Application;

import infoglobo.com.br.infoglobo.domain.di.DaggerInfoComponent;
import infoglobo.com.br.infoglobo.domain.di.InfoComponent;
import infoglobo.com.br.infoglobo.domain.di.InfoModule;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public class InfoApp extends Application {
    private InfoComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerInfoComponent.builder().infoModule(new InfoModule(this)).build();
    }

    public InfoComponent getComponent() {
        return component;
    }
}
