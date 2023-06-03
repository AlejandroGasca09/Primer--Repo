package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    private JButton btnMensaje;
    private JButton btnEntrada;
    private JButton btbOpcion;
    private JLabel  lblResultado;
    private FlowLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.getContentPane().setLayout(new FlowLayout());
        btnMensaje = new JButton("mensaje");
        btnEntrada =new JButton("entrada");
        btbOpcion = new JButton("opcion");
        lblResultado = new JLabel("Resultado");

        this.getContentPane().add(btnMensaje);
        this.getContentPane().add(btnEntrada);
        this.getContentPane().add(btbOpcion);
        this.getContentPane().add(lblResultado);

        this.setSize(450,450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JButton getBtnMensaje() {
        return btnMensaje;
    }

    public void setBtnMensaje(JButton btnMensaje) {
        this.btnMensaje = btnMensaje;
    }

    public JButton getBtnEntrada() {
        return btnEntrada;
    }

    public void setBtnEntrada(JButton btnEntrada) {
        this.btnEntrada = btnEntrada;
    }

    public JButton getBtnOpcion() {
        return btbOpcion;
    }

    public void setBtnOpcion(JButton btnOpcion) {
        this.btbOpcion = btnOpcion;
    }

    public JLabel getLblResultado() {
        return lblResultado;
    }

    public void setLblResultado(JLabel lblResultado) {
        this.lblResultado = lblResultado;
    }
}