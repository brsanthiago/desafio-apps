package infoglobo.com.br.infoglobo.domain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Bruno Santiago on 11/09/17.
 */
public class Notice extends BaseObservable implements Serializable{
    private boolean informePublicitario;
    private String subTitulo;
    private String texto;
    private int id;
    private String tipo;
    private String titulo;
    private String url;
    private String urlOriginal;
    private ArrayList<Images> imagens;
    private ArrayList<String> autores;
    private Section secao;
    private Date atualizadoEm;
    @Expose
    private String imgCapa = "";

    @Bindable
    public boolean isInformePublicitario() {
        return informePublicitario;
    }

    public void setInformePublicitario(boolean informePublicitario) {
        this.informePublicitario = informePublicitario;
    }

    @Bindable
    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    @Bindable
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Bindable
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bindable
    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    @Bindable
    public ArrayList<Images> getImagens() {
        return imagens;
    }

    public void setImagens(ArrayList<Images> imagens) {
        this.imagens = imagens;
    }

    @Bindable
    public Section getSecao() {
        return secao;
    }

    public void setSecao(Section secao) {
        this.secao = secao;
    }

    @Bindable
    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    @Bindable
    public Date getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @Bindable
    public String getImgCapa() {
        if (getImagens() != null && getImagens().size() > 0 ) {
            imgCapa = imagens.get(0).getUrl();
        }
        return imgCapa;
    }

    public String toJson() {
        Gson gson = new Gson();
        Type type = new TypeToken<Notice>() {}.getType();
        String json = gson.toJson(this, type);
        return json;
    }
}
