package Practica4;

import graphsDSESIUCLM.*;

/**
* ElementoDecorado. Crea elementos decorados con diferentes campos descriptivos.
* Estos elementos decorados pueden ser vertices o aristas. 
* @author David Gonz�lez, Lucas Guti�rrez y Sergio Jim�nez
* @version 1.0
*/

public class ElementoDecorado<T> implements Element {
	private String id;
	private T element;
	private boolean visitado;
	private int grado;
	private int interacciones;
	private ElementoDecorado<T> padre;
	private int distancia;

	/**
	 * Al constructor ElementoDecorado se le pasan los valores id y un elemento T.
	 * Al crear un elemento decorado se le asignan los valores declarados en el constructor
	 * que luego seran actualizados con sus valores reales. 
	 * @param id ser� un identificador del elemento decorado
	 * @param element ser� un objeto decorado T conel valor de la arista o del valor del vertice
	 */	
	public ElementoDecorado(String id, T element) {
		this.id = id;
		this.element = element;
		visitado = false;
		grado = 0;
		interacciones = 0;
		distancia = 0;
	}

	/**
	 * El m�todo equals se encarga de comparar 2 vertices. si los id son identicos
	 * uno de esos dos se descarta y solo uno se meter� en el grafo.
	 * @param n ser� un vertice a comparar
	 * @return boolean. True si encuentra un elemento igual, false si no.
	 */	
	public boolean equals(Object n) {
		return (id.equals(((ElementoDecorado) n).getID()) 
				&& element.equals(((ElementoDecorado<T>) n).getElement()));
	}
	
	/**
	 * Get que devuelve el elemento decorado padre.
	 * @return padre
	 */
	public ElementoDecorado<T> getPadre() {
	    return padre;
	}
	
	/**
	 * Set que actualiza el valor de padre.
	 * @param u
	 */
	public void setPadre(ElementoDecorado<T> u) {
	    padre = u;
	}	
	
	/**
	 * Get que devuelve la distancia.
	 * @return distancia
	 */
	public int getDistancia() {
		return distancia;
	}
	
	/**
	 * Set que actualiza el valor de distancia.
	 * @param nuevaDistancia
	 */
	public void setDistancia(int nuevaDistancia) {
		distancia = nuevaDistancia;
	}
	
	/**
	 * Get que devuelve el grado del vertice.
	 * @return grado
	 */
	public int getGrado() {
		return grado;
	}

	/**
	 * Set que actualiza el valor de grado.
	 * @param nuevoGrado
	 */
	public void setGrado(int nuevoGrado) {
		grado = nuevoGrado;
	}
	
	/**
	 * Get que devuelve el numero de interacciones.
	 * @return interacciones
	 */
	public int getInteracciones() {
		return interacciones;
	}

	/**
	 * Set que actualiza el valor de interacciones.
	 * @param nInteracciones
	 */
	public void setInteracciones(int nInteracciones) {
		interacciones = nInteracciones;
	}
	
	/**
	 * Get que devuelve el elemento T.
	 * @return element
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Get que devuelve un boolean.
	 * @return visitado
	 */
	public boolean getVisitado() {
		return visitado;
	}

	/**
	 * Set que actualiza el valor de visitado.
	 * @param v
	 */
	public void setVisitado(boolean v) {
		visitado = v;
	}

	/**
	 * M�todo toString que devuelve informaci�n del elemento decorado
	 * @return element.toString
	 */
	public String toString() {
		return element.toString();
	}
	
	/**
	 * Get que devuelve el id.
	 * @return id
	 */
	public String getID() {
		return id;
	}
}
