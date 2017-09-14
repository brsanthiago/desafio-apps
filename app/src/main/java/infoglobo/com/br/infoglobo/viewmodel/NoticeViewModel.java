package infoglobo.com.br.infoglobo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.google.gson.Gson;

import infoglobo.com.br.infoglobo.domain.di.InfoComponent;
import infoglobo.com.br.infoglobo.domain.model.Notice;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public class NoticeViewModel extends ViewModel implements InfoComponent.Injectable {
    private MutableLiveData<Notice> notice = new MutableLiveData<>();

    @Override
    public void inject(InfoComponent component) {
        component.inject(this);
    }

    public LiveData<Notice> parseNotice() {
        return notice;
    }

    public void transformToView(final String json) {
        Gson gson = new Gson();
        Notice transformed = gson.fromJson(json, Notice.class);
        notice.setValue(transformed);
        transformNotice();
    }

    public LiveData<Notice> transformNotice() {
        return notice;
    }
}
