package infoglobo.com.br.infoglobo.domain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public class InfoContent extends BaseObservable {
    private ArrayList<Notice> conteudos;
    private String produto;

    @Bindable
    public ArrayList<Notice> getConteudos() {
        return conteudos;
    }

    public void setConteudos(ArrayList<Notice> conteudos) {
        this.conteudos = conteudos;
    }
    @Bindable
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
