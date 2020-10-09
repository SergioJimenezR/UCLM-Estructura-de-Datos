package Practica3;

/**
 * Clase Vecino
 * @author David Gonz�lez Berm�dez, Lucas Guti�rrez Dur�n, Sergio Jim�ne Roncero
 *
 */
public class Vecino {
	
	private int dni;
	private int posicion;
	
	/**
	 * Constructor de Vecino
	 * @param i
	 */
	public Vecino(int i) {
		this.dni = DNIaleatorio();
		this.posicion = i;
	}
	
	/**
	 * Get que devuelve el DNI.
	 * @return dni
	 */
	public int getDNI() {
		return dni;
	}
	
	/**
	 * Get que devuelve la posici�n del vecino en su lista
	 * @return posicion
	 */
	public int getPosicion() {
		return posicion;
	}
	
	/**
	 * M�todo que genera el DNI aleatorio para el constructor.
	 * @return dni
	 */
	private int DNIaleatorio() {
		return (int)(Math.random()*100000000);
	}
	
	/**
	 * M�todo que devuelve el �ltimo d�gito del DNI al calcularse el resto de dividirse entre 10. Intervalo [0, 9]
	 * @return int
	 */
	public int devolverUltimoNumeroDNI() {
		return dni%10;
	}
	
	/**
	 * M�todo toString de Vecino
	 * @return String
	 */
	public String toString() {
		return "DNI: " + dni + letra();
	}
	
	/**
	 * M�todo que devuelve la letra correspondida a dicho DNI para completar.
	 * @return letra
	 */
	public char letra() {
		char[] v = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		return v[dni%23];
	}
	
}
