package game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Board board = new Board(15);
        board.setBoardCell(1,1); //testing cell is alive
        board.setBoardCell(0,0);
        board.setBoardCell(0,1);
        board.setBoardCell(1,0);
        board.setBoardCell(2,0);

        board.show();
        System.out.print("\n");
        board.changeStateOfAllCells();
        board.show();

        /*for(int i = 0; i < 60; i++){
            Thread.sleep(1000);
            //Runtime.getRuntime().exec("cls");
            System.out.print("\n");
            b.changeStateOfAllCells();
            b.show();
        }*/

    }
}