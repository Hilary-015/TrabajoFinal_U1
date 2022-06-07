package Controlador.PeliculasController;

import Controlador.TDA_Lista.ListaEnlazadaServices;
import Modelo.DatosPelicula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Hilary Calva
 */
public class PeliculaController {

    Peli miPeli = new Peli();
    ListaEnlazadaServices<DatosPelicula> listaPeliculas = new ListaEnlazadaServices<>();

    public Peli getMiPeli() {
        return miPeli;
    }

    public void setMiPeli(Peli miPeli) {
        this.miPeli = miPeli;
    }

    public ListaEnlazadaServices<DatosPelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ListaEnlazadaServices<DatosPelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public void generarGson(ListaEnlazadaServices<DatosPelicula> lista, String nombre) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(lista);
            FileWriter jsonGenerado = new FileWriter(nombre + ".json");
            jsonGenerado.write(jsonString);
            jsonGenerado.flush();
            JOptionPane.showMessageDialog(null, "Json generado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Json no generado");
        }

    }

}
