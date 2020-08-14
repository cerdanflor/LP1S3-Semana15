package interfaces;

import java.util.List;
import modelo.Estudiante;

public interface CRUD {
    public List listarestudiante();
    public Estudiante buscarestudiante(int idestudiante);
    public boolean agregarestudiante(Estudiante estudiante);
    public boolean editarestudiante(Estudiante estudiante);
    public boolean eliminarestudiante(int idestudiante);
}
