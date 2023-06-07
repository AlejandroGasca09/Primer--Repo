package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GeneroMusical {
    private int Id;
    private String genero;
    private String artista;
    private int epoca;
    private String pais;
    private String URL;

    public GeneroMusical() {
    }

    public GeneroMusical(int id, String genero, String artista, int epoca, String pais, String URL) {
        Id = id;
        this.genero = genero;
        this.artista = artista;
        this.epoca = epoca;
        this.pais = pais;
        this.URL = URL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getEpoca() {
        return epoca;
    }

    public void setEpoca(int epoca) {
        this.epoca = epoca;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "GeneroMusical{" +
                "Id=" + Id +
                ", genero='" + genero + '\'' +
                ", artista='" + artista + '\'' +
                ", epoca=" + epoca +
                ", pais='" + pais + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
    public ImageIcon getImagen () throws MalformedURLException {
        URL urlimagen = new URL(this.URL);
        return  new ImageIcon(urlimagen);
    }
}
