package ec.edu.pucem.votoelectronico.modelo;

public class Voto {
    private Long id;
    private Estudiante estudiante;
    private Candidato candidato;

    public Voto(Long id, Estudiante estudiante, Candidato candidato) {
        this.id = id;
        this.estudiante = estudiante;
        this.candidato = candidato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
}
