package Vista.Tablas;

import Controlador.TDA_Lista.ListaEnlazadaServices;
import Modelo.DatosPelicula;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hilary Calva
 */
public class TablaPeliculas extends AbstractTableModel {

    ListaEnlazadaServices<DatosPelicula> listaPeliculas = new ListaEnlazadaServices<>();

    public ListaEnlazadaServices<DatosPelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ListaEnlazadaServices<DatosPelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public int getRowCount() {
        return listaPeliculas.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Titulo";
            case 1:
                return "Año";
            case 2:
                return "Calificación";  
            case 3:
                return "Estreno";
            case 4:
                return "Duración";
            case 5:
                return "Género";
            case 6:
                return "Director";
            case 7:
                return "Guionistas";
            case 8:
                return "Actores";
            case 9:
                return "Idioma";
            case 10:
                return "País";
            case 11:
                return "Premios";
            case 12:
                return "Publicación";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1)  {
        DatosPelicula peli = listaPeliculas.obtenerDato(arg0);
        switch (arg1) {
            case 0:
                return peli.getTitle();
            case 1:
                return peli.getYear();
            case 2:
                return peli.getRated();
            case 3:
                return peli.getReleased();
            case 4:
                return peli.getRuntime();
            case 5:
                return peli.getGenre();
            case 6:
                return peli.getDirector();
            case 7:
                return peli.getWriter();
            case 8:
                return peli.getActors();
            case 9:
                return peli.getLanguage();
            case 10:
                return peli.getCountry();
            case 11:
                return peli.getAwards();
            case 12:
                return peli.getPoster();
            default:
                return null;
        }
    }

}
