package solution.bmp.a2048;

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
        this.score = 0;
    }

    public int getScore(){
        return this.score;
    }

    public void updateScore(){

    }

    public void moveRight(){
        for( int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){

            }
        }
    }

    public Cell[][] getBoard(){
        return this.board;
    }

}

