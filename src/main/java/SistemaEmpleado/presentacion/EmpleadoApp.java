package SistemaEmpleado.presentacion;

import SistemaEmpleado.datos.EmpleadoDAO;
import SistemaEmpleado.datos.IEmpleadosDAO;
import SistemaEmpleado.domino.Empleado;

import java.util.Scanner;

public class EmpleadoApp {
    public static void main(String[] args) {
        empleadoApp();
    }

    private static void empleadoApp(){
        var salir = false;
        var consola = new Scanner(System.in);

        IEmpleadosDAO empleadoDao = new EmpleadoDAO();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpcion(opcion, consola, empleadoDao);
            }catch(Exception e){
                System.out.println("Error al ingresar opción: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** Empleados
                1. Listar Empleados
                2. Buscar Empleado
                3. Agregar Empleado
                4. Modificar Empleado
                5. Eliminar Empleado
                6. Salir
                Elige una opción:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpcion(int opcion, Scanner consola, IEmpleadosDAO empleadoDao){
        var salir = false;
        switch(opcion){
            case 1 -> {
                System.out.println("--- Listar Empleado ---");
                var listarEmpleado = empleadoDao.listarEmpleados();
                listarEmpleado.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("--- Buscar Empleado ---");
                System.out.print("Id del empleado: ");
                var idEmpleado = Integer.parseInt(consola.nextLine());
                var buscarEmpleado = new Empleado(idEmpleado);
                var encontrado = empleadoDao.buscarEmpleadoPorId(buscarEmpleado);
                if(encontrado){
                    System.out.println("Empleado encontrado: " + buscarEmpleado);
                }
                else{
                    System.out.println("Empleado No encontrado: " + buscarEmpleado);
                }
            }
            case 3 -> {
                System.out.println("--- Agregar Empleado ---");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Salario: ");
                var salario = Double.parseDouble(consola.nextLine());
                System.out.print("Departamento: ");
                var departamento = consola.nextLine();
                var agregarEmpleado = new Empleado(nombre, apellido, salario, departamento);
                var agregado = empleadoDao.agregarEmpleado(agregarEmpleado);
                if(agregado){
                    System.out.println("Empleado agregado: " + agregarEmpleado);
                }
                else{
                    System.out.println("Empleado No agregado: " + agregarEmpleado);
                }
            }
            case 4 -> {
                System.out.println("--- Modificar Empleado ---");
                System.out.print("Id: ");
                var idEmpleado = Integer.parseInt(consola.nextLine());
                var buscar = new Empleado(idEmpleado);
                var encontrado = empleadoDao.buscarEmpleadoPorId(buscar);
                if(encontrado){
                    System.out.print("Nombre: ");
                    var nombre = consola.nextLine();
                    System.out.print("Apellido: ");
                    var apellido = consola.nextLine();
                    System.out.print("Salario: ");
                    var salario = Double.parseDouble(consola.nextLine());
                    System.out.print("Departamento: ");
                    var departamento = consola.nextLine();
                    var modificarEmpleado = new Empleado(idEmpleado, nombre, apellido, salario, departamento);
                    var modificado = empleadoDao.modificarEmpleado(modificarEmpleado);
                    System.out.println("Empleado modificado: " + modificarEmpleado);
                }
                else{
                    System.out.println("Empleado No encontrado: " + buscar);
                }
            }
            case 5 -> {
                System.out.println("--- Eliminar Empleado ----");
                System.out.print("Id: ");
                var idEmpelado = Integer.parseInt(consola.nextLine());
                var buscar = new Empleado(idEmpelado);
                var encontrado = empleadoDao.buscarEmpleadoPorId(buscar);
                if(encontrado){
                    var eliminarEmpleado = new Empleado(idEmpelado);
                    var eliminado = empleadoDao.eliminarEmpleado(eliminarEmpleado);
                    System.out.println("Empleado eliminado: " + buscar);
                }
                else{
                    System.out.println("Empleado No encontrado: " + buscar);
                }
            }
            case 6 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opción No reconocida: " + opcion);
        }
        return salir;
    }
}
