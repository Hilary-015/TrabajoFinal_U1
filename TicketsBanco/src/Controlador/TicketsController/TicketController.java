
package Controlador.TicketsController;

import Controlador.TDA_Cola.ColaService;
import Modelo.Ticket;

/**
 *
 * @author Hilary Calva
 */
public class TicketController {
    
    TicketDatos ticket = new TicketDatos();
    ColaService<Ticket> listaTickets = new ColaService<>(20);

    public TicketDatos getTicket() {
        return ticket;
    }

    public void setTicket(TicketDatos ticket) {
        this.ticket = ticket;
    }

    public ColaService<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void setListaTickets(ColaService<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

    public TicketController() {
    }

}
