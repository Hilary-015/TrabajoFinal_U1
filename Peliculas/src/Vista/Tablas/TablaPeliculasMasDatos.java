package Vista.Tablas;

import Controlador.TDA_Lista.ListaEnlazadaServices;
import Modelo.DatosPelicula;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hilary Calva
 */
public class TablaPeliculasMasDatos extends AbstractTableModel {

    ListaEnlazadaServices<DatosPelicula> listaPeliculas = new ListaEnlazadaServices<>();

    public ListaEnlazadaServices<DatosPelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ListaEnlazadaServices<DatosPelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public int getRowCount() {
        return listaPeliculas.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Metascore";
            case 1:
                return "IMDB-Rating";
            case 2:
                return "IMDB-Votes";  
            case 3:
                return "IMDB-ID";
            case 4:
                return "Tipo";
            case 5:
                return "DVD";
            case 6:
                return "BoxOffice";
            case 7:
                return "Producción";
            case 8:
                return "Website";
            case 9:
                return "Response";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1)  {
        DatosPelicula peli = listaPeliculas.obtenerDato(arg0);
        switch (arg1) {
            case 0:
                return peli.getMetascore();
            case 1:
                return peli.getImdbRating();
            case 2:
                return peli.getImdbVotes();
            case 3:
                return peli.getImdbID();
            case 4:
                return peli.getTipo();
            case 5:
                return peli.getDVD();
            case 6:
                return peli.getBoxOffice();
            case 7:
                return peli.getProduction();
            case 8:
                return peli.getWebsite();
            case 9:
                return peli.getResponse();
            default:
                return null;
        }
    }

}
