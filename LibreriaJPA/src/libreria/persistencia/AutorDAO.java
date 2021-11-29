package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("LibreriaJPAPU").createEntityManager();

    public void guardarAutor(Autor autor) {
        em.getTransaction().begin();
        try {
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Autor buscarPorId(Long id) {
        Autor autor = em.find(Autor.class, id);
        return autor;
    }

    public Autor buscarPorNombre(String nombre) {
        Autor autor = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre", Autor.class).setParameter("nombre", nombre).getSingleResult();
        if (autor.getNombre().isEmpty()) {
            return null;
        } else {
            return autor;
        }
    }
}
