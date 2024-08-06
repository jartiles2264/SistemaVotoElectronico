package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Curso;

public class FrmCursos extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmCursos(SufragioController controller) {
        setTitle("Gestión de Cursos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Mesa"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        for (Curso curso : controller.getCursos()) {
            model.addRow(new Object[]{curso.getId(), curso.getNombre(), curso.getMesa().getNombre()});
        }
    }
}
