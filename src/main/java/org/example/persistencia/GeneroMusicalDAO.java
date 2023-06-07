package org.example.persistencia;

import org.example.Modelo.GeneroMusical;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GeneroMusicalDAO implements InterfazDAO{


    public GeneroMusicalDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "GeneroMusical ( genero,artista,epoca,pais,URL) VALUES (?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("GenerosMusicales.db").getConnection().prepareStatement(sqlInsert);
        pstm = ConexionSingleton.getInstance("GenerosMusicales.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((GeneroMusical)obj).getGenero());
        pstm.setString(2, ((GeneroMusical)obj).getArtista());
        pstm.setInt(3, ((GeneroMusical)obj).getEpoca());
        pstm.setString(4, ((GeneroMusical)obj).getPais());
        pstm.setString(5, ((GeneroMusical)obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE GenerosMusicales SET genero = ? artista = ? epoca =? pais =? URL =? WHERE id = ?";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("GenerosMusicalesDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((GeneroMusical)obj).getGenero());
        pstm.setString(2, ((GeneroMusical)obj).getArtista());
        pstm.setInt(3, ((GeneroMusical)obj).getEpoca());
        pstm.setString(4, ((GeneroMusical)obj).getPais());
        pstm.setString(5, ((GeneroMusical)obj).getURL());
        pstm.setInt(6, ((GeneroMusical)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM GenerosMusicales WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("GenerosMusicales.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM GenerosMusicales";
        ArrayList<GeneroMusical> restultado = new ArrayList<>();

        Statement stn = ConexionSingleton.getInstance("GenerosMusicales.db").getConnection().createStatement();
        ResultSet rst = stn.executeQuery(sql);
        while (rst.next()){
            restultado.add(new GeneroMusical(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6)));

        }

        return  restultado;

    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM GenerosMusicales WHERE id = ? ;";
        GeneroMusical generoMusical = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("GeneroMusicales.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if(rst.next()){
            GeneroMusical GeneroMusical = new GeneroMusical(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6));
            return GeneroMusical;
        }
        return null;

    }
}
