package estancias.servicio;

import estancias.entidades.Casa;
import java.sql.SQLException;
import java.util.Collection;

public class CasaServicios extends DAO {

    private CasaDAO dao = new CasaDAO();

    public void sentenciaB() throws Exception {
        try {

            Collection<Casa> casas = dao.CasaFechaDesdeHasta();

            if (casas == null || casas.isEmpty()) {
                throw new Exception("No existen casas para imprimir");
            } else {

                System.out.println("ID   Calle      Nro  CP  Ciudad  Pais  FechaDesde  FechaHasta  "
                        + "Tminimo  Tmaximo Precio  Tipo");

                for (Casa c : casas) {
                    System.out.print(c.getId_casa() + "    ");
                    System.out.print(c.getCalle() + "  ");
                    System.out.print(c.getNumero() + "  ");
                    System.out.print(c.getCodigo_postal() + "  ");
                    System.out.print(c.getCiudad() + "  ");
                    System.out.print(c.getPais() + "  ");
                    System.out.print(c.getFecha_desde() + "  ");
                    System.out.print(c.getFecha_hasta() + "  ");
                    System.out.print(c.getTiempo_minimo() + "  ");
                    System.out.print(c.getTiempo_maximo() + "  ");
                    System.out.print(c.getPrecio_habitacion() + "  ");
                    System.out.print(c.getTipo_vivienda() + "  ");
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir casas entre el 1 y 31 de agosto");
        }

    }

    public void sentenciaE() throws Exception {
        try {

            Collection<Casa> casas = dao.CasaFechaDesdeDias();

            if (casas == null || casas.isEmpty()) {
                throw new Exception("No existen casas para imprimir con esa fecha o dias");
            } else {

                System.out.println("ID   Calle      Nro  CP  Ciudad  Pais  FechaDesde  FechaHasta  "
                        + "Tminimo  Tmaximo Precio  Tipo");

                for (Casa c : casas) {
                    System.out.print(c.getId_casa() + "    ");
                    System.out.print(c.getCalle() + "  ");
                    System.out.print(c.getNumero() + "  ");
                    System.out.print(c.getCodigo_postal() + "  ");
                    System.out.print(c.getCiudad() + "  ");
                    System.out.print(c.getPais() + "  ");
                    System.out.print(c.getFecha_desde() + "  ");
                    System.out.print(c.getFecha_hasta() + "  ");
                    System.out.print(c.getTiempo_minimo() + "  ");
                    System.out.print(c.getTiempo_maximo() + "  ");
                    System.out.print(c.getPrecio_habitacion() + "  ");
                    System.out.print(c.getTipo_vivienda() + "  ");
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir casas con esa fecha o dias");
        }
    }

    public void sentenciaF() throws Exception {
        try {
            dao.ModificarPrecios();
            Collection<Casa> casas = dao.PreciosModificados();

            if (casas == null || casas.isEmpty()) {
                throw new Exception("No existen precios modificados");
            } else {
                System.out.println("ID  Precio");
                for (Casa c : casas) {
                    System.out.print(c.getId_casa() + "    ");
                    System.out.print(c.getPrecio_habitacion());
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir los precios modificados");
        }
    }

    public void sentenciaG() throws Exception {
        try {
            Collection<Casa> casas = dao.CasasPais();

            if (casas == null || casas.isEmpty()) {
                throw new Exception("No existen paises agrupados");
            } else {
                System.out.println("Casas por pais      Pais");
                for (Casa c : casas) {
                    System.out.print("       " + c.getCasas_por_paias()+ "           ");
                    System.out.print(c.getPais());
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir los paises agrupados");
        }
    }

    public void sentenciaH() throws Exception {
        try {
            Collection<Casa> casas = dao.CasasLimpias();

            if (casas == null || casas.isEmpty()) {
                throw new Exception("No existen casas limpias");
            } else {
                System.out.println("Casas limpias");
                for (Casa c : casas) {
                    
                    System.out.print(c.getId_casa());
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir casas limpias");
        }
    }
}
