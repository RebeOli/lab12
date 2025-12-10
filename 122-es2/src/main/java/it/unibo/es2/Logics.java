package it.unibo.es2;

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
     * Change the value of a button.
     *
     * @param pair coordinates of the button.
     * @return the new value a button should show after being pressed.
     */
    String hit(Pair<Integer, Integer> pair);

    /**
     * True if it is time to quit (i.e., one of the row or column is full).
     * 
     * @param pair coordinates of the button.
     * @return whether it is time to quit.
     */
    boolean toQuit(Pair<Integer, Integer> pair);
}
