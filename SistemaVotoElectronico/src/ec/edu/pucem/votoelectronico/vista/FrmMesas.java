package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Mesa;

public class FrmMesas extends JFrame {
    private static final long serialVersionUID = 1L;
    private SufragioController controller;

    public FrmMesas(SufragioController controller) {
        this.controller = controller;
        setTitle("Gestión de Mesas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Presidente", "Secretario"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton btnAgregar = new JButton("Agregar Mesa");
        panel.add(btnAgregar);
        add(panel, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoAgregarMesa();
            }
        });

        cargarDatos();
    }

    private void cargarDatos() {
        DefaultTableModel model = (DefaultTableModel) ((JTable) ((JScrollPane) getContentPane().getComponent(0)).getViewport().getView()).getModel();
        model.setRowCount(0);
        for (Mesa mesa : controller.getMesas()) {
            model.addRow(new Object[]{
                mesa.getId(),
                mesa.getNombre(),
                mesa.getPresidente(),
                mesa.getSecretario()
            });
        }
    }

    private void mostrarDialogoAgregarMesa() {
        JDialog dialog = new JDialog(this, "Agregar Mesa", true);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);

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

        JLabel lblPresidente = new JLabel("Presidente:");
        lblPresidente.setBounds(20, 100, 100, 25);
        panel.add(lblPresidente);

        JTextField txtPresidente = new JTextField();
        txtPresidente.setBounds(120, 100, 150, 25);
        panel.add(txtPresidente);

        JLabel lblSecretario = new JLabel("Secretario:");
        lblSecretario.setBounds(20, 140, 100, 25);
        panel.add(lblSecretario);

        JTextField txtSecretario = new JTextField();
        txtSecretario.setBounds(120, 140, 150, 25);
        panel.add(txtSecretario);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(50, 180, 100, 30);
        panel.add(btnAgregar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(170, 180, 100, 30);
        panel.add(btnCancelar);

        dialog.add(panel);
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(this);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos(txtId, txtNombre, txtPresidente, txtSecretario)) {
                    Long id = Long.parseLong(txtId.getText());
                    String nombre = txtNombre.getText();
                    String presidente = txtPresidente.getText();
                    String secretario = txtSecretario.getText();
                    controller.agregarMesa(id, nombre, presidente, secretario);
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
