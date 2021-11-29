package libreria.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import libreria.entidades.Libro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-16T03:11:41")
@StaticMetamodel(Editorial.class)
public class Editorial_ { 

    public static volatile ListAttribute<Editorial, Libro> libros;
    public static volatile SingularAttribute<Editorial, Long> id;
    public static volatile SingularAttribute<Editorial, String> nombre;

}