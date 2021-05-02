package vista;

import javax.swing.*;
import java.awt.*;

public class DialogLeer extends JDialog {

    JTextArea panelDeTexto;

    public void setPanelDeTexto(JTextArea panelDeTexto) {
        this.panelDeTexto = panelDeTexto;
    }

    public JTextArea getPanelDeTexto() {
        return panelDeTexto;
    }

    public DialogLeer(JFrame parent, Boolean modal){

        super(parent, modal);

        //Definimos tamaño y titulo
        setSize(500, 300);
        setTitle("Leer archivo");

        //Establecemos el tipo de Layout
        setLayout(new BorderLayout());

        //Agregamos un JTextPane al panel
        this.panelDeTexto = new JTextArea();
        add(panelDeTexto, BorderLayout.CENTER);

        //Volvemos visible
        panelDeTexto.setEditable(false);

    }

}
