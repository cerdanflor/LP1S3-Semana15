package modeloDAO;

import config.bd.ConectaBd;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;

public class EstudianteDAO implements CRUD{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Estudiante e = new Estudiante();
    
    @Override
    public List listarestudiante() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        String consulta = " select *  "
                        + "from estudiante ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while(rs.next()){
                Estudiante estudiante = new Estudiante();
                estudiante.setIdestudiante(rs.getInt("idestudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setDni(rs.getString("dni"));
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setEstado(rs.getString("estado"));
                estudiantes.add(estudiante);
            }            
        } catch (SQLException e) {
            System.out.println("Error durante el select");
        }
        return estudiantes;
    }

    @Override
    public Estudiante buscarestudiante(int idestudiante) {
        String consulta = " select *  "
                        + "from estudiante  "
                        + "where idestudiante = " + idestudiante + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                e.setIdestudiante(rs.getInt("idestudiante"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setDni(rs.getString("dni"));
                e.setCodigo(rs.getString("codigo"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error durante el select");        
        }
        return e;
    }

    @Override
    public boolean agregarestudiante(Estudiante estudiante) {
        String consulta = " insert into estudiante(nombre, apellidos, dni, codigo, estado)  "
                        + " values(  "
                        + "'"+ estudiante.getNombre() +"', "
                        + "'"+ estudiante.getApellidos() +"',  "
                        + "'"+ estudiante.getDni() +"',  "
                        + "'"+ estudiante.getCodigo() +"',  "
                        + "'"+ estudiante.getEstado() +"'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la insert del nuevo estudiante");
            return true;
        }
        return false;
    }

    @Override
    public boolean editarestudiante(Estudiante estudiante) {
        String consulta = " update estudiante  "
                        + " set  "
                        + " nombre = '"+ estudiante.getNombre() +"', "
                        + " apellidos = '"+ estudiante.getApellidos() +"', "
                        + " dni = '"+ estudiante.getDni() +"', "
                        + " codigo = '"+ estudiante.getCodigo()+"', "
                        + " estado = '"+ estudiante.getEstado() +"'  "
                        + " where "
                        + " idestudiante = " + estudiante.getIdestudiante() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del estudiante");
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarestudiante(int idestudiante) {
        String consulta = " delete  "
                        + " from estudiante  "
                        + " where "
                        + " idestudiante = " + idestudiante;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del estudiante");
            return true;
        }
        return false;
    }    
}
