package estancias.entidades;

public class Comentario {

    private int id_comentario;
    private int id_casa_comentario;
    private String comentario;

    public Comentario() {
    }

    public Comentario(int id_comentario, int id_casa, String comentario) {
        this.id_comentario = id_comentario;
        this.id_casa_comentario = id_casa;
        this.comentario = comentario;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public int getId_casa_comentario() {
        return id_casa_comentario;
    }

    public void setId_casa_comentario(int id_casa) {
        this.id_casa_comentario = id_casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
