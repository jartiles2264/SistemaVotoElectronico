package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Mesa;

public class FrmMesas extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmMesas(SufragioController controller) {
        setTitle("Gestión de Mesas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Presidente", "Secretario"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        for (Mesa mesa : controller.getMesas()) {
            model.addRow(new Object[]{mesa.getId(), mesa.getNombre(), mesa.getPresidente(), mesa.getSecretario()});
        }
    }
}
