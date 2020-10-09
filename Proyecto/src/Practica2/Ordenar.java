// Fecha 16/10/2019
package Practica2;

import java.util.Comparator;

/**
* Esta clase se encarga de comparar a dos delincuentes
* segun cual sea su numero de peligrosidad.
* @author David Gonz�lez, Lucas Guti�rrez y Sergio Jim�nez
* @version 1.0
*/

public class Ordenar implements Comparator<Delincuente> {
    @Override
    
    /**
	 * Como su nombre indica comparar� a dos delincuentes.
	 * El algoritmo consiste en comparar el nPeligrosidad de cada delincuente.
	 * Si el delincuente x es m�s peligroso devolvera -1 y por el contrario
	 * si el delincuente y es m�s peligroso deolvera 1. En el caso de que ambos
	 * sean igual de peligrosos devolver� 0.
	 * @param x ser� un delincuente a comparar.
	 * @param y ser� un delincuente a comparar.
	 * @return Devuelve un valor -1, 0 o 1 dependiendo de que delincuente sea
	 * m�s peligroso
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