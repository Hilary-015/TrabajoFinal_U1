
package Modelo;

import Controlador.TDA_Cola.ColaService;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Hilary Calva
 */
public class DatosPelicula {
    
    @SerializedName("Titulo")
    private String title;
    @SerializedName("Año")
    private short year;
    @SerializedName("Calificacion")
    private String rated;
    @SerializedName("Estreno")
    private String released;
    @SerializedName("Duracion")
    private String runtime;
    @SerializedName("Genero")
    private String genre;
    @SerializedName("Director")
    private String director;
    @SerializedName("Guionistas")
    private String writer;
    @SerializedName("Actores")
    private String actors;
    @SerializedName("Trama")
    private String plot;
    @SerializedName("Idioma")
    private String language;
    @SerializedName("Pais")
    private String country;
    @SerializedName("Premios")
    private String awards;
    @SerializedName("Publicacion")
    private String poster;
    @SerializedName("Ratings")
    private ColaService <Ratings> cola = new ColaService<>(3);
    @SerializedName("Metascore")
    private String metascore;
    @SerializedName("IMDB-Rating")
    private String imdbRating;
    @SerializedName("IMDB-Votes")
    private String imdbVotes;
    @SerializedName("IMDB-ID")
    private String imdbID;
    @SerializedName("Tipo")
    private String tipo;
    @SerializedName("DVD")
    private String DVD;
    @SerializedName("BoxOffice")
    private String boxOffice;
    @SerializedName("Produccion")
    private String production;
    @SerializedName("WebSite")
    private String website;
    @SerializedName("Response")
    private String response;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public ColaService<Ratings> getCola() {
        return cola;
    }

    public void setCola(ColaService<Ratings> cola) {
        this.cola = cola;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDVD() {
        return DVD;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
    
    public DatosPelicula() {
    }

    public DatosPelicula(String title, short year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, ColaService <Ratings> cola, String metascore, String imdbRating, String imdbVotes, String imdbID, String tipo, String DVD, String boxOffice, String production, String website, String response) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.cola=cola;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.tipo = tipo;
        this.DVD = DVD;
        this.boxOffice = boxOffice;
        this.production = production;
        this.website = website;
        this.response = response;
    }

}
