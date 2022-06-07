
package Modelo;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Hilary Calva
 */
public class Ratings {
    
    @SerializedName("Source")
    private String source;
    @SerializedName("Puntuacion")
    private String value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Ratings(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public Ratings() {
    }
 
}
