package com.company;

public class Player {
    // a class that holds player's info.
    public String name;
    private int color;
    private Map map;
    private Boolean check;

    /**
     *
     * @param name the name of player.
     * @param obj the map of the game.
     * @param color the color of the player's nut.
     */
    /**
     * Constructor - initialise the player.
     */
    public Player(String name,Map obj,int color) {
        this.name = name;
        map = obj;
        this.color = color;
    }


    /**Return the check(the boolean of method). If the
     * command was not understood, the result is null.
     * @return the check.
     */
    public Boolean checkMap(){
        for(int i = 0;i < 8;i++){
            for (int j = 0;j < 8;j++){
                // a method that check if the array is empty or not.
                check = map.locateNut(i,j,color,false);
                if(check)
                    return true;
            }
        }
        System.out.println("pass");
        return false;
    }
}
