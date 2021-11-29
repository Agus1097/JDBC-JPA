package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class EditorialDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("LibreriaJPAPU").createEntityManager();

    public void guardar(Editorial editorial) {
        em.getTransaction().begin();
        try {
            em.persist(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Editorial buscarPorIsbn(Long isbn) {
        Editorial editorial = em.find(Editorial.class, isbn);
        return editorial;
    }
}