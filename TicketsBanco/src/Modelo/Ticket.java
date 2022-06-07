
package Modelo;

/**
 *
 * @author Hilary Calva
 */
public class Ticket {
    
    private String tramite;
    private int nro;
    private int nroOficina;

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getNroOficina() {
        return nroOficina;
    }

    public void setNroOficina(int nroOficina) {
        this.nroOficina = nroOficina;
    }

    public Ticket(String tramite, int nro, int nroOficina) {
        this.tramite = tramite;
        this.nro = nro;
        this.nroOficina = nroOficina;
    }

    public Ticket() {
    }
 
}
