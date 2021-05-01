package vista;

import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana(JPanel jPanel){

        //Definimos el tamaño y posicion del marco
        setBounds(50, 50, 800, 600);

        //Accion al cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Titulo del marco
        setTitle("Lector De Archivos .txt");

        //Agregamos el panel al marco
        add(jPanel);

        //Lo volvemos visible
        setVisible(true);

    }

}
