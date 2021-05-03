package controlador;

import vista.DialogEscribir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class ControladorDialogEscribir {

    public void guardar(JMenuItem menuItem, DialogEscribir dialogEscribir){

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dialogEscribir.file));
                    bufferedWriter.write(dialogEscribir.textArea.getText());
                    bufferedWriter.close();
                    JOptionPane.showMessageDialog(dialogEscribir, "Los cambios han sido guardados");

                } catch (IOException ioException) {

                    ioException.printStackTrace();

                }

            }
        });
    }

    public void onClose(DialogEscribir dialogEscribir){

        dialogEscribir.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

                int msj = JOptionPane.showConfirmDialog(dialogEscribir, "Deseas guardar los cambios?");

                if (msj == JOptionPane.YES_OPTION){

                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dialogEscribir.file));
                        bufferedWriter.write(dialogEscribir.textArea.getText());
                        bufferedWriter.close();
                        JOptionPane.showMessageDialog(dialogEscribir, "Los cambios han sido guardados");

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }

                if (msj == JOptionPane.NO_OPTION){

                    JOptionPane.showMessageDialog(dialogEscribir, "No se han guardado los cambios");
                }

                if (msj == JOptionPane.CANCEL_OPTION){


                }

            }



            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
