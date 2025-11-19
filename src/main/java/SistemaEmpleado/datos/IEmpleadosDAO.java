package SistemaEmpleado.datos;

import SistemaEmpleado.domino.Empleado;

import java.util.List;

public interface IEmpleadosDAO {
    List<Empleado>listarEmpleados();
    boolean buscarEmpleadoPorId(Empleado empleado);
    boolean agregarEmpleado(Empleado empleado);
    boolean modificarEmpleado(Empleado empleado);
    boolean eliminarEmpleado(Empleado empleado);
}
