package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Candidato;

public class FrmCandidatos extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmCandidatos(SufragioController controller) {
        setTitle("Gestión de Candidatos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Partido"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        for (Candidato candidato : controller.getCandidatos()) {
            model.addRow(new Object[]{
                candidato.getId(),
                candidato.getNombre(),
                candidato.getNombrePartido()
            });
        }
    }
}
