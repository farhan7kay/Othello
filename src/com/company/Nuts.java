package com.company;

public class Nuts {
    public int color;

    /**
     * class of the nuts.
     * @param color is the color of the nut.
     */
    /**
     *
     * Constructor - initialise the color.
     */
    public Nuts(int color){
        this.color = color;
    }
    //return the color of the nut.
    public int getColor() {
        return color;
    }


    /**
     * toString method to print the nuts on the map.
     * @return the nuts.
     */
    @Override
    public String toString() {
        if(color == 0)
            return String.valueOf('\u26AB') + "   ";
        if(color == 1)
            return String.valueOf('\u26AA') + "   ";
        return String.valueOf('\u22c5') + "    ";
    }
}
