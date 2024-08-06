package ec.edu.pucem.votoelectronico.modelo;

public class Estudiante extends Persona {
    private String cedula;
    private Boolean estado;
    private Curso curso;

    public Estudiante(Long id, String nombre, String cedula, Boolean estado, Curso curso) {
        super(id, nombre);
        this.cedula = cedula;
        this.estado = estado;
        this.curso = curso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
