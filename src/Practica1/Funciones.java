// Fecha 16/10/2019
package Practica1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
* Esta clase se encarga de hacer de soporte al resto de clases.
* En esta clase est�n todas las funciones del sistema que no sean 
* relacionadas con ficheros.
* @author David Gonz�lez, Lucas Guti�rrez y Sergio Jim�nez
* @version 1.0
*/

public class Funciones {
	/**
	 * Como su nombre indica ordenar� una pila de Objetos Noticia.
	 * Usar� un algoritmo recursivo que solo necesitar� una pila. 
	 * Este algoritmo ser� totalmente �ptimo en espacio pero no en tiempo.
	 * @param p ser� la pila sin ordenar.
	 */
    public static void ordenarPila(Stack<Noticia> p) {
        if(!p.isEmpty()) {
            Noticia n = p.pop();
            ordenarPila(p);
            introducirElementoOrdenado(n, p);
        }
    }
   /**
    * Introduce una Noticia si su fecha es posterior a la cima o si la pila est� vacia,
    * si no saca el elemento de la cima y vuelve a comparar estos dos elementos.
    * @param n es la noticia, es decir, el elemento que compara.
    * @param p ser� la pila donde se ir�n metiendo los elementos que cumplan la condici�n.
    */
    public static void introducirElementoOrdenado(Noticia n, Stack<Noticia> p) {
        if(p.isEmpty() || compararFechas(n, (Noticia)p.peek())) { 
            p.push(n);
        } else {
            Noticia temporal = (Noticia)p.pop();
            introducirElementoOrdenado(n, p);
            p.push(temporal);
        }
    }
    /**
     * Compara fechas y devuelve verdadero si n es posterior a ultima.
     * @param n1 es una de las noticias que compara
     * @param n2 es la otra noticia que compara
     * @return
     */
    public static boolean compararFechas(Noticia n1, Noticia n2) {
		boolean esMayor = true;
    	esMayor = n1.getFecha().after(n2.getFecha());
		return esMayor;
	}
    /**
     * Pasa una fecha de tipo String a tipo Date usando como puente
     * el tipo SimpleDateFormat.
     * @param Se pasa la fecha como cadena de texto.
     * @return Devuelve la fecha en formato Date. Formato que permite comparar
     * unas fechas con otras f�cilmente.
     * @throws java.text.ParseException Es una excepci�n provocada al pasar de
     * SimpleDateFormat a Date.
     */
    public static Date parseFecha(String fecha) throws java.text.ParseException
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    /**
     * Este m�todo imprime las noticias que coincidan con la categor�a c que 
     * ha sido pasada al m�todo.
     * @param p es la pila de noticias.
     * @param c es un String que coincide con un valor de categoria en la clase Noticia
     * @param temporal es una noticia que se le pasa al principio sin un valor importante 
     * pero que luego es usada para comparar una noticia sacada de la pila
     * en una llamada recursiva y as� sucesivamente. 
     * Despu�s de la comparaci�n la Notica vuelve a entrar en la pila dejando la pila 
     * intacta.
     */
    public static void imprimirNoticias(Stack<Noticia> p, String c, Noticia temporal) {
    	
    	while (!p.isEmpty()) {
    		temporal = p.pop();
    		imprimirNoticias(p, c, temporal);
    		if(c.equals(temporal.getCategoria())) {
    			System.out.println(temporal.toString());
    		}
        	p.push(temporal);
    		break;
    	}
    	
    }
    
}
