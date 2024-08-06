package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Estudiante;

public class FrmEstudiantes extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmEstudiantes(SufragioController controller) {
        setTitle("Gestión de Estudiantes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Cédula", "Estado", "Curso"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        for (Estudiante estudiante : controller.getEstudiantes()) {
            model.addRow(new Object[]{
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getCedula(),
                estudiante.getEstado() ? "Activo" : "Inactivo",
                estudiante.getCurso().getNombre()
            });
        }
    }
}
