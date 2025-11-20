package SistemaEmpleado.datos;

import SistemaEmpleado.domino.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static SistemaEmpleado.conexion.Conexion.getConexion;

public class EmpleadoDAO implements IEmpleadosDAO{
    @Override
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM empleado ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var empleado = new Empleado();
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setDepartamento(rs.getString("departamento"));
                empleados.add(empleado);
            }
        }catch(Exception e){
            System.out.println("Error al listar los empleados: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return empleados;
    }

    @Override
    public boolean buscarEmpleadoPorId(Empleado empleado) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM empleado WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setDepartamento(rs.getString("departamento"));
                return true;
            }
        }catch(Exception e){
            System.out.println("Error al buscar los empleados: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarEmpleado(Empleado empleado) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "INSERT INTO empleado(nombre, apellido, salario, departamento) VALUES (?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setDouble(3, empleado.getSalario());
            ps.setString(4, empleado.getDepartamento());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al agregar los empleados: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarEmpleado(Empleado empleado) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE empleado SET nombre=?, apellido=?, salario=?, departamento=? WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setDouble(3, empleado.getSalario());
            ps.setString(4, empleado.getDepartamento());
            ps.setInt(5, empleado.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar los empleados: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarEmpleado(Empleado empleado) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "DELETE FROM empleado WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleado.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //IEmpleadosDAO empleadosDao = new EmpleadoDAO();
         // Listar Empleados
//        System.out.println("*** Listar Empleados ***");
//        var listar = empleadosDao.listarEmpleados();
//        listar.forEach(System.out::println);

//        //Buscar Empleado
//        System.out.println("*** Buscar Empleado ***");
//        var buscar = new Empleado(1);
//        var encontrado = empleadosDao.buscarEmpleadoPorId(buscar);
//        if(encontrado){
//            System.out.println("Empleado encontrado: " + buscar);
//        }
//        else{
//            System.out.println("Empleado No encontrado: " + buscar);
//        }

//        //Agregar Empleado
//        System.out.println("*** Agregar Empleado ***");
//        var agregar = new Empleado("Martín", "Heidegger", 50.0, "Humanidades");
//        var agregado = empleadosDao.agregarEmpleado(agregar);
//        if(agregado){
//            System.out.println("Empleado agregado: " + agregar);
//        }
//        else{
//            System.out.println("Empleado No agregado: " + agregar);
//        }

//        //Modificar Empleado
//        System.out.println("*** Modificar Empleado ***");
//        var modificar = new Empleado(2, "Inmanuel", "Kant", 150.0, "Filosofía");
//        var modificado = empleadosDao.modificarEmpleado(modificar);
//        if(modificado){
//            System.out.println("Empleado modificado: " + modificar);
//        }
//        else{
//            System.out.println("Empleado No modificado: " + modificar);
//        }

//        // Eliminar Empleados
//        System.out.println("*** Eliminar Empleados ***");
//        var eliminar = new Empleado(2);
//        var eliminado = empleadosDao.eliminarEmpleado(eliminar);
//        if(eliminado){
//            System.out.println("Empleado eliminado: " + eliminar);
//        }
//        else{
//            System.out.println("Empleado No eliminado: " + eliminar);
//        }
//
    }
}
