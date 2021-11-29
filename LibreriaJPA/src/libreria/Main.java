package libreria;

import java.util.Locale;
import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

public class Main {

    static Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    static LibroServicio libroServicio = new LibroServicio();
    static AutorServicio autorServicio = new AutorServicio();
    static EditorialServicio editorialServicio = new EditorialServicio();

    public static void main(String[] args) {

        menuGeneral();

    }

    public static void menuGeneral() {

        System.out.println("MENU GENERAL");
        System.out.println("1) Menu Libro");
        System.out.println("2) Menu Autor");
        System.out.println("3) Menu Editorial");
        System.out.println("4) Menu Cliente");
        System.out.println("5) Menu Prestamo");
        System.out.println("6) Salir del menu");
        System.out.println("");
        System.out.print("Ingrese una opcion: > ");
        int menu = sc.nextInt();
        switch (menu) {
            case 1:
                menuLibro();
                menuGeneral();
                break;
            case 6:
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;
        }
    }

    public static void menuLibro() {

        System.out.println("MENU LIBRO");
        System.out.println("1) Crear un libro");
        System.out.println("2) Consultar un libro");
        System.out.println("3) Modificar un libro");
        System.out.println("4) Eliminar un libro");
        System.out.println("5) Buscar por ISBN");
        System.out.println("6) Buscar por titulo");
        System.out.println("7) Buscar por año");
        System.out.println("8) Vover al menu anterior");
        System.out.print("Ingrese una opcion: > ");
        int menuLibro = sc.nextInt();

        switch (menuLibro) {
            case 1:
                libroServicio.crearLibro();
                libroServicio.imprimirLibro();
                break;
            case 8:
                menuGeneral();
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;

        }
    }

    public static void menuAutor() {
        System.out.println("MENU AUTOR");
        System.out.println("1)Buscar por ID");
        System.out.println("2)Buscar por nombre");
        System.out.println("3)Volver al menu anterior");
        System.out.print("Ingrese una opcion: > ");
        int menuAutor = sc.nextInt();

        switch (menuAutor) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                menuGeneral();
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;
        }
    }

    public static void menuEditorial() {
        System.out.println("MENU EDITORIAL");
        System.out.println("1)Buscar por ID");
        System.out.println("2)Buscar por nombre");
        System.out.println("3)Volver al menu anterior");
        System.out.print("Ingrese una opcion: > ");
        int menuEditorial = sc.nextInt();

        switch (menuEditorial) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                menuGeneral();
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;
        }
    }
}
