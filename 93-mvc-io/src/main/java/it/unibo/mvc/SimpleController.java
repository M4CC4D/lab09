package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public class SimpleController implements Controller {
    private final List<String> messages = new LinkedList<>();

    /**
     * setta la nuova stringa.
     * 
     * @param message messaggio
     */
    @Override 
    public void nextString(final String message) {
        Objects.requireNonNull(message);
        messages.add(message);
    }

    /**
     * prende la nuova stringa.
     * 
     * @return Una stringa
     */
    @Override
    public String getString() {
        return messages.getLast();
    }

    /**
     * prende tutte le stringe messe.
     * 
     * @return una lista di stringe
     * 
     */
    @Override
    public List<String> getHistory() {
        return List.copyOf(messages);
    }

    /**
     * print in stdout.
     */
    @Override
    public void print() {
        if (messages.isEmpty()) {
            throw new IllegalStateException("il messaggio non puo essere vuoto.");
        }
        IO.println(messages.getLast());
    }
}
