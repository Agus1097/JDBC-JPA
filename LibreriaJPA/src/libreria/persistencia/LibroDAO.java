package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Libro;

public class LibroDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("LibreriaJPAPU").createEntityManager();

    public void guardarLibro(Libro libro) {
        em.getTransaction().begin();
        try {
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void modificarLibro(Libro libro) {
        em.getTransaction().begin();
        try {
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void eliminarLibro(Libro libro) {
        em.getTransaction().begin();
        try {
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<Libro> mostrarLibro() {
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        return libros;
    }

    public Libro buscarPorIsbn(Long isbn) {
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class).setParameter("isbn", isbn).getResultList();
        Libro libro = null;
        if (libros.isEmpty()) {
            return null;
        }
        libro = libros.get(0);
        return libro;
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo", Libro.class).setParameter("titulo", titulo).getResultList();
        if (libros.isEmpty()) {
            return null;
        }
        return libros;
    }

    public List<Libro> buscarPorAnio(int anio) {
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.anio = :anio", Libro.class).setParameter("anio", anio).getResultList();
        if (libros.isEmpty()) {
            return null;
        }
        return libros;
    }

}
