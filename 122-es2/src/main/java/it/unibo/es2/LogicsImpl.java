package it.unibo.es2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LogicsImpl implements Logics {
    private final int size;
    private Map<Pair<Integer,Integer>, String> map = new LinkedHashMap<>();

    public LogicsImpl(final int size) {
        Objects.requireNonNull(size);
        if(size == 0) throw new IllegalArgumentException("Size not valid");
        this.size = size;
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++){
                this.map.put(new Pair<>(i, j), " ");
            }
        }
    }

    public int size() {
        return this.size;
    }

    public String hit(final Pair<Integer,Integer> pair) {
        if(map.get(pair) == " "){
            map.put(pair, "*");
            return "*";
        } else {
            map.put(pair, " ");
            return " ";
        }
    }

    public boolean toQuit(final Pair<Integer,Integer> pair) {
        if(map.get(pair).equals("*")){
            return (checkCol(pair) || checkRow(pair));
        }
        return false;
    }
    private boolean checkCol(final Pair<Integer,Integer> pair){
        for (int i = 0; i < this.size; i++){
            if(map.get(new Pair<>(pair.x(),i)).equals(" ")){
                return false;
            }
        }
        return true;
    }
    private boolean checkRow(final Pair<Integer,Integer> pair){
        for (int i = 0; i < this.size; i++){
            if(map.get(new Pair<>(i,pair.y())).equals(" ")){
                return false;
            }
        }
        return true;
    }
}
