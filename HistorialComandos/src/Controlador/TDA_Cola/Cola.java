package Controlador.TDA_Cola;

import Controlador.Exceptions.PosicionException;
import Controlador.Exceptions.TopeException;
import Controlador.TDA_Lista.ListaEnlazada;

/**
 *
 * @author Hilary Calva
 */
public class Cola<E> extends ListaEnlazada<E> {

    private Integer tope;

    public Cola(Integer pos) {
        this.tope = pos;
    }

    public Cola() {
        this.tope = 0;
    }

    public Boolean estaLleno() {
        if (tope == 0) {
            return false;
        } else if (tope == getSize().intValue()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Metodo que permite guardar el dato ingresado en la cola, en este se encuentra la modificacion para eliminar un dato e insertar otro cuando se llegue al tope
     * @param dato
     * @throws PosicionException
     * @throws TopeException 
     */

    public void queue(E dato) throws PosicionException, TopeException {
        if (!estaLleno()) {
            insertar(dato, getSize() - 1);
        } else {
            //Reemplazar dato cuando llegue al tope
            dequeue(0);
            insertar(dato, getSize() - 1);
        }
    }

    public E dequeue(Integer pos) throws PosicionException, TopeException {
        E auxDato = null;
        if (!estaVacia()) {
            if (pos >= 0 && pos < getSize()) {
                for (int i = 0; i <= pos; i++) {
                    auxDato = eliminarDato(0);
                }
                return auxDato;

            } else {
                throw new PosicionException("Error al realizar Dequeue: No existe la posicion dada");
            }
        } else {
            throw new TopeException("La cola esta vacia");
        }
    }

    public E obtenerDatoCola(Integer pos) throws PosicionException, TopeException {
        return obtenerDato(pos);
    }
}

