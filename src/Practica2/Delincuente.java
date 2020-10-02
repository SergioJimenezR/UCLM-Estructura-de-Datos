// Fecha 16/10/2019
package Practica2;

/**
*
* Delincuente. Crea delincuentes con diferentes campos descriptivos.
* Esta clase no dispone de ningún setter ya que todos los datos son 
* generados de forma aleatoria.
* @author David González, Lucas Gutiérrez y Sergio Jiménez
* @version 1.0
*
*/

public class Delincuente {
	private int dni;
	private String delito;
	private String peligrosidad;
	private int nPeligrosidad;
	
	/**
	 * Al constructor delincuente no se le pasa ningun parametro ya que será ahi
	 * donde los datos se generen de forma aleatoria.
	 * 
	 */	
	public Delincuente() {
		
		String vdelito[] = {"Fiscal","Robo","Acoso","Drogas","Armas","Otros"};
		String vpeligrosidad[] = {"bajo", "conflictivo", "altamente peligroso"};
		
		this.dni = (int)(Math.random()*(100000000));
		this.delito = vdelito[(int)(Math.random()*6)];
		this.nPeligrosidad = (int)(Math.random()*3);
		this.peligrosidad = vpeligrosidad[nPeligrosidad];
	}
	
	/**
	 * Get que devuelve el DNI.
	 * @return dni
	 */
	public int getDni() {
		return dni;
	}
	
	/**
	 * Get que devuelve el delito.
	 * @return delito
	 */
	public String getDelito() {
		return delito;
	}

	/**
	 * Get que devuelve un numero de peligrosidad.
	 * @return nPeligrosidad
	 */
	public int getNPeligrosidad() {
		return nPeligrosidad;
	}

	/**
	 * @return Devuelve una cadena de texto donde está toda la 
	 * información del delincuente.
	 */
	public String toString() {
		return "dni: "+dni+", delito: "+delito+", peligrosidad: "+peligrosidad;
	}
}

