package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Estudiante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmLogin extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmLogin(SufragioController controller) {
        setTitle("Inicio de Sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        JPanel panel = new JPanel();
        JLabel cedulaLabel = new JLabel("Cédula:");
        JTextField cedulaField = new JTextField(20);
        JButton loginButton = new JButton("Iniciar Sesión");

        panel.add(cedulaLabel);
        panel.add(cedulaField);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = cedulaField.getText();
                Estudiante estudiante = controller.buscarEstudiantePorCedula(cedula);
                if (estudiante != null) {
                    FrmSufragio frmSufragio = new FrmSufragio(controller, controller.getCandidatos(), estudiante);
                    frmSufragio.setVisible(true);
                    FrmLogin.this.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(FrmLogin.this, "Cédula no válida o estudiante ya ha votado.");
                }
            }
        });

        add(panel);
    }
}
