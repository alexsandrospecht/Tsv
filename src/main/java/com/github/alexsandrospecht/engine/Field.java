package com.github.alexsandrospecht.engine;

/**
 * Created by alexsandrospecht on 17/03/17.
 */
public class Field {

    private String name;

    private int start;

    private int size;

    public Field(String name, int start, int size) {
        this.name = name;
        this.start = start;
        this.size = size;
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
}
