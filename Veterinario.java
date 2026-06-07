package clases;

public class Veterinario {
    private int id;
    private String rut;
    private String especialidad;
    private int sueldo;

    public Veterinario(int id, String rut, String especialidad, int sueldo) {
        this.id = id;
        this.rut = rut;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
    }

    public Veterinario(){
        // Creacion de otro constructor para que la libreria pueda procesar el JSON
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "id=" + id +
                ", rut='" + rut + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}