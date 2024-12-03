package PersonalEmpresa;

public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected String id;
    protected String departamento;
    protected double salarioBase; 

    public Empleado(String nombre,String apellido, String id, String departamento, double salarioBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.departamento = departamento;
        this.salarioBase = salarioBase;
    }

    // Método para empleados (PH y TP)
    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId() {
        return id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}

