package Vista.Tablas;

import Controlador.TDA_Cola.ColaService;
import Modelo.Ratings;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hilary Calva
 */
public class TablaRatings extends AbstractTableModel {

    ColaService<Ratings> listaRatings = new ColaService<>(3);

    public ColaService<Ratings> getListaRatings() {
        return listaRatings;
    }

    public void setListaRatings(ColaService<Ratings> listaRatings) {
        this.listaRatings = listaRatings;
    }


    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return listaRatings.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Source";
            case 1:
                return "Calificación";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1)  {
        Ratings rating = listaRatings.obtenerDato(arg0);
        switch (arg1) {
            case 0:
                return rating.getSource();
            case 1:
                return rating.getValue();
            default:
                return null;
        }
    }

}
