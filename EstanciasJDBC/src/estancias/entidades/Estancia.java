package estancias.entidades;

import java.util.Date;

public class Estancia {

    private int id_estancia;
    private Cliente id_cliente;
    private Casa id_casa;
    private String nombre_huespe;
    private Date fecha_desde;
    private Date fecha_hasta;

    public Estancia() {
    }

    public Estancia(int id_estancia, Cliente id_cliente, Casa id_casa, String nombre_huespe, Date fecha_desde, Date fecha_hasta) {
        this.id_estancia = id_estancia;
        this.id_cliente = id_cliente;
        this.id_casa = id_casa;
        this.nombre_huespe = nombre_huespe;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    public int getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }

    public String getNombre_huespe() {
        return nombre_huespe;
    }

    public void setNombre_huespe(String nombre_huespe) {
        this.nombre_huespe = nombre_huespe;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Casa getId_casa() {
        return id_casa;
    }

    public void setId_casa(Casa id_casa) {
        this.id_casa = id_casa;
    }

}
