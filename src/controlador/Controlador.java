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

                //Una vez ingresado el nombre le agregamos la extension .txt
                if (seleccionDelUsuario == JFileChooser.APPROVE_OPTION){
                    String nombre = fileChooser.getSelectedFile().getAbsolutePath();
                    nombre = nombre + ".txt";
                    File archivoxGuardar = new File(nombre);
                    direccionDelArchivo = archivoxGuardar.getAbsolutePath();
                }

                //Creamos el archivo
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
                   dialog.file = selector.getSelectedFile();

                    //Lo mostramos en una area de texto
                    //Probamos
                    try {

                        //Area de texto para nuestro archivo
                        JTextArea textArea = new JTextArea();

                        //lector leera el flujo de caracteres almacenado en la varibale nombreArchivo
                        FileReader lector = new FileReader(dialog.file);

                        //Leemos el texto del archivo desde el stream de caracteres
                        BufferedReader buffer = new BufferedReader(lector);

                        //Guardamos el texto en la variable texto.
                        String texto = "";
                        String linea = "";

                        while (((linea = buffer.readLine()) != null)){

                            texto += linea+"\n";
                        }

                        //Ponemos el texto en el textarea
                        textArea.setText(texto);
                        //dialog.setContentPane(textArea);
                        dialog.textArea.setText(texto);

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

                }
            }
        });
    }

    public void clickBotonRenombrar(JButton button, Ventana ventana){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Nuestro archivo a cambiar de nombre
                File nombreDeArchivo = null;

                //Creamos un JFileChooser para poder elegir un archivo .txt
                JFileChooser selector = new JFileChooser();
                selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                //Creamos un filtro para seleccionar unicamente archivos .txt
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo txt", "txt");
                selector.setFileFilter(filtro);

                //Obtenemos la ruta del archivo seleccionado con JFileChooser
                int resultado = selector.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    nombreDeArchivo = selector.getSelectedFile();

                    //Mostramos un cuadro para introducir el nuevo nombre del archivo
                    String respuesta = JOptionPane.showInputDialog("Ingresa el nuevo nombre para el archivo");

                    //Renombramos el archivo
                    File nuevoNombre = new File(nombreDeArchivo.getParent() + "\\" + respuesta + ".txt");
                    Boolean b = nombreDeArchivo.renameTo(nuevoNombre);

                    //Cuadros de dialog en caso de que el renombrado haya sido exitoso o haya fallado
                    if (b == true){
                        JOptionPane.showMessageDialog(ventana,"El archivo ha sido renombrado exitosamente");
                    }else {
                        JOptionPane.showMessageDialog(ventana, "El archivo no se ha podido renombrar");
                    }
                }
            }
        });
    }

    public void clickBotonEliminar(JButton button, Ventana ventana){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Nuestro archivo a eliminar
                File nombreDeArchivo = null;

                //Creamos un JFileChooser para poder elegir un archivo .txt
                JFileChooser selector = new JFileChooser();
                selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                //Creamos un filtro para seleccionar unicamente archivos .txt
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo txt", "txt");
                selector.setFileFilter(filtro);

                //Obtenemos la ruta del archivo seleccionado con JFileChooser
                int resultado = selector.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    nombreDeArchivo = selector.getSelectedFile();

                    //Eliminanos el archivo
                    Boolean eliminar = nombreDeArchivo.delete();

                    //Mostramos cuadros de dialogo en caso que la eliminacion haya sido exitosa
                    if (eliminar == true){
                        JOptionPane.showMessageDialog(ventana, "El archivo ha sido eliminado");
                    }else {
                        JOptionPane.showMessageDialog(ventana, "El archivo no se ha podido eliminar");
                    }
                }
            }
        });
    }



}

