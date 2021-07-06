package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /**Creat a Map object.
         */
        Map map = new Map();
        /**Creat a Player object. First and second must be supplied, but
         * all can be null.
         * @param name is the name of player.
         * @param color is the color of the player's nut.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the name of first palyer : ");
        String firstPlayer = scan.next();
        System.out.println("enter the name of the second player : ");
        String secondPlayer = scan.next();
        Player player1 = new Player(firstPlayer, map, 0);
        Player player2 = new Player(secondPlayer, map, 1);
        Boolean gameOver = true;
        int counter = 0;
        String selectedColumn;
        int selectedColumnn;
        int selectedRow;
        while (gameOver) {
            map.printMap();
            if (counter % 2 == 0) {
                do {
                    System.out.println(player1.name + " your turn ! select a row and a column to locate your nut :");
                    selectedColumn = scan.next();
                    selectedColumnn = selectedColumn.charAt(0) - 65;
                    selectedRow = scan.nextInt() - 1;
                }
                while (!map.locateNut(selectedRow, selectedColumnn, 0, true));


                counter++;
                map.printMap();
            }
            if (counter % 2 == 1) {
                do {
                    System.out.println(player2.name + " your turn ! select a row and a column to locate your nut :");
                    selectedColumn = scan.next();
                    selectedColumnn = selectedColumn.charAt(0) - 65;
                    selectedRow = scan.nextInt() - 1;
                }
                while (!map.locateNut(selectedRow, selectedColumnn, 1, true));

                counter++;
            }
            gameOver = (player1.checkMap() || player2.checkMap());
        }
        map.printMap();
        System.out.println("game ended");

    }
}
