package estancias.servicio;

import estancias.entidades.Casa;
import estancias.entidades.Comentario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;

public class CasaDAO extends DAO {

    Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public Collection<Casa> CasaFechaDesdeHasta() throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde >= '2020-09-01' AND fecha_hasta <= '2020-07-31' "
                    + "AND pais = 'Reino Unido';";
            consultar(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFecha_desde(resultado.getDate(7));
                casa.setFecha_hasta(resultado.getDate(8));
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getDouble(11));
                casa.setTipo_vivienda(resultado.getString(12));
                casas.add(casa);
            }
            return casas;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al listar casas entre el 01 y 31 de agosto");
        }
    }

    public Collection<Casa> CasaFechaDesdeDias() throws Exception {

        System.out.println("Ingrese la fecha que desea ir a la casa (YYYY-MM-DD)");
        String fecha = sc.next();
        LocalDate fechaDada = LocalDate.parse(fecha);

        System.out.println("Ingrese el tiempo que desea quedarse en la casa");
        int tiempoDado = sc.nextInt();
        
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde >= '" + fechaDada + "' AND tiempo_minimo <= " + tiempoDado
                    + " AND tiempo_maximo >= " + tiempoDado + ";";
            consultar(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFecha_desde(resultado.getDate(7));
                casa.setFecha_hasta(resultado.getDate(8));
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getDouble(11));
                casa.setTipo_vivienda(resultado.getString(12));
                casas.add(casa);
            }
            return casas;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al listar casas disponibles");
        }
    }
    
    
    public void ModificarPrecios() throws Exception {
        try {
            String sql = "UPDATE casas SET precio_habitacion = ROUND((precio_habitacion*1.05),2)";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public Collection<Casa> PreciosModificados() throws Exception {
        try {
            String sql = "SELECT id_casa, precio_habitacion FROM casas;";
            consultar(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList();
            while (resultado.next()){
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setPrecio_habitacion(resultado.getDouble(2));
                casas.add(casa);
            }
            return casas;
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("Error al listar los precios modificados");
        }
    }
    
    public Collection<Casa> CasasPais() throws Exception {
        try {
            String sql = "SELECT COUNT(pais), pais FROM casas GROUP BY pais;";
            consultar(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList();
            while (resultado.next()){
                casa = new Casa();
                casa.setCasas_por_paias(resultado.getInt(1));
                casa.setPais(resultado.getString(2));
                casas.add(casa);
            }
            return casas;
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("Error al listar los precios modificados");
        }
    }
    
    public Collection<Casa> CasasLimpias() throws Exception {
        try {
            String sql = "SELECT c.id_casa, co.comentario FROM casas c, comentarios co "
                    + "WHERE co.id_casa=c.id_casa AND co.comentario LIKE '%limpia%';";
            consultar(sql);
            Casa casa = null;
            Comentario comentario = null;
            Collection<Casa> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                
                comentario = new Comentario();
                comentario.setId_casa_comentario(resultado.getInt(2));
                casa.setId_casa(comentario.getId_casa_comentario());
                
                casas.add(casa);
                
                
                
                
            }
            return casas;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al listar casas entre el 01 y 31 de agosto");
        }
    }
}
