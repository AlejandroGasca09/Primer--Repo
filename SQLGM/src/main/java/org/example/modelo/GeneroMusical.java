package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

    public class GeneroMusical {
        private int Id;
        private String genero;
        private String artista;
        private String album;
        private String pais;
        private String URL;

        public GeneroMusical() {
        }

        public GeneroMusical(int id, String genero, String artista, String album, String pais, String URL) {
            Id = id;
            this.genero = genero;
            this.artista = artista;
            this.album = album;
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

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
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
                    ", album='" + album + '\'' +
                    ", pais='" + pais + '\'' +
                    ", URL='" + URL + '\'' +
                    '}';
        }

        public ImageIcon getImagen() throws MalformedURLException {
            URL urlimagen = new URL(this.URL);
            return new ImageIcon(urlimagen);
        }}
