package libreria.servicios;

import java.util.Locale;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {

    AutorDAO autorDAO = new AutorDAO();

    public Autor crearAutor() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        Autor autor = new Autor();

        do {
            System.out.print("Ingrese el nombre del autor: > ");
            autor.setNombre(sc.next());
            if (autor.getNombre().isEmpty()) {
                System.out.println("El nombre ingresado es incorrecto");
            }
        } while (!autor.getNombre().isEmpty());

        autorDAO.guardarAutor(autor);
        return autor;
    }
}
