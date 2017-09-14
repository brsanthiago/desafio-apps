package infoglobo.com.br.infoglobo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import infoglobo.com.br.infoglobo.domain.api.InfoService;
import infoglobo.com.br.infoglobo.domain.di.InfoComponent;
import infoglobo.com.br.infoglobo.domain.model.InfoContent;
import infoglobo.com.br.infoglobo.domain.model.Notice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public class NoticesViewModel extends ViewModel implements InfoComponent.Injectable {
    @Inject
    InfoService infoService;
    private MutableLiveData<String> produto = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Notice>> notices = new MutableLiveData<>();

    @Override
    public void inject(InfoComponent component) {
        component.inject(this);
    }

    public LiveData<ArrayList<Notice>> findAll() {
        return notices;
    }

    public void findNotices() {
        infoService.findNotices().enqueue(new Callback<ArrayList<InfoContent>>() {
            @Override
            public void onResponse(Call<ArrayList<InfoContent>> call, Response<ArrayList<InfoContent>> response) {
                if (response.isSuccessful()) {
                    final InfoContent infoContent = response.body().get(0);
                    notices.setValue(infoContent.getConteudos());
                    produto.setValue(infoContent.getProduto());
                }
                findAll();
                getProduto();
            }

            @Override
            public void onFailure(Call<ArrayList<InfoContent>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<String> getProduto() {
        return produto;
    }
}
