package solution.bmp.a2048;
/**
 * Created by gansu on 2/18/2017.
 */

import java.util.Random;

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

    public void moveLeft(){
        for(int col = 1; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if(board[row][col].getValue() != 0)
                {
                    if(board[row][col-1].getValue() == board[row][col].getValue()) {
                        board[row][col - 1].update(board[row][col]);
                        board[row][col].setZero();
                    }
                }
            }
        }
    }

    public void moveDown(){
        for(int row = size-2; row <= 0; row--){
            for(int col = 0; col < size; col++){
                if(board[row][col].getValue() != 0)
                {
                    if(board[row][col].getValue() == board[row][col].getValue()) {
                        board[row+1][col].update(board[row][col]);
                        board[row][col].setZero();
                    }
                }
            }
        }
    }


    public void moveRight(){
        for( int i = 0; i < size; i++){
            for(int j = size - 2; j >= 0; j--){
                if(board[i][j].getValue() != 0)
                    moveHelperAcross(i, j, 1);
            }
        }
    }

    public void moveLeft(){
        for( int i = 0; i < size; i++){
            for(int j = 1; j < size; j++){
                if(board[i][j].getValue() != 0)
                    moveHelperAcross(i, j, -1);
            }
        }
    }

    public void moveUp(){
        for( int i = 0; i < size; i++){
            for(int j = 1; j < size; j++){
                if(board[j][i].getValue() != 0)
                    moveHelperVertical(j, i, -1);
            }
        }
    }

    public void moveDown(){
        for( int i = 0; i < size; i++){
            for(int j = size - 2; j >= 0; j--){
                if(board[j][i].getValue() != 0)
                    moveHelperVertical(j, i, 1);
            }
        }
    }


    private void moveHelperAcross(int currentRow, int currentCol, int movecol)
    {
        while(((movecol == -1 && currentCol > 0) || (movecol ==1 && currentCol < size - 1)) && board[currentRow][currentCol + movecol].getValue() == 0 ){
            board[currentRow][currentCol + movecol].value = board[currentRow][currentCol].getValue();
            board[currentRow][currentCol].setZero();
            currentCol += movecol;
        }

        if(currentCol < size - 1 && currentCol > 0)
            if(board[currentRow][currentCol + movecol].getValue() == board[currentRow][currentCol].getValue()){
                mergeCells(board[currentRow][currentCol], board[currentRow][currentCol + movecol]);
            }

    }

    private void moveHelperVertical(int currentRow, int currentCol, int moverow)
    {
        while(((moverow == -1 && currentRow > 0) || (moverow ==1 && currentRow < size - 1)) && board[currentRow + moverow][currentCol].getValue() == 0 ){
            board[currentRow + moverow][currentCol].value = board[currentRow][currentCol].getValue();
            board[currentRow][currentCol].setZero();
            currentRow += moverow;
        }

        if(currentRow < size - 1 && currentRow > 0)
            if(board[currentRow + moverow][currentCol].getValue() == board[currentRow][currentCol].getValue()){
                mergeCells(board[currentRow][currentCol], board[currentRow + moverow][currentCol]);
            }

    }
    private void mergeCells(Cell fromCell, Cell toCell)
    {
        toCell.update(fromCell);
        fromCell.setZero();
        this.score += (toCell.getValue());
    }
    public Cell[][] getBoard(){
        return this.board;
    }

}
