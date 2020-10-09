// Fecha 16/10/2019
package Practica2;

import java.util.Comparator;

/**
* Esta clase se encarga de comparar a dos delincuentes
* segun cual sea su numero de peligrosidad.
* @author David González, Lucas Gutiérrez y Sergio Jiménez
* @version 1.0
*/

public class Ordenar implements Comparator<Delincuente> {
    @Override
    
    /**
	 * Como su nombre indica comparará a dos delincuentes.
	 * El algoritmo consiste en comparar el nPeligrosidad de cada delincuente.
	 * Si el delincuente x es más peligroso devolvera -1 y por el contrario
	 * si el delincuente y es más peligroso deolvera 1. En el caso de que ambos
	 * sean igual de peligrosos devolverá 0.
	 * @param x será un delincuente a comparar.
	 * @param y será un delincuente a comparar.
	 * @return Devuelve un valor -1, 0 o 1 dependiendo de que delincuente sea
	 * más peligroso
	 */
    public int compare(Delincuente x, Delincuente y) {
        if (x.getNPeligrosidad() > y.getNPeligrosidad()) {
            return -1;
        }
        if (x.getNPeligrosidad() < y.getNPeligrosidad()) {
            return 1;
        }
        return 0;
    }
}