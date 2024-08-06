package ec.edu.pucem.votoelectronico.modelo;

public class Curso {
    private Long id;
    private String nombre;
    private Mesa mesa;

    public Curso(Long id, String nombre, Mesa mesa) {
        this.id = id;
        this.nombre = nombre;
        this.mesa = mesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
