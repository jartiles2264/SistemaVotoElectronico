package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;

import ec.edu.pucem.votoelectronico.controlador.SufragioController;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JDesktopPane desktopPane;
    
    public MainFrame() {
        setTitle("Sistema de Gestión Electoral");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        
        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);

        JButton btnCandidatos = new JButton("Candidatos");
        JButton btnCursos = new JButton("Cursos");
        JButton btnEstudiantes = new JButton("Estudiantes");
        JButton btnMesas = new JButton("Mesas");

        toolBar.add(btnCandidatos);
        toolBar.add(btnCursos);
        toolBar.add(btnEstudiantes);
        toolBar.add(btnMesas);

        btnCandidatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioCandidatos();
            }
        });

        btnCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioCursos();
            }
        });

        btnEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioEstudiantes();
            }
        });

        btnMesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioMesas();
            }
        });
    }

    private void abrirFormularioCandidatos() {
        FrmCandidatos internalFrame = new FrmCandidatos(new SufragioController()); // Cambia según tu lógica
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }

    private void abrirFormularioCursos() {
        FrmCursos internalFrame = new FrmCursos(new SufragioController()); // Cambia según tu lógica
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }

    private void abrirFormularioEstudiantes() {
        FrmEstudiantes internalFrame = new FrmEstudiantes(new SufragioController()); // Cambia según tu lógica
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }

    private void abrirFormularioMesas() {
        FrmMesas internalFrame = new FrmMesas(new SufragioController()); // Cambia según tu lógica
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }
}
