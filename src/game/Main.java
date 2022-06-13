package game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Board b = new Board(15);
        b.show();
        for(int i = 0; i < 60; i++){
            Thread.sleep(1000);
            //Runtime.getRuntime().exec("cls");
            System.out.print("\n");
            b.changeStateOfAllCells();
            b.show();
        }
    }
}