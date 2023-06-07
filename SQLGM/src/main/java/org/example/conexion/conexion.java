package org.example.conexion;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    private String baseDatos;
    public static conexion _instance;
    private Connection connection;

    private conexion(String database) {
        this.baseDatos = database;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static conexion getInstance(String baseDatos) {
        if(_instance == null){
            _instance = new conexion(baseDatos);
        }else{
            System.out.println("Ya fué creada.");
        }
        return _instance;
    }


    public Connection getConnection() {
        return connection;
    }

}
