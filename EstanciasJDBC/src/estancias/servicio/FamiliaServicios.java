package estancias.servicio;

import estancias.entidades.Familia;
import java.sql.SQLException;
import java.util.Collection;

public class FamiliaServicios {

    private FamiliaDAO dao = new FamiliaDAO();

    public void sentenciaA() throws Exception {
        try {
            Collection<Familia> familias = dao.FamiliasTresHijos();
            if (familias.isEmpty()) {
                throw new Exception("No existen familias con 3 hijos para imprimir");
            } else {
                System.out.println("Nombre de la familia  Numero de hijos  Edad Maxima");
                for (Familia f : familias) {
                    System.out.print("    " + f.getNombre() + "                  ");
                    System.out.print(f.getNum_hijos() + "              ");
                    System.out.print(f.getEdad_maxima());
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir familias con 3 hijos");
        }
    }

    public void sentenciaC() throws Exception {
        try {
            Collection<Familia> familias = dao.FamiliasconY();
            if (familias == null || familias.isEmpty()) {
                throw new Exception("No existen familias con 'y' para imprimir");
            } else {
                System.out.println("ID  Nombre");
                for (Familia f : familias) {
                    System.out.print(f.getId_familia() + "   ");
                    System.out.print(f.getNombre());
                    System.out.println("");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception ("Error al imprimir familias con 'y'");
        }
    }
    
        public void sentenciaD() throws Exception {
        try {
            Collection<Familia> familias = dao.FamiliasConHotmail();
            if (familias == null || familias.isEmpty()) {
                throw new Exception("No existen familias con hotmail para imprimir");
            } else {
                System.out.println("ID  Nombre          email");
                for (Familia f : familias) {
                    System.out.print(f.getId_familia() + "   ");
                    System.out.print(f.getNombre() + "       ");
                    System.out.print(f.getEmail());
                    System.out.println("");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception ("Error al imprimir familias con hotmail");
        }
    }
}
