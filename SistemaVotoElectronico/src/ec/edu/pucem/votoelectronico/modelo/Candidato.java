package ec.edu.pucem.votoelectronico.modelo;

public class Candidato extends Persona {
    private String nombrePartido;

    public Candidato(Long id, String nombre, String nombrePartido) {
        super(id, nombre);
        this.nombrePartido = nombrePartido;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }
}
