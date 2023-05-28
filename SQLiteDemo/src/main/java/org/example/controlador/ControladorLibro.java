package org.example.controlador;

import org.example.modelo.Libro;
import org.example.modelo.ModeloTablaLibro;
import org.example.vista.VentanaLibro;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorLibro extends MouseAdapter {
    private VentanaLibro view;
    private ModeloTablaLibro modelo;

    public ControladorLibro() {

    }

    public ControladorLibro(VentanaLibro view) {
        this.view = view;
        modelo = new ModeloTablaLibro();
        this.view.getTblLibro().setModel(modelo);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == this.view.getBtnAgregar()) {
            modelo = new ModeloTablaLibro();
            modelo.cargarDatos();
            this.view.getTblLibro().setModel(modelo);
            this.view.getTblLibro().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()){
            Libro libro = new Libro();
            libro.setId(0);
            libro.setTitulo(this.view.getTxtTitulo().getText());
            libro.setAutor(this.view.getTxtAutor().getText());
            if(modelo.agregarLibro(libro)){
                JOptionPane.showMessageDialog(view,"Se agrego");
                this.view.getTblLibro().updateUI();
            }else{
                JOptionPane.showMessageDialog(view,"No se pudo agregar");
            }

        }

    }

}
