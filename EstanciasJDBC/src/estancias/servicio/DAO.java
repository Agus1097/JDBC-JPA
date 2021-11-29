package estancias.servicio;

import java.sql.*;

public class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private String usuario = "root";
    private String clave = "root";
    private String nombreDatabase = "estancias_exterior";

    protected void conectar() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + nombreDatabase + "?useSSL=false";
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new Exception ("Error al conectarse");
        }
    }
    
    protected void desconectar() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception ("Error al desconectarse");
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            //Creo la conexión con la base
            conectar();
            //Creo la sentencia
            sentencia = conexion.createStatement();
            //Ejecuto la sentencia con el sql pasado como parámetro
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            try {
                //En caso de error retorno toda módificación para atras
                conexion.rollback();
            } catch (SQLException ex1) {
                throw new Exception("Error de Sistemas");
            }
            throw new Exception("Error de Sistemas");
        }
    }
    
    protected void consultar(String sql) throws Exception {
        try {
            conectar();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al consultar");
        }
    }
}


