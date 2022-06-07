package Controlador.RatingsController;

import Controlador.TDA_Cola.ColaService;
import Modelo.Ratings;

/**
 *
 * @author Hilary Calva
 */
public class RatingsController {
    
    RatingsD ratings = new RatingsD();
    ColaService<Ratings> colaRatings = new ColaService<>(3);

    public RatingsD getRatings() {
        return ratings;
    }

    public void setRatings(RatingsD ratings) {
        this.ratings = ratings;
    }

    public ColaService<Ratings> getColaRatings() {
        return colaRatings;
    }

    public void setColaRatings(ColaService<Ratings> colaRatings) {
        this.colaRatings = colaRatings;
    }

}
