package libreria.servicios;

import java.util.Locale;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {
    
    private EditorialDAO editorialDAO = new EditorialDAO();
    
    public void crearEditorial() {
        Editorial editorial = new Editorial();
        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        
        System.out.print("Ingrese el nombre de la editorial: > ");
        editorial.setNombre(sc.next());
        
        editorialDAO.guardar(editorial);
        
    }
}
