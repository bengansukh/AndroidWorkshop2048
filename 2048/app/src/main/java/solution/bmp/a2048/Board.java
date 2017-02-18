import java.util.Random;

/**
 * Created by gansu on 2/18/2017.
 */

public class Board {

    public static void main(String [] args)
    {
        Board a = new Board(4);
        Cell[][] board = a.getBoard();
        board[0][1].value = 2;
        board[0][2].value = 2;
        for(int i = 0; i < 4; i++){
            for (int j =0; j < 4; j++)
            {
                System.out.print(board[i][j].getValue() + " ");
            }
            System.out.println();
        }

        a.moveRight();
        System.out.println("After move");
        for(int i = 0; i < 4; i++){
            for (int j =0; j < 4; j++)
            {
                System.out.print(board[i][j].getValue() + " ");
            }
            System.out.println();
        }

    }

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
        for( int i = 0; i < size; i++){
            for(int j = size - 2; j >= 0; j--){
                skipEmptyCellsRight(i, j);
            }
        }
    }

    private void skipEmptyCellsRight(int currentRow, int currentCol)
    {
        if(currentCol > size - 1)
            return;
        if(board[currentRow][currentCol + 1] != null && board[currentRow][currentCol + 1].getValue() == 0){
            board[currentRow][currentCol + 1].value = board[currentRow][currentCol].value;
            board[currentRow][currentCol].setZero();
            skipEmptyCellsRight(currentRow, currentCol + 1);
        }
    }

    private void mergeCells(Cell fromCell, Cell toCell)
    {
        if(fromCell.getValue() == toCell.getValue())
            toCell.update(fromCell);
        fromCell.setZero();
    }
    public Cell[][] getBoard(){
        return this.board;
    }

}

/**
 * Created by mrybak834 on 2/18/17.
 */

class Cell {
    int value;

    Cell(){
        value = 0;
    }

    int random(){
        Random r = new Random();
        int randNumber = r.nextInt(1);

        if(randNumber == 0){
            value = 2;
            return 2;
        }
        else{
            value = 4;
            return 4;
        }
    }

    void update (Cell c){
        this.value = this.value + c.getValue();
    }

    int getValue(){
        return value;
    }

    void setZero (){
        this.value = 0;
    }
}


