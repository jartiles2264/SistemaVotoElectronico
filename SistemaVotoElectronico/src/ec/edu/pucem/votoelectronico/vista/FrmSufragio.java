package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Candidato;
import ec.edu.pucem.votoelectronico.modelo.Estudiante;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmSufragio extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmSufragio(SufragioController controller, List<Candidato> candidatos, Estudiante estudiante) {
        setTitle("Sufragio");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(candidatos.size() + 1, 1));

        ButtonGroup group = new ButtonGroup();
        for (Candidato candidato : candidatos) {
            JRadioButton button = new JRadioButton(candidato.getNombre());
            button.setActionCommand(candidato.getId().toString());
            group.add(button);
            panel.add(button);
        }

        JButton votarButton = new JButton("Votar");
        panel.add(votarButton);

        votarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String candidatoId = group.getSelection().getActionCommand();
                Long idCandidato = Long.parseLong(candidatoId);
                boolean exito = controller.registrarVoto(estudiante.getCedula(), idCandidato);

                if (exito) {
                    FrmConfirmacion frmConfirmacion = new FrmConfirmacion();
                    frmConfirmacion.setVisible(true);
                    FrmSufragio.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(FrmSufragio.this, "No se pudo registrar el voto.");
                }
            }
        });

        add(panel);
    }
}
