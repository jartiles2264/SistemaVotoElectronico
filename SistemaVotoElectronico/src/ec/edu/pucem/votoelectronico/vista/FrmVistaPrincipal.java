package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVistaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;
    public FrmVistaPrincipal(SufragioController controller) {
        setTitle("Sistema de Voto Electrónico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu archivoMenu = new JMenu("Archivo");
        JMenu administrationMenu = new JMenu("Administración");
        JMenu processMenu = new JMenu("Proceso");
        JMenu reportMenu = new JMenu("Reportes");

        JMenuItem salirMenuItem = new JMenuItem("Salir");
        JMenuItem mesasMenuItem = new JMenuItem("Mesas");
        JMenuItem cursosMenuItem = new JMenuItem("Cursos");
        JMenuItem estudiantesMenuItem = new JMenuItem("Estudiantes");
        JMenuItem candidatosMenuItem = new JMenuItem("Candidatos");
        JMenuItem sufragarMenuItem = new JMenuItem("Sufragar");
        JMenuItem padronMenuItem = new JMenuItem("Padrón Electoral");
        JMenuItem resultadosMenuItem = new JMenuItem("Resultados Generales");

        archivoMenu.add(salirMenuItem);
        administrationMenu.add(mesasMenuItem);
        administrationMenu.add(cursosMenuItem);
        administrationMenu.add(estudiantesMenuItem);
        administrationMenu.add(candidatosMenuItem);
        processMenu.add(sufragarMenuItem);
        reportMenu.add(padronMenuItem);
        reportMenu.add(resultadosMenuItem);

        menuBar.add(archivoMenu);
        menuBar.add(administrationMenu);
        menuBar.add(processMenu);
        menuBar.add(reportMenu);

        setJMenuBar(menuBar);

        salirMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mesasMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmMesas frmMesas = new FrmMesas(controller);
                frmMesas.setVisible(true);
            }
        });

        cursosMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmCursos frmCursos = new FrmCursos(controller);
                frmCursos.setVisible(true);
            }
        });

        estudiantesMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmEstudiantes frmEstudiantes = new FrmEstudiantes(controller);
                frmEstudiantes.setVisible(true);
            }
        });

        candidatosMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmCandidatos frmCandidatos = new FrmCandidatos(controller);
                frmCandidatos.setVisible(true);
            }
        });

        sufragarMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmLogin frmLogin = new FrmLogin(controller);
                frmLogin.setVisible(true);
            }
        });

        padronMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmPadronElectoral frmPadron = new FrmPadronElectoral(controller);
                frmPadron.setVisible(true);
            }
        });

        resultadosMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmResultadosGenerales frmResultados = new FrmResultadosGenerales(controller);
                frmResultados.setVisible(true);
            }
        });
    }
}
