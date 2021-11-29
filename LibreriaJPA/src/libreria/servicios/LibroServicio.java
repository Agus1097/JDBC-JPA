package libreria.servicios;

import java.util.Locale;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.entidades.Libro_;
import static libreria.entidades.Libro_.autor;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;
import libreria.persistencia.LibroDAO;

public class LibroServicio {

    private LibroDAO libroDAO = new LibroDAO();
    private AutorServicio autorServicio = new AutorServicio();
    private EditorialServicio editorialServicio = new EditorialServicio();
    private Autor autor = new Autor();
    private Editorial editorial = new Editorial();
    private AutorDAO autorDAO = new AutorDAO();
    private EditorialDAO editorialDAO = new EditorialDAO();

    public void crearLibro() {

        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        Libro libro = new Libro();

        System.out.print("Ingrese la cantidad de libros que desea crear: > ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {

            System.out.print("Ingrese el ISBN: > ");
            Long isbn = sc.nextLong();
            libro.setIsbn(isbn);

            do {
                System.out.print("Ingrese el nombre del Libro: > ");
                libro.setTitulo(sc.next());
                if (libro.getTitulo().isEmpty()) {
                    System.out.println("El nombre del titulo es incorrecto");
                }
            } while (!libro.getTitulo().isEmpty());

            String num = null;
            do {
                System.out.print("Ingrese el año: > ");
                libro.setAnio(sc.nextInt());
                num = Integer.toString(libro.getAnio());
                if (num.length() != 4) {
                    System.out.println("El numero ingresado no tiene cuatro digitos");
                }
            } while (libro.getAnio() != 0 && num.length() != 4);

            do {
                System.out.print("Ingrese la cantidad de ejemplares: > ");
                libro.setEjemplares(sc.nextInt());
            } while (libro.getEjemplares() != 0);

            System.out.print("Ingrese la cantidad de prestados: > ");
            int prestados = sc.nextInt();
            libro.setPrestados(prestados);

            libroDAO.guardarLibro(libro);
        }
    }

    public void imprimirLibro() {

        for (Libro libro : libroDAO.mostrarLibro()) {
            System.out.println(libro);
        }
    }

}
