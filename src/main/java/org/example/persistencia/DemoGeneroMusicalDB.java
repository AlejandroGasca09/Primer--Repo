package org.example.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoGeneroMusicalDB {
    public DemoGeneroMusicalDB() {
    }
    public void insertStatement(){
        String elGenero = "Regional";
        String elArtista = "Juan Gabriel";
        int laEpoca = 1980;
        String elPais = "Mexico";

        try {
            Statement stm = ConexionSingleton.getInstance("GenerosMusicales.db").getConnection().createStatement();
            String sqlInsert = "INSERT INTO GenerosMusicales(genero,artista,epoca,pais) VALUES ('" + elGenero + "','" + elArtista + "','" + laEpoca + "','" + elPais + "')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("se insertaton: " + rowCount + " registros");
        } catch (SQLException sqle) {
            System.out.println("Error al concretar" + sqle.getMessage());
        }

    }
    public void insertPreparedStatement(){
        String elGenero = "Jazz";
        String elArtista = "Sebastian Wilder";
        int laEpoca = 2016;
        String elPais = "Estados Unidos";
        String sqlInsert = "INSERT INTO GenerosMusicales(generos,artista,epoca,pais) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("GenerosMusicales.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1, elGenero);
            pstm.setString(2, elArtista);
            pstm.setInt(3, laEpoca);
            pstm.setString(4, elPais);

            int rowCount = pstm.executeUpdate();
            System.out.println("se insertaton: " + rowCount + " registros");
        } catch (SQLException sqle) {
            System.out.println("Error prepared  statement" + sqle.getMessage());

        }

    }

}
