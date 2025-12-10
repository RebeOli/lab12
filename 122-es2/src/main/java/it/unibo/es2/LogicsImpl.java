package it.unibo.es2;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final String STAR = "*";
    private final int size;
    private final Map<Pair<Integer, Integer>, String> map = new LinkedHashMap<>();

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        Objects.requireNonNull(size);
        if (size == 0) {
            throw new IllegalArgumentException("Size not valid");
        }
        this.size = size;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.map.put(new Pair<>(i, j), " ");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String hit(final Pair<Integer, Integer> pair) {
        if (" ".equals(map.get(pair))) {
            map.put(pair, STAR);
            return STAR;
        } else {
            map.put(pair, " ");
            return " ";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit(final Pair<Integer, Integer> pair) {
        if (STAR.equals(map.get(pair))) {
            return checkCol(pair) || checkRow(pair);
        }
        return false;
    }

    /**
     * Check if the column is full of *.
     * 
     * @param pair coordinates of the button.
     * @return true if it is full.
     */
    private boolean checkCol(final Pair<Integer, Integer> pair) {
        for (int i = 0; i < this.size; i++) {
            if (" ".equals(map.get(new Pair<>(pair.x(), i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the row is full of *.
     * 
     * @param pair coordinates of the button.
     * @return true if it is full.
     */
    private boolean checkRow(final Pair<Integer, Integer> pair) {
        for (int i = 0; i < this.size; i++) {
            if (" ".equals(map.get(new Pair<>(i, pair.y())))) {
                return false;
            }
        }
        return true;
    }
}
