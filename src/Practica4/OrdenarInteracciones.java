package Practica4;

import graphsDSESIUCLM.*;
import java.util.Comparator;

/**
 * Esta clase se encarga de comparar la suma de los pesos de todos los vertices
 * con el fin de ordenarlos de menor a mayor.
 * 
 * @author David Gonz�lez, Lucas Guti�rrez y Sergio Jim�nez
 * @version 1.0
 */

public class OrdenarInteracciones<T> implements Comparator<Vertex<ElementoDecorado<String>>> {
	
	/**
	 * El algoritmo comparar� el par�metro interacciones de dos objetos decorados
	 * (e1 y e2). Estos elementos decorados se construyen empleando los vertices v1
	 * y v2 introducidos al llamar al m�todo.
	 * 
	 * @param v1 Ser� un vertice de tipo ElementoDecorado de tipo String a comparar.
	 * @param v2 Ser� un vertice de tipo ElementoDerocado de tipo String a comparar.
	 * @return Devuelve un valor -1, 0 o 1 dependiendo de que vertice tenga menos
	 *         interacciones.
	 */
    
    public int compare(Vertex<ElementoDecorado<String>> v1, Vertex<ElementoDecorado<String>> v2) {
		ElementoDecorado<String> e1, e2;
    	e1 = v1.getElement();
    	e2 = v2.getElement();
        if (e1.getInteracciones() < e2.getInteracciones()) {
            return -1;
        }
        if (e1.getInteracciones() > e2.getInteracciones()) {
            return 1;
        }
        return 0;
    }
}
