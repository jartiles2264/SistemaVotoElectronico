package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Estudiante;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class FrmPadronElectoral extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmPadronElectoral(SufragioController controller) {
        setTitle("Padrón Electoral");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = {"Nombre", "Cédula", "Mesa"};

        List<Estudiante> estudiantes = controller.getEstudiantes();

        List<Estudiante> estudiantesActivos = estudiantes.stream()
                .filter(Estudiante::getEstado)
                .collect(Collectors.toList());

        Object[][] data = new Object[estudiantesActivos.size()][3];

        for (int i = 0; i < estudiantesActivos.size(); i++) {
            Estudiante e = estudiantesActivos.get(i);
            String nombre = e.getNombre();
            String cedula = e.getCedula();
            String mesa = e.getCurso() != null ? e.getCurso().getMesa().getNombre() : "Sin Mesa";

            data[i][0] = nombre;
            data[i][1] = cedula;
            data[i][2] = mesa;
        }

        JTable table = new JTable(data, columnNames);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
