package vista;

import controlador.ControladorFormulario;
import javax.swing.*;
import java.awt.*;


//-----------------------------------------------FORMULARIO-------------------------------------------------------------

public class Formulario {

    public Formulario(){

        MarcoFormulario marcoFormulario = new MarcoFormulario();
    }


    //---------------------------------------------------MARCO----------------------------------------------------------

    class MarcoFormulario extends JFrame {

        public MarcoFormulario(){

            //Definimos el tamaño y posicion del marco
            setBounds(50, 50, 800, 600);

            //Accion al cerrar
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Titulo del marco
            setTitle("Lector De Archivos .txt");

            //Agregamos el panel al marco
            add(new PanelFormulario());

            //Lo volvemos visible
            setVisible(true);
        }

    }


    //----------------------------------------------PANEL DEL MARCO-----------------------------------------------------

    class PanelFormulario extends JPanel{

        JMenuItem abrirArchivo;

        public PanelFormulario(){

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
            abrirArchivo = new JMenuItem("Abrir Archivo");
            //abrirArchivo.setFont(new Font("Arial", 1, 15));
            archivo.add(abrirArchivo);

            //Agregamos la barra de menus al panel
            add(menuBar, BorderLayout.NORTH);

            //Agregamos un JTextPane al panel
            JTextPane panelDeTexto = new JTextPane();
            add(panelDeTexto, BorderLayout.CENTER);


            //------------------------------------------------ACCIONES--------------------------------------------------

            ControladorFormulario controladorFormulario = new ControladorFormulario();
            controladorFormulario.clickMenuArchivoArbrir(abrirArchivo, panelDeTexto);

        }
    }


}

