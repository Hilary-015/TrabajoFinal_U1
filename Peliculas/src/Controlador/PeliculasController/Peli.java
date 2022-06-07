
package Controlador.PeliculasController;

import Controlador.TDA_Cola.ColaService;
import Modelo.DatosPelicula;
import Modelo.Ratings;

/**
 *
 * @author Hilary Calva
 */
public class Peli extends DatosPelicula{

    public Peli(String title, short year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, ColaService<Ratings> cola, String metascore, String imdbRating, String imdbVotes, String imdbID, String tipo, String DVD, String boxOffice, String production, String website, String response) {
        super(title, year, rated, released, runtime, genre, director, writer, actors, plot, language, country, awards, poster, cola, metascore, imdbRating, imdbVotes, imdbID, tipo, DVD, boxOffice, production, website, response);
    }

    public Peli() {
    }
    
}
