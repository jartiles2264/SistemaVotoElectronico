package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;

public class FrmConfirmacion extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmConfirmacion() {
        setTitle("Confirmación");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel mensajeLabel = new JLabel("¡Gracias por su voto!");

        panel.add(mensajeLabel);

        add(panel);
    }
}
