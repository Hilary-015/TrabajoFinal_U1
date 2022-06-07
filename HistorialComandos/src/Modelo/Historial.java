package Modelo;

/**
 *
 * @author Hilary Calva
 */
public class Historial {
    
    private String comando;
    private String fecha;

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Historial() {
    }

    public Historial(String comando, String fecha) {
        this.comando = comando;
        this.fecha = fecha;
    }
    
}
