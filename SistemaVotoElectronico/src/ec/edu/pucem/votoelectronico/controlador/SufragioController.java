package ec.edu.pucem.votoelectronico.controlador;

import java.util.ArrayList;
import java.util.List;
import ec.edu.pucem.votoelectronico.modelo.Candidato;
import ec.edu.pucem.votoelectronico.modelo.Estudiante;
import ec.edu.pucem.votoelectronico.modelo.Voto;
import ec.edu.pucem.votoelectronico.modelo.Curso;
import ec.edu.pucem.votoelectronico.modelo.Mesa;

public class SufragioController {
    private List<Estudiante> estudiantes;
    private List<Candidato> candidatos;
    private List<Voto> votos;
    private List<Mesa> mesas;
    private List<Curso> cursos;

    public SufragioController() {
        this.estudiantes = new ArrayList<>();
        this.candidatos = new ArrayList<>();
        this.votos = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void inicializarDatos(List<Estudiante> estudiantes, List<Candidato> candidatos) {
        this.estudiantes = estudiantes;
        this.candidatos = candidatos;

        Mesa mesa1 = new Mesa(1L, "Mesa 1", "Juan Pérez", "María Gómez");
        Mesa mesa2 = new Mesa(2L, "Mesa 2", "Luis Rodríguez", "Ana Morales");
        Mesa mesa3 = new Mesa(3L, "Mesa 3", "Carlos Silva", "Laura Fernández");

        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);

        for (int i = 1; i <= 10; i++) {
            Mesa mesaAsignada = mesas.get(i % mesas.size());
            Curso curso = new Curso((long) i, "Curso " + i, mesaAsignada);
            cursos.add(curso);
        }

        for (int i = 1; i <= 30; i++) {
            Curso cursoAsignado = cursos.get(i % cursos.size());
            Estudiante estudiante = new Estudiante((long) i, "Estudiante " + i, "00000000" + i, true, cursoAsignado);
            estudiantes.add(estudiante);
        }

        candidatos.add(new Candidato((long) 1, "Pedro López", "Partido A"));
        candidatos.add(new Candidato((long) 2, "Ana Martínez", "Partido B"));
        candidatos.add(new Candidato((long) 3, "Ariel Moreira", "Partido C"));
        candidatos.add(new Candidato((long) 4, "Juan Pérez", "Partido D"));
    }

    public boolean registrarVoto(String cedulaEstudiante, Long idCandidato) {
        Estudiante estudiante = estudiantes.stream()
            .filter(e -> e.getCedula().equals(cedulaEstudiante) && e.getEstado())
            .findFirst()
            .orElse(null);

        Candidato candidato = candidatos.stream()
            .filter(c -> c.getId().equals(idCandidato))
            .findFirst()
            .orElse(null);

        if (estudiante != null && candidato != null) {
            Voto voto = new Voto(System.currentTimeMillis(), estudiante, candidato);
            votos.add(voto);
            estudiante.setEstado(false);
            return true;
        }
        return false;
    }

    public Estudiante buscarEstudiantePorCedula(String cedulaEstudiante) {
        return estudiantes.stream()
            .filter(e -> e.getCedula().equals(cedulaEstudiante) && e.getEstado())
            .findFirst()
            .orElse(null);
    }

    public List<Voto> obtenerVotos() {
        return votos;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public String getDatosMesas() {
        StringBuilder sb = new StringBuilder();
        for (Mesa mesa : mesas) {
            sb.append(mesa.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getDatosCursos() {
        StringBuilder sb = new StringBuilder();
        for (Curso curso : cursos) {
            sb.append(curso.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getDatosEstudiantes() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante estudiante : estudiantes) {
            sb.append(estudiante.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getDatosCandidatos() {
        StringBuilder sb = new StringBuilder();
        for (Candidato candidato : candidatos) {
            sb.append(candidato.toString()).append("\n");
        }
        return sb.toString();
    }
}
