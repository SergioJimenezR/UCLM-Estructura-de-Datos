package Practica4;

import graphsDSESIUCLM.*;

import java.util.Comparator;

/**
* Esta clase se encarga de comparar los grados de los vertices con el objetivo
* de ordenarlos de mayor a menor. 
* @author David Gonz�lez, Lucas Guti�rrez y Sergio Jim�nez
* @version 1.0
*/

public class OrdenarGrado<T> implements Comparator<Vertex<ElementoDecorado<String>>> {
	
	/**
	 * El algoritmo comparar� el parametro grado de dos objetos decorados (e1 y e2).
	 * Estos elementos decorados se construyen empleando los vertices v1 y v2
	 * introducidos al llamar al m�todo.
	 * 
	 * @param v1 Ser� un vertice de tipo ElementoDecorado de tipo String a comparar.
	 * @param v2 Ser� un vertice de tipo ElementoDerocado de tipo String a comparar.
	 * @return Devuelve un valor -1, 0 o 1 dependiendo de que grado sea el mayor.
	 */
    
    public int compare(Vertex<ElementoDecorado<String>> v1, Vertex<ElementoDecorado<String>> v2) {
		ElementoDecorado<String> e1, e2;
    	e1 = v1.getElement();
    	e2 = v2.getElement();
        if (e1.getGrado() > e2.getGrado()) {
            return -1;
        }
        if (e1.getGrado() < e2.getGrado()) {
            return 1;
        }
        return 0;
    }
}