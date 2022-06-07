package Vista.Tablas;

import Controlador.TDA_Cola.ColaService;
import Modelo.Ticket;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hilary Calva
 */
public class TablaTickets extends AbstractTableModel {

    ColaService<Ticket> listaTickets = new ColaService<>(20);

    public ColaService<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void setListaTickets(ColaService<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return listaTickets.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Trámite";
            case 2:
                return "Oficina";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1)  {
        Ticket ticket = listaTickets.obtenerDato(arg0);
        switch (arg1) {
            case 0:
                return ticket.getNro()+1;
            case 1:
                return ticket.getTramite();
            case 2:
                return ticket.getNroOficina();
            default:
                return null;
        }
    }

}
