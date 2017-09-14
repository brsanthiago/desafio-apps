package infoglobo.com.br.infoglobo.domain.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import infoglobo.com.br.infoglobo.InfoApp;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public class InfoFactory extends ViewModelProvider.NewInstanceFactory {
    private InfoApp app;

    public InfoFactory(InfoApp app) {
        this.app = app;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T generic = super.create(modelClass);
        if (generic instanceof InfoComponent.Injectable) {
            ((InfoComponent.Injectable)generic).inject(app.getComponent());
        }
        return generic;
    }
}
