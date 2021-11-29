package estancias;

import estancias.servicio.CasaServicios;
import estancias.servicio.FamiliaServicios;
import java.util.Locale;
import java.util.Scanner;

public class Estancias {
//Realizar un menú en java a través del cual se permita elegir qué consulta se desea
//realizar. Las consultas a realizar sobre la BD son las siguientes:
//a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10
//años.
//b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de
//agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
//c) Imagínate que, como cliente, estás interesado en mandar a tu hijo a una familia, de
//la que únicamente recuerdas que su nombre familiar terminaba en ‘y’. Escribe la
//consulta que te recupere las familias que cumplan tus restricciones.
//d) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
//e) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha
//dada y un número de días específico.
//f) Debido a la devaluación de la libra esterlina con respecto al euro se desea
//incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar
//los precios actualizados.
//g) Obtener el número de casas que existen para cada uno de los países diferentes.
//h) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas
//(comentarios) que están ‘limpias’.
//i) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas
    
    public static void main(String[] args) throws Exception {

        FamiliaServicios fliaserv = new FamiliaServicios();
        CasaServicios casaserv = new CasaServicios();

        Scanner sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        System.out.println("MENU DE CONSULTAS:");
        System.out.println("1) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años");
        System.out.println("2) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 "
                + "y el 31 de agosto de 2020 en Reino Unido.");
        System.out.println("3) Imagínate que, como cliente, estás interesado en mandar a tu hijo a una familia, de la que "
                + "únicamente recuerdas que su nombre familiar terminaba en ‘y’. Escribe la consulta que te recupere las "
                + "familias que cumplan tus restricciones.");
        System.out.println("4) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.");
        System.out.println("5) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y "
                + "un número de días específico.");
        System.out.println("6) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio"
                + "por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados");
        System.out.println("7) Obtener el número de casas que existen para cada uno de los países diferentes.");
        System.out.println("8) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) "
                + "que están ‘limpias’");
        System.out.println("9) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.");
        System.out.println("INGRESE LA CONSULTA QUE DESEE REALIZAR");
        int menu = sc.nextInt();
        switch (menu) {
            case 1:
                fliaserv.sentenciaA();
                break;
            case 2:
                casaserv.sentenciaB();
                break;
            case 3:
                fliaserv.sentenciaC();
                break;
            case 4:
                fliaserv.sentenciaD();
                break;
            case 5:
                casaserv.sentenciaE();
                break;
            case 6:
                casaserv.sentenciaF();
                break;
            case 7:
                casaserv.sentenciaG(); //CONSULTAR
                break;
            case 8:
                casaserv.sentenciaH(); //CONSULTAR
                break;

            default:
                System.out.println("Usted no ingreso un valor valido del menu");
                break;
        }

    }

}
