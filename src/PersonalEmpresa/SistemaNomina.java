package PersonalEmpresa;

public class SistemaNomina implements Nomina {
    public Empleado[] empleados;
    public int contador; // Empleados en el arreglo

    public SistemaNomina(int capacidadMaxima) {
        this.empleados = new Empleado[capacidadMaxima]; // Fija el tamaño para el arreglo
        this.contador = 0;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (contador < empleados.length) {
            empleados[contador] = empleado;
            contador++;
        } else {
            System.out.println("No se pueden agregar más empleados. Capacidad máxima alcanzada.");
        }
    }

    @Override
    public void generarRecibo(Empleado empleado) {
        System.out.println("Generando recibo para: " + empleado.getNombre());
        String salarioSinDecimales = String.format("%.2f", empleado.calcularSalario());
        System.out.println("Salario: " + salarioSinDecimales);
    }

    @Override
    public double calcularPagoTotal() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += empleados[i].calcularSalario();
        }
        return total;
    }

    public void listarEmpleados() {
        System.out.println("Lista de empleados:");
        for (int i = 0; i < contador; i++) {
            System.out.println("Empleado " + (i+1) + ": " + empleados[i].getNombre() + " " + empleados[i].getApellido() 
                                                        + " - " + empleados[i].getId() + " - " + empleados[i].getDepartamento());
        }   
    }
}
