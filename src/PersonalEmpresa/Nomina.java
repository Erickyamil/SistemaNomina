package PersonalEmpresa;

public interface Nomina { 
    /*Incluye Métodos para calcular 
    el pago individual y total de los empleados*/
    public void generarRecibo(Empleado empleado);
    public double calcularPagoTotal();
}

