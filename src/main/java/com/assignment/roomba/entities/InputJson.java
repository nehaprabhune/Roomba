package com.assignment.roomba.entities;

import java.util.Arrays;
import java.util.Objects;

public class InputJson {
    
    private int[] roomSize;
    private int[] coords;
    private int[][] patches;
    private String instructions;

    public int[] getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int[] roomSize) {
        this.roomSize = roomSize;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public int[][] getPatches() {
        return patches;
    }

    public void setPatches(int[][] patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Arrays.hashCode(this.roomSize);
        hash = 29 * hash + Arrays.hashCode(this.coords);
        hash = 29 * hash + Arrays.deepHashCode(this.patches);
        hash = 29 * hash + Objects.hashCode(this.instructions);
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
        final InputJson other = (InputJson) obj;
        if (!Objects.equals(this.instructions, other.instructions)) {
            return false;
        }
        if (!Arrays.equals(this.roomSize, other.roomSize)) {
            return false;
        }
        if (!Arrays.equals(this.coords, other.coords)) {
            return false;
        }
        if (!Arrays.deepEquals(this.patches, other.patches)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "InputJson{" + "roomsize=" + roomSize[0]+ " " + roomSize[1] + ", coords=" + coords + ", patches=" + patches + ", instructions=" + instructions + '}';
    }
    
}
