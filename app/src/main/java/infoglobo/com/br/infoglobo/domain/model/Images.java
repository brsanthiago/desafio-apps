package infoglobo.com.br.infoglobo.domain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public class Images extends BaseObservable {
    private String autor;
    private String fonte;
    private String legenda;
    private String url;

    @Bindable
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    @Bindable
    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
    @Bindable
    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }
    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
