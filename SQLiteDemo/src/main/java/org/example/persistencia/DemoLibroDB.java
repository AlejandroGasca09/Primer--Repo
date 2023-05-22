package org.example.persistencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoLibroDB {
    public DemoLibroDB() {
    }

    public void insertStatement() {
        String elTitulo = "Arracame la vida";
        String elAutor = "Angeles de Matreta";
        try {
            Statement stm = ConexionSingleton.getInstance("LibrosDB.db").getConnection().createStatement();
            String sqlInsert = "INSERT INTO libros(titulo,autor) VALUES ('" + elTitulo + "','" + elAutor + "')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("se insertaton: " + rowCount + " registros");
        } catch (SQLException sqle) {
            System.out.println("Error al concretar" + sqle.getMessage());
        }


    }

    public void insertPreparedStatement() {
        String elTitulo = "El principito";
        String elAutor = "No me acuerdo";
        String sqlInsert = "INSERT INTO libros(titulo,autor) VALUES (?,?)";
        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("librosDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1, elTitulo);
            pstm.setString(2, elAutor);
            int rowCount = pstm.executeUpdate();
            System.out.println("se insertaton: " + rowCount + " registros");
        } catch (SQLException sqle) {
            System.out.println("Error prepared  statement" + sqle.getMessage());

        }

    }
}
