package infoglobo.com.br.infoglobo.domain.di;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import infoglobo.com.br.infoglobo.InfoApp;
import infoglobo.com.br.infoglobo.domain.api.InfoApi;
import infoglobo.com.br.infoglobo.domain.api.InfoService;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

@Module
public class InfoModule {
    private InfoApp app;

    public InfoModule(InfoApp app) {
        this.app = app;
    }

    @Provides
    public Context getApplicationContext() {
        return app;
    }
    @Provides
    @Singleton
    public InfoApi geApi() {
        return new InfoApi();
    }

    @Provides
    @Singleton
    public InfoService gitHubService() {
        return geApi().provideApi().create(InfoService.class);
    }
}
