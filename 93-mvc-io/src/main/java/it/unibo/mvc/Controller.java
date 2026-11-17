package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    /**
     * print in stdout.
     */
    void print();

    /**
     * setta la nuova stringa.
     * 
     * @param message messaggio
     */
    void nextString(String message);

    /**
     * prende la nuova stringa.
     * 
     * @return Una stringa
     */
    String getString();

    /**
     * prende tutte le stringe messe.
     * 
     * @return una lista di stringe
     * 
     */
    List<String> getHistory();

}
