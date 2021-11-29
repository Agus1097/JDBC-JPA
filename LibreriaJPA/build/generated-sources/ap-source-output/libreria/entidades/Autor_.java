package libreria.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import libreria.entidades.Libro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-16T03:11:41")
@StaticMetamodel(Autor.class)
public class Autor_ { 

    public static volatile ListAttribute<Autor, Libro> libros;
    public static volatile SingularAttribute<Autor, Long> id;
    public static volatile SingularAttribute<Autor, String> nombre;

}