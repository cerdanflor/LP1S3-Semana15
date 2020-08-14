
package vistacontrol;

import java.util.List;
import modelo.Estudiante;
import modeloDAO.EstudianteDAO;
import utils.Leer;

public class Index {
    public static void AgregarEstudiante(){
        String nombre;
        String apellidos;
        String dni;
        String codigo;
        String estado;
        System.out.println("Agregar Nuevo Estudiante");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Apellidos: ");
        apellidos = Leer.cadena();
        System.out.print("DNI: ");
        dni = Leer.cadena();
        System.out.print("Codigo: ");
        codigo = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Estudiante estudiante = new Estudiante(nombre, apellidos, dni, codigo, estado);
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        estudianteDAO.agregarestudiante(estudiante);
        
    }
    public static void EliminarEstudiante(){
        ListarEstudiante();
        System.out.print("Ingrese el ID del Estudiante a Eliminar: ");
        int id = Leer.entero();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        estudianteDAO.eliminarestudiante(id);
    }
    public static void EditarEstudiante(){
        ListarEstudiante();
        System.out.print("Ingrese el ID del estudiante a Editar: ");
        int id = Leer.entero();
        String nombre;
        String apellidos;
        String dni;
        String codigo;
        String estado;
        System.out.println("Editar Estudiante");
        System.out.print("Nuevo Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Nuevo Apellidos: ");
        apellidos = Leer.cadena();
        System.out.print("Nuevo DNI: ");
        dni = Leer.cadena();
        System.out.print("Nuevo Codigo: ");
        codigo = Leer.cadena();
        System.out.print("Nuevo Estado: ");
        estado = Leer.cadena();
        Estudiante estudiante = new Estudiante(id, nombre, apellidos, dni, codigo, estado);
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        estudianteDAO.editarestudiante(estudiante);
    }
    public static void ListarEstudiante(){
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        List<Estudiante> estudiantes = estudianteDAO.listarestudiante();
        System.out.println("ID\tApellidos y Nombre\t\tDNI\t\tCodigo\t\tEstado");
        for (Estudiante estudiante : estudiantes) {
            System.out.println( estudiante.getIdestudiante() + "\t" + 
                                estudiante.getNombreCompleto() + "\t" + 
                                estudiante.getDni() + "\t" +
                                estudiante.getCodigo() + "\t" +
                                estudiante.getEstado());            
        }
        
    }
    public static void salir(){
        System.out.println("Gracias por su visita");
    }
    public static void error(int tipo){
        switch(tipo){
            case 1:
                System.out.println("Opción fuera de rango");
                break;
            case 2:
                System.out.println(".....");
                break;
        }
        
    }
    public static void menu(){
        System.out.println("Menu Principal");
        System.out.println("1. Agregar Estudiante");
        System.out.println("2. Eliminar Estudiante");
        System.out.println("3. Editar Estudiante");
        System.out.println("4. Listar Estudiante");
        System.out.println("5. Salir");
        System.out.print("Elegir las opciones [1-5]: ");
        
    }
    public static void inicio(){
        int opcion;
        do {            
            menu();
            opcion = Leer.entero();
            switch(opcion){
                case 1:
                    AgregarEstudiante();
                    break;
                case 2:
                    EliminarEstudiante();
                    break;
                case 3:
                    EditarEstudiante();
                    break;
                case 4:
                    ListarEstudiante();
                    break;
                case 5:
                    salir();
                    break;
                default:
                    error(1);
            }            
        } while (opcion!=5);
    }
    public static void main(String[] args) {
        inicio();
    }    
}
