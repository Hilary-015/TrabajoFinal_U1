package Vista.Tabla;

import Controlador.TDA_Cola.ColaService;
import Modelo.Historial;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hilary Calva
 */
public class TablaHistorial extends AbstractTableModel {

    ColaService<Historial> listaHistorial = new ColaService<>(10);

    public ColaService<Historial> getLista() {
        return listaHistorial;
    }

    public void setLista(ColaService<Historial> listaHistorial) {
        this.listaHistorial = listaHistorial;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return listaHistorial.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Comando";
            case 1:
                return "Fecha";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1)  {
        Historial comando = listaHistorial.obtenerDato(arg0);
        switch (arg1) {
            case 0:
                return comando.getComando();
            case 1:
                return comando.getFecha();
            default:
                return null;
        }
    }

}
