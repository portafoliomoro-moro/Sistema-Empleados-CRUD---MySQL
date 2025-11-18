package SistemaEmpleado.domino;

import java.util.Objects;

public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private double salario;
    private String departamento;

    public Empleado(){}

    //Constructor para buscar y eliminar
    public Empleado(int id){
        this.id = id;
    }

    //Constructor para agregar
    public Empleado(String nombre, String apellido, double salario, String departamento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.departamento = departamento;
    }

    //Constructor para modificar
    public Empleado(int id, String nombre, String apellido, double salario, String departamento){
        this(nombre, apellido, salario, departamento);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id && Double.compare(salario, empleado.salario) == 0 && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido, empleado.apellido) && Objects.equals(departamento, empleado.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, salario, departamento);
    }
}
