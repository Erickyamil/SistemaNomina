package PersonalEmpresa;

public class EmpleadoPorHoras extends Empleado { //PH
    private double horasTrabajadas;
    private double tarifaPorHora = 32.00; // Tarifa estándar por hora

    // Constructor para usar una tarifa especifica
    public EmpleadoPorHoras(String nombre,String apellido, String id, String departamento, double salarioBase, double horasTrabajadas, double tarifaPorHora) {
        super(nombre, apellido, id, departamento, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        setTarifaPorHora(tarifaPorHora); //asigna la tarifa
    }

    // Constructor para usar tarifa estándar
    public EmpleadoPorHoras(String nombre, String apellido, String id, String departamento, double salarioBase, double horasTrabajadas) {
        super(nombre, apellido, id, departamento, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    // Método heredado de la clase Empleado
    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }

    // Cambiar la tarifa con validación
    public void setTarifaPorHora(double tarifaPorHora) {
        if (tarifaPorHora > 0) {
            this.tarifaPorHora = tarifaPorHora;
        } else {
            throw new IllegalArgumentException("La tarifa por hora debe ser mayor que cero.");
        }
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }
}
