package vista;

import controlador.ControladorPanelPrincipal;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    public PanelPrincipal(){

        //Establecemos el Layout
        setLayout(new GridLayout(5,1,8,8));

        //Creamos los botones
        JButton botonCrear = new JButton("Crear");
        JButton botonLeer = new JButton("Leer");
        JButton botonEscribir = new JButton("Escribir");
        JButton botonRenombrar = new JButton("Renombrar");
        JButton botonEliminar = new JButton("Eliminar");

        //Agregamos los botones
        add(botonCrear);
        add(botonLeer);
        add(botonEscribir);
        add(botonRenombrar);
        add(botonEliminar);

        ControladorPanelPrincipal ctrl = new ControladorPanelPrincipal();
        ctrl.clickBotonCrear(botonCrear, this);

    }


}
