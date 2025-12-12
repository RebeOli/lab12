package it.unibo.es3;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final String STAR = "*";
    private final int size;
    private final Map<Pair<Integer, Integer>, String> map = new LinkedHashMap<>();
    private final List<Pair<Integer, Integer>> list = new ArrayList<>();

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
    public Pair<Integer, Integer> random() {
        final RandomGenerator random = new Random();
        Pair<Integer, Integer> pair;
        do {
            final int x = random.nextInt(size);
            final int y = random.nextInt(size);
            pair = new Pair<>(x, y);
        } while (STAR.equals(map.get(pair)));
        return pair;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String star(final Pair<Integer, Integer> pair) {
        map.put(pair, STAR);
        return STAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pair<Integer, Integer>> fill() {
        for (final Map.Entry<Pair<Integer, Integer>, String> entry : this.map.entrySet()) {
            if (STAR.equals(entry.getValue())) {
                final Pair<Integer, Integer> pair = entry.getKey();
                for (int i = pair.x() - 1; i <= pair.x() + 1; i++) {
                    for (int j = pair.y() - 1; j <= pair.y() + 1; j++) {
                        final Pair<Integer, Integer> newPair = new Pair<>(i, j);
                        if (map.containsKey(newPair) && !STAR.equals(map.get(newPair))) {
                            list.add(newPair); 
                        }
                    }
                }
            }
        }
        for (final Pair<Integer, Integer> pair : list) {
            map.put(pair, STAR);
        }
        return List.copyOf(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (final String values : this.map.values()) {
            if (!STAR.equals(values)) {
                return false;
            }
        }
        return true;
    }
}
