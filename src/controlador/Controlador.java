package controlador;

import vista.DialogEscribir;
import vista.DialogLeer;
import vista.Ventana;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Controlador {

    public void clickBotonCrear(JButton button, Ventana frame){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Varible para almacenar la direccion de nuestro archivo
                String direccionDelArchivo = null;

                //Obtenemos el nombre y directorio donde se guardara el archivo
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Guardar como");

                int seleccionDelUsuario = fileChooser.showSaveDialog(frame);

                if (seleccionDelUsuario == JFileChooser.APPROVE_OPTION){
                    File archivoxGuardar = fileChooser.getSelectedFile();
                    direccionDelArchivo = archivoxGuardar.getAbsolutePath();
                }

                //Creamos el archivo y guardamos el texto que se haya escrito en el
                try {
                    FileWriter fileWriter = new FileWriter(direccionDelArchivo);
                    fileWriter.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        });
    }

    public void clickBotonLeer(JButton button, DialogLeer dialogLeer){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Nuestro archivo a leer
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

                //Probamos
                try {

                    //Area de texto para nuestro archivo
                    JTextArea textArea = new JTextArea();

                    //lector leera el flujo de caracteres almacenado en la varibale nombreArchivo
                    FileReader lector = new FileReader(nombreDeArchivo);

                    //Leemos el texto del archivo desde el stream de caracteres
                    BufferedReader buffer = new BufferedReader(lector);

                    //Con el panelDeTexto leemos el stream y lo mostramos en el.
                    //textArea.read(buffer, null);
                    String texto = "";
                    String linea = "";

                    while (((linea = buffer.readLine()) != null)){

                        texto += linea+"\n";
                    }

                    //Ponemos el texto en el textarea
                    textArea.setText(texto);
                    dialogLeer.setContentPane(textArea);

                    //Desabilitamos la edicion
                    textArea.setEditable(false);

                    //Volvemos visible el JDialog
                    dialogLeer.repaint();
                    dialogLeer.setVisible(true);

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

    public void clickBotonEscribir(JButton button, DialogEscribir dialog){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Abrimos un documento
                //Nuestro archivo a leer
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

                //Lo mostramos en una area de texto
                //Probamos
                try {

                    //Area de texto para nuestro archivo
                    JTextArea textArea = new JTextArea();

                    //lector leera el flujo de caracteres almacenado en la varibale nombreArchivo
                    FileReader lector = new FileReader(nombreDeArchivo);

                    //Leemos el texto del archivo desde el stream de caracteres
                    BufferedReader buffer = new BufferedReader(lector);

                    //Con el panelDeTexto leemos el stream y lo mostramos en el.
                    String texto = "";
                    String linea = "";

                    while (((linea = buffer.readLine()) != null)){

                        texto += linea+"\n";
                    }

                    //Ponemos el texto en el textarea
                    textArea.setText(texto);
                    dialog.setContentPane(textArea);

                    //Habilitamos la edicion
                    textArea.setEditable(true);

                    //Volvemos visible el JDialog
                    dialog.repaint();
                    dialog.setVisible(true);

                    //Cerramos los streams
                    buffer.close();
                    lector.close();

                } catch (IOException exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, exception);
                }
                
                //Guardamos los cambios

            }
        });
    }

    public void clickBotonRenombrar(JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void clickBotonEliminar(JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}

