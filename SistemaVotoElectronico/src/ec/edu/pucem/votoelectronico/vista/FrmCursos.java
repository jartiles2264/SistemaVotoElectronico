package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Curso;
import ec.edu.pucem.votoelectronico.modelo.Mesa;

public class FrmCursos extends JFrame {
    private static final long serialVersionUID = 1L;
    private SufragioController controller;

    public FrmCursos(SufragioController controller) {
        this.controller = controller;
        setTitle("Gestión de Cursos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Mesa"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton btnAgregar = new JButton("Agregar Curso");
        panel.add(btnAgregar);
        add(panel, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoAgregarCurso();
            }
        });

        cargarDatos();
    }

    private void cargarDatos() {
        DefaultTableModel model = (DefaultTableModel) ((JTable) ((JScrollPane) getContentPane().getComponent(0)).getViewport().getView()).getModel();
        model.setRowCount(0); // Limpiar datos actuales
        for (Curso curso : controller.getCursos()) {
            model.addRow(new Object[]{
                curso.getId(),
                curso.getNombre(),
                curso.getMesa().getNombre()
            });
        }
    }

    private void mostrarDialogoAgregarCurso() {
        JDialog dialog = new JDialog(this, "Agregar Curso", true);
        dialog.setLayout(new GridLayout(4, 2));

        JTextField txtId = new JTextField();
        JTextField txtNombre = new JTextField();

        // Crear el JComboBox con el modelo de mesa
        JComboBox<Mesa> cmbMesa = new JComboBox<>(controller.getMesas().toArray(new Mesa[0]));
        cmbMesa.setPreferredSize(new Dimension(200, cmbMesa.getPreferredSize().height)); // Establecer el ancho

        JButton btnAgregar = new JButton("Agregar");
        JButton btnCancelar = new JButton("Cancelar");

        dialog.add(new JLabel("ID:"));
        dialog.add(txtId);
        dialog.add(new JLabel("Nombre:"));
        dialog.add(txtNombre);
        dialog.add(new JLabel("Mesa:"));
        dialog.add(cmbMesa);
        dialog.add(btnAgregar);
        dialog.add(btnCancelar);

        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos(txtId, txtNombre)) {
                    Long id = Long.parseLong(txtId.getText());
                    String nombre = txtNombre.getText();
                    Mesa mesa = (Mesa) cmbMesa.getSelectedItem();
                    controller.agregarCurso(id, nombre, mesa);
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
