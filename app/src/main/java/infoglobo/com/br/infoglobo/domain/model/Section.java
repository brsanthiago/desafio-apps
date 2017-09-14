package infoglobo.com.br.infoglobo.domain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Bruno Santiago on 11/09/17.
 */
public class Section extends BaseObservable {
    private String nome;
    private String url;

    @Bindable
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
