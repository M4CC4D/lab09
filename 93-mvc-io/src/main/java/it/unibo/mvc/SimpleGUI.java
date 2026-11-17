package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Objects;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    static final boolean TRUE = true;
    static final int WIDTH = 320;
    static final int HEIGHT = 200;
    private final JFrame frame;
    private final JPanel jp;
    private final Controller c;

    /**
     * costruttore della gui.
     * 
     * @param controller controller con cui dover interagire.
     * 
     */
    public SimpleGUI(final Controller controller) {
        Objects.requireNonNull(controller);
        this.c = controller;
        jp = new JPanel(new BorderLayout());
        frame = new JFrame("Aura");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(jp);
        frame.setSize(WIDTH, HEIGHT);

        final JTextField field = new JTextField("");
        final JTextArea area = new JTextArea();

        jp.add(field, BorderLayout.NORTH);
        jp.add(area, BorderLayout.CENTER);
        final JPanel south = new JPanel(new FlowLayout());
        jp.add(south, BorderLayout.SOUTH);

        final JButton print = new JButton("Print");
        print.addActionListener(e -> {
            c.nextString(field.getText());
            try {
                c.print();
                area.setText(c.getString());
            } catch (final IllegalStateException error) {
                area.setText(error.getMessage());
            }
        });

        final JButton showHistory = new JButton("Show history");
        showHistory.addActionListener(e -> {
            area.setText(null);
            final List<String> history = c.getHistory();
            for (final String s : history) {
                area.setText(area.getText() + "\n" + s);
            }
        });

        south.add(print);
        south.add(showHistory);
    }

    /**
     * metodo per visualizzare la gui.
     * 
     */
    private void start() {
        frame.setVisible(TRUE);
    }

    static void main() {
        final Controller controller = new SimpleController();
        final SimpleGUI gui = new SimpleGUI(controller);

        gui.start();
    }

}
