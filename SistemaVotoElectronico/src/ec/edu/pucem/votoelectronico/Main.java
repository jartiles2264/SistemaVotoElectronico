package ec.edu.pucem.votoelectronico;

import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Candidato;
import ec.edu.pucem.votoelectronico.modelo.Estudiante;
import ec.edu.pucem.votoelectronico.vista.FrmVistaPrincipal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();
        List<Candidato> candidatos = new ArrayList<>();
        
        SufragioController controller = new SufragioController();
        controller.inicializarDatos(estudiantes, candidatos);

        FrmVistaPrincipal frmVistaPrincipal = new FrmVistaPrincipal(controller);
        frmVistaPrincipal.setVisible(true);
    }
}
