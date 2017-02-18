package solution.bmp.a2048;

import java.util.Random;

/**
 * Created by gansu on 2/18/2017.
 */

public class Board {


    Cell[][] board;
    int score;
    int size;


    public Board(int size){
        this.size = size;
        this.board = new Cell[size][size];
        for( int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = new Cell();
            }
        }
        Random rand = new Random();
        int firstI = rand.nextInt(4);
        int firstJ = rand.nextInt(4);

        board[firstI][firstJ].random();
        int secondI = rand.nextInt(4);
        int secondJ = rand.nextInt(4);
        while(firstI == secondI && firstJ == secondJ)
        {
            secondI = rand.nextInt(4);
            secondJ = rand.nextInt(4);
        }
        board[secondI][secondJ].random();

        this.score = 0;
    }

    public int getScore(){
        return this.score;
    }

    public void updateScore(){

    }

    public void moveRight(){
        int moved = 0;
        for( int j = 0; j < size; j++){
            for(int i = 0; i < size; i++){
                if(!swapCells(board[i][j], board[i][j+1]))
                {
                    moved++;
                }
            }
        }

        if(moved == 0)
            return;
        moveRight();
    }

    private boolean swapCells(Cell movingCell, Cell emptyCell)
    {
        if(emptyCell.getValue() != 0)
            return false;
        Cell temp = movingCell;
        movingCell = emptyCell;
        emptyCell = temp;
        return true;
    }
    public Cell[][] getBoard(){
        return this.board;
    }

}

