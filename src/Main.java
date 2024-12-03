import PersonalEmpresa.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaNomina sistemaNomina = new SistemaNomina(10); // Capacidad máxima
        Scanner entrada = new Scanner(System.in);

        final double TARIFA_ESTANDAR = 60.00; // Tarifa estándar por hora para empleado PH
        final double BONUS_ESTANDAR = 1600.00; // Bonus estándar para empleado TC
        int opcion;

        do {
            System.out.println("\n ----- Sistema de Nómina ----- -----");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Calcular y mostrar el salario total");
            System.out.println("3. Generar recibos para todos los empleados");
            System.out.println("4. Listar empleados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n----- Agregar Empleado ----- -----");
                    System.out.println("1. Empleado de tiempo completo");
                    System.out.println("2. Empleado por horas");
                    System.out.print("Seleccione una opción: ");
                    int opcionE = entrada.nextInt();

                    if (opcionE == 1) {
                        System.out.println("\nNuevo Empleado de Tiempo Completo:");
                        System.out.print("Nombre: ");
                        String nombreTC = entrada.next();
                        System.out.print("Apellido(s): ");
                        String apellidoTC = entrada.next();
                        System.out.print("ID: ");
                        String idTC = entrada.next();
                        System.out.print("Departamento: ");
                        String departamentoTC = entrada.next();
                        System.out.print("Salario Base: ");
                        double salarioBaseTC = entrada.nextDouble();

                        System.out.println("1. Aplicar bonus estándar (" + BONUS_ESTANDAR + ")");
                        System.out.println("2. Establecer otro bonus");
                        System.out.print("Seleccione una opción: ");
                        int opcionTarifa = entrada.nextInt();

                        double bonificaciones;
                        if (opcionTarifa == 1) {
                            bonificaciones = BONUS_ESTANDAR;
                        } else if (opcionTarifa == 2) {
                            System.out.print("Ingrese el nuevo bonus: ");
                            bonificaciones = entrada.nextDouble();
                        } else {
                            System.out.println("Opción inválida. Aplicando el bonus estándar.");
                            bonificaciones = BONUS_ESTANDAR;
                        }

                        Empleado empleadoTC = new EmpleadoTiempoCompleto(nombreTC, apellidoTC, idTC, departamentoTC, salarioBaseTC, bonificaciones);
                        sistemaNomina.agregarEmpleado(empleadoTC);
                        System.out.println("Empleado de tiempo completo agregado.");
                    } else if (opcionE == 2) {
                        System.out.println("\nNuevo Empleado por Horas:");
                        System.out.print("Nombre: ");
                        String nombrePH = entrada.next();
                        System.out.print("Apellido(s): ");
                        String apellidoPH = entrada.next();
                        System.out.print("ID: ");
                        String idPH = entrada.next();
                        System.out.print("Departamento: ");
                        String departamentoPH = entrada.next();
                        System.out.print("Horas Trabajadas: ");
                        double horasTrabajadas = entrada.nextDouble();

                        System.out.println("1. Aplicar la tarifa estándar (" + TARIFA_ESTANDAR + ")");
                        System.out.println("2. Establecer otra tarifa");
                        System.out.print("Seleccione una opción: ");
                        int opcionTarifa = entrada.nextInt();

                        double tarifaPorHora;
                        if (opcionTarifa == 1) {
                            tarifaPorHora = TARIFA_ESTANDAR;
                        } else if (opcionTarifa == 2) {
                            System.out.print("Ingrese la nueva tarifa por hora: ");
                            tarifaPorHora = entrada.nextDouble();
                        } else {
                            System.out.println("Opción inválida. Usando la tarifa estándar.");
                            tarifaPorHora = TARIFA_ESTANDAR;
                        }

                        Empleado empleadoPH = new EmpleadoPorHoras(nombrePH, apellidoPH, idPH, departamentoPH, 0, horasTrabajadas, tarifaPorHora);
                        sistemaNomina.agregarEmpleado(empleadoPH);
                        System.out.println("Empleado por horas agregado.");
                    } else {
                        System.out.println("Opción inválida. Regresando al menú principal.");
                    }
                    break;

                case 2:
                    System.out.println("\n----- Calcular Salario Total ----- -----");
                    double salarioTotal = sistemaNomina.calcularPagoTotal();
                    System.out.println("El salario total de todos los empleados es de: $" + salarioTotal);
                    break;

                case 3:
                    System.out.println("\n----- Generar Recibos ----- -----");
                    for (int i = 0; i < sistemaNomina.contador; i++) {
                        sistemaNomina.generarRecibo(sistemaNomina.empleados[i]);
                    }
                    break;

                case 4:
                    System.out.println("\n----- Listar Empleados ----- -----");
                    sistemaNomina.listarEmpleados();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        entrada.close();
    }
}
