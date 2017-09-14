package infoglobo.com.br.infoglobo.domain.di;

import javax.inject.Singleton;
import dagger.Component;
import infoglobo.com.br.infoglobo.viewmodel.NoticeViewModel;
import infoglobo.com.br.infoglobo.viewmodel.NoticesViewModel;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

@Singleton
@Component(modules = {InfoModule.class})
public interface InfoComponent {

    void inject(NoticeViewModel viewModel);
    void inject(NoticesViewModel viewModel);

    interface Injectable {
        void inject(InfoComponent component);
    }
}
