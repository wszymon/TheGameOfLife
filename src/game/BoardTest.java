package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    @Test
    void isThereTwoNeighborsInCorner(){
        Board board = new Board(15);
        board.setBoardCell(1,1);
        board.setBoardCell(0,1);
        assertEquals(2, board.numOfLivingNeighbors(0,0));
    }
    @Test
    void isThereThreeNeighborsInTheMiddle(){
        Board board = new Board(15);
        board.setBoardCell(5,6);
        board.setBoardCell(5,7);
        board.setBoardCell(7,7);
        assertEquals(3, board.numOfLivingNeighbors(6,6));
    }
    @Test
    void isThereOneNeighborOnSide(){
        Board board = new Board(15);
        board.setBoardCell(7,0);
        //board.setBoardCell(7,1);
        assertEquals(1, board.numOfLivingNeighbors(8,0));
    }
    @Test
    void cellShouldDieTooLessNeighbors(){
        Board board = new Board(15);
        board.setBoardCell(0,0); // testing cell is alive
        board.setBoardCell(1,1);
        board.changeState(0,0);
        assertFalse(board.arr[0][0]);
    }
    @Test
    void cellShouldStayAliveEnoughNeighbors(){
        Board board = new Board(15);
        board.setBoardCell(1,1);
        board.setBoardCell(0,1);
        board.setBoardCell(0,0); //testing cell is alive
        board.changeState(0,0);
        assertTrue(board.arr[0][0]);
    }
    @Test
    void cellShouldDieTooManyNeighbors(){
        Board board = new Board(15);
        board.setBoardCell(1,1);
        board.setBoardCell(0,0);
        board.setBoardCell(0,1);
        board.setBoardCell(1,0); //testing cell is alive
        board.setBoardCell(2,0);
        board.changeStateOfAllCells();
        assertFalse(board.arr[1][0]);
    }
    @Test
    void cellShouldComeAliveEnoughNeighbors(){
        Board board = new Board(15);
        //testing cell is dead
        board.setBoardCell(1,1);
        board.setBoardCell(0,1);
        board.setBoardCell(1,0);
        board.changeStateOfAllCells();
        assertTrue(board.arr[0][0]);
    }
}