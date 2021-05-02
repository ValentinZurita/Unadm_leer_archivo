package vista;

import controlador.ControladorFormulario;

import javax.swing.*;
import java.awt.*;

public class VentanaPanel extends JPanel {

    JTextPane panelDeTexto;

    public JTextPane getPanelDeTexto() {
        return panelDeTexto;
    }

    public VentanaPanel(){

        //Establecemos el tipo de Layout
        setLayout(new BorderLayout());

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
        JMenuItem abrirArchivo = new JMenuItem("Abrir Archivo");
        JMenuItem guardarArchivo = new JMenuItem("Guardar como");

        //abrirArchivo.setFont(new Font("Arial", 1, 15));
        archivo.add(abrirArchivo);
        archivo.add(guardarArchivo);

        //Agregamos la barra de menus al panel
        add(menuBar, BorderLayout.NORTH);

        //Agregamos un JTextPane al panel
         panelDeTexto = new JTextPane();
        add(panelDeTexto, BorderLayout.CENTER);


        //------------------------------------------------ACCIONES--------------------------------------------------

        ControladorFormulario controladorFormulario = new ControladorFormulario();
        controladorFormulario.clickMenuArchivoArbrir(abrirArchivo, panelDeTexto);
        controladorFormulario.clickMenuArchivoGuardarComo(this, guardarArchivo, panelDeTexto);



    }

}
