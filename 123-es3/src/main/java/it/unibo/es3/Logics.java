package it.unibo.es3;

import java.util.List;

/**
 * Interface defining the logic.
 */
public interface Logics {

    /**
     * The number of slots.
     *
     * @return the number of slots
     */
    int size();

    /**
     * Generated 3 *.
     *
     * @return the number of slots
     */
    Pair<Integer, Integer> random();

    /**
     * Fill the button.
     *
     * @return the coordinates of the button. 
     */
    List<Pair<Integer, Integer>> fill();

    /**
     * Change the value of a button.
     * 
     * @param pair coordinates of the button.
     * @return the new value a button should show after being pressed.
     */
    String star(Pair<Integer, Integer> pair);

    /**
     * True if it is time to quit (i.e., one of the row or column is full).
     *
     * @return whether it is time to quit.
     */
    boolean toQuit();
}
