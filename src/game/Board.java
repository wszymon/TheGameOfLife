package game;

import java.util.Random;

public class Board {
    int size;
    boolean arr[][];

    Random rand = new Random();

    public Board(int size) {
        this.size = size;
        arr = new boolean[size][size];
        for(int i = 0; i < size; i++ ){
            for(int j = 0; j < size; j++){
                //arr[i][j] = rand.nextInt(100) < 20;
                arr[i][j] = false;
            }
        }

    }
    public void show(){
        for(int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                if(arr[i][j]) System.out.print("[*]");
                else System.out.print("[ ]");
            }
            System.out.print("\n");
        }
    }
    public int numOfLivingNeighbors(int x, int y){
        int num = 0;
        for(int i = x-1; i <= x + 1; i++){        //starts from one line above
            for(int j = y - 1; j <= y + 1; j++){    // and one column from left
                try {
                    if (arr[i][j]) num++;
                }catch (Exception ignored){}
            }
        }
        if(arr[x][y] && num > 0) num --;

        return num;
    }
    public void changeState(int x, int y){
        if (arr[x][y] && (numOfLivingNeighbors(x, y) < 2)) arr[x][y] = false;
        if (arr[x][y] && (numOfLivingNeighbors(x, y) == 2 || numOfLivingNeighbors(x, y) == 3)) arr[x][y] = true;
        if (arr[x][y] && (numOfLivingNeighbors(x, y) > 3)) arr[x][y] = false;
        if (!arr[x][y] && (numOfLivingNeighbors(x, y) == 3)) arr[x][y] = true;
    }
    public void changeStateOfAllCells(){
        for(int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                changeState(i, j);
            }
        }
    }
    public void setBoardCell(int x, int y){
        arr[x][y] = true;
    }

}
