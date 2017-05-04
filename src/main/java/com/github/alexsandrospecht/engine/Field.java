package com.github.alexsandrospecht.engine;

/**
 * Created by alexsandrospecht on 17/03/17.
 */
public class Field {

    private String name;

    private int start;

    private int size;

    private boolean stringfy;

    public Field(String name, int start, int size, boolean stringfy) {
        this.name = name;
        this.start = start;
        this.size = size;
        this.stringfy = stringfy;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }

    public boolean isStringfy() { return stringfy; }
}
