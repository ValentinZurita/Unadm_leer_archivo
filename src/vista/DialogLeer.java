package vista;

import javax.swing.*;
import java.awt.*;

public class DialogLeer extends JDialog {

    public JTextArea panelDeTexto;

    public DialogLeer(JFrame parent, Boolean modal){

        super(parent, modal);
        setTitle("Leer archivo");

        //Establecemos el tipo de Layout
        setLayout(new BorderLayout());

        //Agregamos un JTextPane al panel
        this.panelDeTexto = new JTextArea();
        add(panelDeTexto, BorderLayout.CENTER);

    }

}
