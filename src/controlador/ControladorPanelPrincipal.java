package controlador;

import vista.DialogLeer;
import vista.Ventana;
import vista.VentanaPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ControladorPanelPrincipal {

     public void clickBotonCrear(JButton button, JPanel jPanel){

         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 //Varible para almacenar la direccion de nuestro archivo
                 String direccionDelArchivo = null;

                 //Obtenemos el nombre y directorio donde se guardara el archivo
                 JFileChooser fileChooser = new JFileChooser();
                 fileChooser.setDialogTitle("Guardar como");

                 int seleccionDelUsuario = fileChooser.showSaveDialog(jPanel);

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

     public void clickBotonLeer(JButton button, JFrame frame){

          button.addActionListener(new ActionListener() {
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

                  DialogLeer dialog = new DialogLeer(frame, true);


                  try {
                      //lector leera el flujo de caracteres almacenado en la varibale nombreArchivo
                      FileReader lector = new FileReader(nombreDeArchivo);

                      //Leemos el texto del archivo desde el stream de caracteres
                      BufferedReader buffer = new BufferedReader(lector);

                      //JTextPane textPane = dialog.getTextPane();

                      //Con el panelDeTexto leemos el stream y lo mostramos en el.
                      dialog.panelDeTexto.read(buffer, null);
                      //textPane.read(buffer, null);
                      dialog.panelDeTexto.requestFocus();

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