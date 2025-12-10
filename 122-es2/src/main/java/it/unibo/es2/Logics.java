package it.unibo.es2;

public interface Logics {
     /**
     * The number of slots.
     *
     * @return the number of slots
     */
    int size();

    /**
     * Increment the value of the specified slot.
     *
     * @param elem the slot to increment
     * @return the new value a button should show after being pressed
     */
    String hit(Pair<Integer,Integer> pair);
    /**
     * True if it is time to quit (i.e., one of the line or column is full).
     *
     * @return whether it is time to quit
     */
    boolean toQuit(Pair<Integer,Integer> pair);
}
