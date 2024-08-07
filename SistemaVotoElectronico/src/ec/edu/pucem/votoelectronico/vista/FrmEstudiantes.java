package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Curso;
import ec.edu.pucem.votoelectronico.modelo.Estudiante;

public class FrmEstudiantes extends JFrame {
    private static final long serialVersionUID = 1L;
    private SufragioController controller;

    public FrmEstudiantes(SufragioController controller) {
        this.controller = controller;
        setTitle("Gestión de Estudiantes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Cédula", "Estado", "Curso"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton btnAgregar = new JButton("Agregar Estudiante");
        panel.add(btnAgregar);
        add(panel, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoAgregarEstudiante();
            }
        });

        cargarDatos();
    }

    private void cargarDatos() {
        DefaultTableModel model = (DefaultTableModel) ((JTable) ((JScrollPane) getContentPane().getComponent(0)).getViewport().getView()).getModel();
        model.setRowCount(0); // Limpiar datos actuales
        for (Estudiante estudiante : controller.getEstudiantes()) {
            model.addRow(new Object[]{
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getCedula(),
                estudiante.getEstado(),
                estudiante.getCurso().getNombre()
            });
        }
    }

    private void mostrarDialogoAgregarEstudiante() {
        JDialog dialog = new JDialog(this, "Agregar Estudiante", true);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Usar el diseño por defecto sin layout manager

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 20, 100, 25);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(120, 20, 150, 25);
        panel.add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        panel.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 150, 25);
        panel.add(txtNombre);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(20, 100, 100, 25);
        panel.add(lblCedula);

        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(120, 100, 150, 25);
        panel.add(txtCedula);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(20, 140, 100, 25);
        panel.add(lblEstado);

        JCheckBox chkEstado = new JCheckBox("Activo");
        chkEstado.setBounds(120, 140, 150, 25);
        panel.add(chkEstado);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(20, 180, 100, 25);
        panel.add(lblCurso);

        JComboBox<Curso> cmbCurso = new JComboBox<>(controller.getCursos().toArray(new Curso[0]));
        cmbCurso.setBounds(120, 180, 150, 25);
        panel.add(cmbCurso);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(50, 220, 100, 30);
        panel.add(btnAgregar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(170, 220, 100, 30);
        panel.add(btnCancelar);

        dialog.add(panel);
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(this);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos(txtId, txtNombre, txtCedula)) {
                    Long id = Long.parseLong(txtId.getText());
                    String nombre = txtNombre.getText();
                    String cedula = txtCedula.getText();
                    boolean estado = chkEstado.isSelected();
                    Curso curso = (Curso) cmbCurso.getSelectedItem();
                    controller.agregarEstudiante(id, nombre, cedula, estado, curso);
                    cargarDatos();
                    dialog.dispose();
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
    }

    private boolean validarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
