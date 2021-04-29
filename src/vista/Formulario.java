package vista;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//-----------------------------------------------FORMULARIO-------------------------------------------------------------

public class Formulario {

    public static void main(String[] args) {

        MarcoFormulario marcoFormulario = new MarcoFormulario();

    }

}

//---------------------------------------------------MARCO--------------------------------------------------------------

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

//----------------------------------------------PANEL DEL MARCO---------------------------------------------------------
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

        //------------------------------------------------ACCIONES------------------------------------------------------

        abrirArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                File nombreDeArchivo = null;

                //Creamos un JFileChooser para poder elegir un archivo .txt
                JFileChooser selector = new JFileChooser();
                selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                //Creamos un filtro para seleccionar unicamente archivos .txt
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo txt", "txt");
                selector.setFileFilter(filtro);

                //Obtenemos la ruta del archivo seleccionado con JFileChooser
                int resultado = selector.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION){
                    nombreDeArchivo = selector.getSelectedFile();
                }

                try {
                    //lector leera el flujo de caracteres almacenado en la varibale nombreArchivo
                    FileReader lector = new FileReader(nombreDeArchivo);

                    //Leemos el texto del archivo desde el stream de caracteres
                    BufferedReader buffer = new BufferedReader(lector);

                    //Con el panelDeTexto leemos el stream y lo mostramos en el.
                    panelDeTexto.read(buffer, null);
                    panelDeTexto.requestFocus();

                    //Cerramos los streams
                    buffer.close();
                    lector.close();

                } catch (IOException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, exception);
                }

            }
        });

    }
}



