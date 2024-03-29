package org.example.modelo;

import org.example.conexion.GeneroMusicalDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaGenero implements TableModel {
    public static final int COLUMS = 6;

    private ArrayList<GeneroMusical> datos;
    private GeneroMusicalDAO GMDao;

    public ModeloTablaGenero() {
        GMDao = new GeneroMusicalDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaGenero(ArrayList<GeneroMusical> datos) {
        this.datos = datos;
        GMDao = new GeneroMusicalDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return "Id";

            case 1:
                return "Genero";

            case 2:
                return "Artista";
            case 3:
                return "Album";
            case 4:
                return "Pais";
            case 5:
                return "URL";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return Integer.class;

            case 1:
                return String.class;

            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GeneroMusical tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getGenero();
            case 2:
                return tmp.getArtista();
            case 3:
                return tmp.getAlbum();
            case 4:
                return tmp.getPais();
            case 5:
                return tmp.getURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int colIndex) {
        switch (colIndex) {
            case 0:
                //datos.get(rowIndex).setId(0);
                break;
            case 1:
                datos.get(rowIndex).setGenero((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setArtista((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setAlbum((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setPais((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setURL((String) aValue);
                break;
            default:
                System.out.println("No se modifica Nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
        try {
            ArrayList<GeneroMusical> tirar = GMDao.obtenerTodo();
            System.out.println(tirar);
            datos = GMDao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

    }

    public boolean agregarGenero(GeneroMusical generoMusical) {
        boolean resulatdo = false;
        try {
            if (GMDao.insertar(generoMusical)) {
                datos.add(generoMusical);
                resulatdo = true;
            } else {
                resulatdo = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resulatdo;

    }

    public GeneroMusical getGeneroMusicalAtIndex(int ind) {
        return datos.get(ind);
    }

    public GeneroMusical getGeneroMusical(int ind) {
        return datos.get(ind);
    }
}

