package Controlador.HistorialController;

import Controlador.TDA_Cola.ColaService;
import Modelo.Historial;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Hilary Calva
 */
public class HistorialController {

    DatosController comando = new DatosController();
    ColaService<Historial> listaHistorial = new ColaService<>(10);

    public Historial getComando() {
        return comando;
    }

    public void setComando(DatosController comando) {
        this.comando = comando;
    }

    public ColaService<Historial> getListaHistorial() {
        return listaHistorial;
    }

    public void setListaHistorial(ColaService<Historial> listaHistorial) {
        this.listaHistorial = listaHistorial;
    }

    public String fechaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/YYYY");
        comando.setFecha(fechaFormato.format(fechaActual));
        return comando.getFecha();
    }

    public HistorialController() {
    }

}
