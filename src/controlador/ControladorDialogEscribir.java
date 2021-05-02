package controlador;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ControladorDialogEscribir {

    public void clickMenuArchivoArbrir (JMenuItem menuItem, JTextArea textArea){

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    textArea.read(buffer, null);
                    textArea.requestFocus();

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

    public void clickMenuArchivoGuardarComo(JDialog dialog, JMenuItem menuItem, JTextArea textArea){

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Varible para almacenar la direccion de nuestro archivo
                String direccionDelArchivo = null;

                //Obtenemos el nombre y directorio donde se guardara el archivo
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Guardar como");

                int seleccionDelUsuario = fileChooser.showSaveDialog(dialog);

                if (seleccionDelUsuario == JFileChooser.APPROVE_OPTION){
                    File archivoxGuardar = fileChooser.getSelectedFile();
                    direccionDelArchivo = archivoxGuardar.getAbsolutePath();
                }

                //Creamos el archivo y guardamos el texto que se haya escrito en el
                try {
                    FileWriter fileWriter = new FileWriter(direccionDelArchivo);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(textArea.getText());
                    bufferedWriter.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

    }
}
