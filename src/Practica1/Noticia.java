// Fecha 16/10/2019
package Practica1;

import java.util.Date;

/**
*
* Noticia. Crea noticias con diferentes campos descriptivos.
* Esta clase no dispone de ningún setter ya que todos los datos le son pasados
* por ficheros y son inalterables.
* @author David González, Lucas Gutiérrez y Sergio Jiménez
* @version 1.0
*
*/

public class Noticia {
	
	private String titulo;
	private String categoria;
	private String descripcion;
	private Date fecha;
	private String autor;
	
	/**
	 * Al constructor noticia se le pasan todos los parámetros tipo String menos fecha que 
	 * ha sido convertido a tipo Date.
	 * @param titulo String con el nombre de la noticia.
	 * @param categoria String con el género de la noticia
	 * @param descripcion Cadena de texto con una breve descripción de la noticia.
	 * @param autor String con el nombre del autor.
	 * @param fecha Fecha de la noticia con el formato Date
	 */
	public Noticia(String titulo, String categoria, String descripcion, String autor, Date fecha) {
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha = fecha;
	}
	/**
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @return categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @return autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @return Devuelve una cadena de texto donde está toda la 
	 * información de la noticia.
	 */
	public String toString() {
		return "Titulo: " + titulo + "\n" +
				"Autor: " + autor + "\n" +
				"Categoría: " + categoria + "\n" + 
				"Descripción: " + descripcion + "\n" + 
				"Fecha: " + fecha + "\n"; 
	}

}
