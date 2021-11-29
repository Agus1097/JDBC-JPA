package estancias.servicio;

import estancias.entidades.Familia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class FamiliaDAO extends DAO {

    public Collection<Familia> FamiliasTresHijos() throws Exception {
        try {
            String sql = "SELECT nombre, num_hijos, edad_maxima FROM familias WHERE num_hijos>=3 AND edad_maxima < 10;";
            consultar(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList();
            while (resultado.next()) {
                familia = new Familia();
                familia.setNombre(resultado.getString(1));
                familia.setNum_hijos(resultado.getInt(2));
                familia.setEdad_maxima(resultado.getInt(3));

                familias.add(familia);
            }
            return familias;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al listar las familias con 3 hijos");
        } finally {
            desconectar();
        }
    }

    public Collection<Familia> FamiliasconY() throws Exception {
        try {
            String sql = "SELECT id_familia, nombre FROM familias WHERE nombre LIKE '%y';";
            consultar(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList();
            while (resultado.next()) {
                familia = new Familia();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familias.add(familia);
            }
            return familias;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al listar familias con 'y'");
        } finally {
            desconectar();
        }
    }
    
    public Collection<Familia> FamiliasConHotmail() throws Exception {
        try {
            String sql = "SELECT id_familia, nombre, email FROM familias WHERE email LIKE '%hotmail%';";
            consultar(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList();
            while (resultado.next()) {
                familia = new Familia();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEmail(resultado.getString(3));
                familias.add(familia);
            }
            return familias;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al listar familias con hotmail");
        } finally {
            desconectar();
        }
    }
}
