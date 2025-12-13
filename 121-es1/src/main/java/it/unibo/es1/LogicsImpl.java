package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    //private static final String ERROR_MESSAGE = "Unimplemented method";
    private final int size;
    private final List<Integer> list;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        Objects.requireNonNull(size);
        this.size = size;
        list = new ArrayList<>(this.size);
        for (int i = 0; i < size; i++) {
            list.add(0);
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
    public List<Integer> values() {
        return List.copyOf(this.list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return this.list.stream().map(e -> e.compareTo(size)).map(e -> e < 0).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        this.list.set(elem, this.list.get(elem) + 1);
        return this.list.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        String res = "<<";
        for (int i = 0; i < size; i++) {
            res = res + this.list.get(i) + "|";
        }
        res = res + ">>";
        return res;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        final int first = this.list.get(0);
        for (final Integer i : this.list) {
            if (i != first) {
                return false;
            }
        }
        return true;
    }
}
