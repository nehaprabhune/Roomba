package com.assignment.roomba.entities;

import java.util.Arrays;

public class OutputJson {
    private final int[] coords;
    private final int patches;

    public OutputJson(int[] coords, int patches){
        this.coords = coords;
        this.patches = patches;
    }
    public int[] getCoords() {
        return coords;
    }    

    public int getPatches() {
        return patches;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Arrays.hashCode(this.coords);
        hash = 53 * hash + this.patches;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OutputJson other = (OutputJson) obj;
        if (this.patches != other.patches) {
            return false;
        }
        if (!Arrays.equals(this.coords, other.coords)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "OutputJson{" + "coords=" + coords + ", patches=" + patches + '}';
    }
    
}
