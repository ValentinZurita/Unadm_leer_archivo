package vista;

import controlador.ControladorDialogEscribir;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DialogEscribir extends JDialog {

    public JTextArea textArea;
    public File file;

    public DialogEscribir() {

        //Definimos tamaño y titulo
        setSize(500, 300);
        setTitle("Escribir archivo");

        //Establecemos el tipo de Layout
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Creamos la barra de menus
        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Arial", 1, 30));

        //Creamos los menus que iran dentro de la barra de menus
        JMenu archivo = new JMenu("Archivo");

        //Ajustamos el tamaño de la fuente para el menu
        archivo.setFont(new Font("Arial", 4, 18));

        //Agregamos el menu a la barra de menus
        menuBar.add(archivo);

        //Creamos el menu item "abrir archivo" para el menu "archivo"
        JMenuItem guardar = new JMenuItem("Guardar");

        //abrirArchivo.setFont(new Font("Arial", 1, 15));
        archivo.add(guardar);

        //Agregamos la barra de menus al panel
        add(menuBar, BorderLayout.NORTH);

        //Agregamos un JTextPane al panel
        textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
        add(menuBar, BorderLayout.NORTH);

        //Controlador
        ControladorDialogEscribir ctrl = new ControladorDialogEscribir();
        ctrl.onClose(this);
        ctrl.guardar(guardar, this);

    }
}
