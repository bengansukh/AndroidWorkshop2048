<<<<<<< HEAD
//package solution.bmp.a2048;
//
///**
// * Created by mrybak834 on 2/18/17.
// */
//
//public class Bot {
//    Board gameBoard;
//
//    Bot(Board gBoard){
//        gameBoard = gBoard;
//    }
//
//    void nextMove(){
//        int oldScore = gameBoard.getScore();
//
//        gameBoard.moveUp();
//        if(gameBoard.score == oldScore) {
//            gameBoard.moveRight();
//            if(gameBoard.Score == oldScore){
//                gameBoard.moveLeft();
//                if(gameBoard.Score == oldScore){
//                    gameBoard.moveDown();
//                }
//            }
//        }
//
//    }
//}
=======
package solution.bmp.a2048;

/**
 * Created by mrybak834 on 2/18/17.
 */

public class Bot {
    Board gameBoard;

    Bot(Board gBoard){
        gameBoard = gBoard;
    }

    void nextMove(){
        int oldScore = gameBoard.getScore();

        gameBoard.moveUp();
        if(gameBoard.score == oldScore) {
            gameBoard.moveRight();
            if(gameBoard.Score == oldScore){
                gameBoard.moveLeft();
                if(gameBoard.Score == oldScore){
                    gameBoard.moveDown();
                }
            }
        }

    }

    void nextSmartMove(){

    }
}
>>>>>>> c5c7151addb9333e909202fc997048f621378e22
