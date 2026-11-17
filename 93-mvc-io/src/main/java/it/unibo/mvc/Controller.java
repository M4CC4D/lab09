package it.unibo.mvc;

import java.util.List;
import java.util.LinkedList;
import java.util.Objects;
import java.lang.IllegalStateException;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    void print();

    public static class ControllerImpl implements Controller {

        private List<String> messages = new LinkedList<>();

        public void nextString(String message){
            Objects.requireNonNull(message);
            messages.add(message);
        }

        public String getString() {
            return new String(messages.getLast());
        }

        public List<String> getHistory() {
            return List.copyOf(messages);
        }

        public void print() {
            if(messages.isEmpty()) {
                throw new IllegalStateException();
            }
            IO.println(messages.getLast());
        }

    }

}
