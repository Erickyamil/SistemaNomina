package PersonalEmpresa;

public class EmpleadoTiempoCompleto extends Empleado { //TP
    private double bonificaciones = 1600;

    // Constructor para usar un bonus especifico
    public EmpleadoTiempoCompleto(String nombre,String apellido, String id, String departamento, double salarioBase, double horasTrabajadas, double bonificaciones) {
        super(nombre, apellido, id, departamento, salarioBase);
        this.bonificaciones = bonificaciones;
        setBonificaciones(bonificaciones); //asigna la tarifa
    }


    // Constructor para usar el bonus estandar
    public EmpleadoTiempoCompleto(String nombre, String apellido, String id, String departamento, double salarioBase, double bonificaciones) {
        super(nombre, apellido, id, departamento, salarioBase);
        this.bonificaciones = bonificaciones;
    }

    //Método Heredado de: clase Empleado
    @Override
    public double calcularSalario() {
        return salarioBase + bonificaciones;
    }

    // Cambiar el bonus con validación
    public void setBonificaciones (double bonificaciones) {
        if (bonificaciones >= 0) {
            this.bonificaciones = bonificaciones;
        } else {
            throw new IllegalArgumentException("El bonus no puede ser menor que cero.");
        }
    }

    public double getBonificaciones() {
        return bonificaciones;
    }
}
