package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(){

        //Definimos el tamaño y posicion del marco
        setBounds(50, 50, 350, 400);

        //Accion al cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Titulo del marco
        setTitle("DPO3_U1_EA_VAPZ");

        //Creamos el panel
        JPanel panel = new JPanel(new GridLayout(5,1));

        //Cremos los botones para las acciones
        JButton botonCrear = new JButton("Crear");
        JButton botonLeer = new JButton("Leer");
        JButton botonEscribir = new JButton("Escribir");
        JButton botonRenombrar = new JButton("Renombrar");
        JButton botonEliminar = new JButton("Eliminar");

        //Agregamos los botones al panel
        panel.add(botonCrear);
        panel.add(botonLeer);
        panel.add(botonEscribir);
        panel.add(botonRenombrar);
        panel.add(botonEliminar);

        //Agregamos el panel al marco
        add(panel);

        //Lo volvemos visible
        setVisible(true);

        //Controlador
        Controlador ctrl = new Controlador();
        ctrl.clickBotonCrear(botonCrear, this);
        ctrl.clickBotonLeer(botonLeer, new DialogLeer(this, true));
        ctrl.clickBotonEscribir(botonEscribir, new DialogEscribir());
        ctrl.clickBotonRenombrar(botonRenombrar, this);

    }

}
