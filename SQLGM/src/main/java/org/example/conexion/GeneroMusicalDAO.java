package org.example.conexion;

import org.example.modelo.GeneroMusical;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GeneroMusicalDAO implements InterfazDAO {

    public GeneroMusicalDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO GenerosMusicales(genero,artista,album,pais,URL) VALUES(?, ?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = conexion.getInstance("GenerosMusicalesDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((GeneroMusical) obj).getGenero());
        pstm.setString(2, ((GeneroMusical) obj).getArtista());
        pstm.setString(3, ((GeneroMusical) obj).getAlbum());
        pstm.setString(4, ((GeneroMusical) obj).getPais());
        pstm.setString(5, ((GeneroMusical) obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE GenerosMusicales SET genero = ? artista = ? album =? pais =? URL =? WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = conexion.getInstance("GenerosMusicalesDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((GeneroMusical) obj).getGenero());
        pstm.setString(2, ((GeneroMusical) obj).getArtista());
        pstm.setString(3, ((GeneroMusical) obj).getAlbum());
        pstm.setString(4, ((GeneroMusical) obj).getPais());
        pstm.setString(5, ((GeneroMusical) obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM generosmusicales WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = conexion.getInstance("GenerosMusicalesDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM generosmusicales";
        ArrayList<GeneroMusical> restultado = new ArrayList<>();

        Statement stn = conexion.getInstance("GenerosMuicalesDB.db").getConnection().createStatement();
        ResultSet rst = stn.executeQuery(sql);
        while (rst.next()) {
            restultado.add(new GeneroMusical(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));

        }

        return restultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM generoMusical WHERE id = ? ;";
        GeneroMusical generoMusical = null;
        PreparedStatement pstm = conexion.getInstance("GeneroMusicalesDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            generoMusical = new GeneroMusical(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));

            return generoMusical;
        }
        return null;
    }
}
