package com.company;

public class Map {
    private Nuts[][] nuts;
    private int player1Nuts;
    private int player2Nuts;

    /**
     * Creat an array of Nuts to build the map of game.
     */
    /**
     * Constructor - initialise the variables and locating the first nuts of the game.
     */
    public Map() {
        nuts = new Nuts[8][8];
        player1Nuts = 0;
        player2Nuts = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nuts[i][j] = new Nuts(-1);
            }
        }
        nuts[3][3].color = 1;
        nuts[3][4].color = 0;
        nuts[4][3].color = 0;
        nuts[4][4].color = 1;
    }

    /**
     * the method check and locate the nuts.
     * @param locLetter the vertical coordinate.
     * @param locDigit the horizontal coordinate.
     * @param color the color of the nuts.
     * @param check the boolean to check if the selected element of array is empty or not.
     * @return the boolean if the nut can take any move or not
     */
    public Boolean locateNut(int locLetter, int locDigit, int color, Boolean check) {
        Boolean acceptableMove = false;
        //int locLetterr = locLetter.charAt(0) - 65;
        int opColor;
        if (color == 1) {
            opColor = 0;
        } else
            opColor = 1;
        int x = locLetter;
        int y = locDigit;
        if(nuts[x][y].getColor() != -1)
            return false;
        do {
            x++;
            y++;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)){
                x--;
                y--;
                break;
            }

        }
        while (nuts[x][y].getColor() == opColor);


        if (nuts[x][y].getColor() == color) {
            if (check) {
                editMap(locLetter, locDigit, color, 1, 1);
            }
            acceptableMove = true;
        }

        x = locLetter;
        y = locDigit;
        do {
            x++;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)) {
                x--;
                break;
            }
        }
        while (nuts[x][y].getColor() == opColor);

        if (nuts[x][y].getColor() == color) {
            if (check) {
                editMap(locLetter, locDigit, color, 0, 1);
            }
            acceptableMove = true;
        }
        x = locLetter;
        y = locDigit;
        do {
            y++;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)) {
                y--;
                break;
            }
        }
        while (nuts[x][y].getColor() == opColor);

        if (nuts[x][y].getColor() == color) {
            if (check) {
                editMap(locLetter, locDigit, color, 1, 0);
            }
            acceptableMove = true;
        }
        x = locLetter;
        y = locDigit;
        do {
            x--;
            y++;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)) {
                x++;
                y--;
                break;
            }
        }
        while (nuts[x][y].getColor() == opColor);

        if (nuts[x][y].getColor() == color) {
            if (check) {
                editMap(locLetter, locDigit, color, 1, -1);
            }
            acceptableMove = true;
        }
        x = locLetter;
        y = locDigit;
        do {
            x++;
            y--;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)) {
                x--;
                y++;
                break;
            }
        }
        while (nuts[x][y].getColor() == opColor);

        if (nuts[x][y].getColor() == color) {
            if (check) {
                editMap(locLetter, locDigit, color, -1, 1);
            }
            acceptableMove = true;
        }
        x = locLetter;
        y = locDigit;
        do {
            x--;
            y--;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)) {
                x++;
                y++;
                break;
            }
        }
        while (nuts[x][y].getColor() == opColor);

        if (nuts[x][y].getColor() == color) {
            if (check) {
                editMap(locLetter, locDigit, color, -1, -1);
            }
            acceptableMove = true;
        }
        x = locLetter;
        y = locDigit;
        do {
            x--;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)) {
                x++;
                break;
            }
        }
        while (nuts[x][y].getColor() == opColor);

        if (nuts[x][y].getColor() == color) {
            if (check) {
                editMap(locLetter, locDigit, color, 0, -1);
            }
            acceptableMove = true;
        }
        x = locLetter;
        y = locDigit;
        do {
            y--;
            if (!(x >= 0 && x < 8 && y >= 0 && y < 8)) {
                y++;
                break;
            }
        }
        while (nuts[x][y].getColor() == opColor);

        if (nuts[x][y].getColor() == color) {
            if(check) {
                editMap(locLetter, locDigit, color, -1, 0);
            }
            acceptableMove = true;
        }
        x = locLetter;
        y = locDigit;
        return acceptableMove;
    }

    /**
     * the method to change the color of the array that located between the nuts.
     * @param locLetter the vertical coordinate.
     * @param locDigit the horizontal coordinate.
     * @param color the color to make change on the nuts.
     * @param y the vertical coordinate to move and change color on map.
     * @param x the horizontal coordinate to move and change color on map.
     */
    public void editMap(int locLetter, int locDigit, int color, int y, int x) {
        int opColor;
        if (color == 1) {
            opColor = 0;
        } else
            opColor = 1;
        do{
            nuts[locLetter][locDigit].color = color;
            locLetter += x;
            locDigit += y;
            if (!(locLetter >= 0 && locLetter < 8 && locDigit >= 0 && locDigit < 8)) {
                break;
            }
        }

        while (nuts[locLetter][locDigit].getColor() == opColor);
    }

    /**
     * count each player nuts.
     */
    public void countScores() {
        player1Nuts = 0;
        player2Nuts = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (nuts[i][j].getColor() == 0) {
                    player1Nuts++;
                }
                if (nuts[i][j].getColor() == 1) {
                    player2Nuts++;
                }

            }
        }
    }

    /**
     * the method to print the map and nuts of each player.
     */
    public void printMap() {
        countScores();
        System.out.println("   A     B    C     D    E     F    G    H ");
        for (int i = 0; i < 8; i++) {
            System.out.printf("\n");
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < 8; j++) {
                System.out.printf("%s ", nuts[i][j].toString());
            }
            System.out.printf("\n");
        }
        System.out.println("first player nuts : " + player1Nuts);
        System.out.println("second player nuts : " + player2Nuts);
    }
}
