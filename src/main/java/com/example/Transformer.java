package com.example;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;


//you will need to implement two functions in this file.
public class Transformer extends Piece {
    
    
    public Transformer(boolean isWhite, String img_file, String other) {
        super(isWhite, img_file, other);
    }
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
         ArrayList<Square> controlledSquares = new ArrayList<>();
        if(start.getRow()<7){
            
            // Square control = board[start.getRow()+1][start.getCol()+1];
            // controlledSquares.add(control);
            controlledSquares.add(board[start.getRow()+1][start.getCol()+1]);
            controlledSquares.add(board[start.getRow()+1][start.getCol()-1]);
 
        }

        return controlledSquares;
    }
    @Override
    public String toString() {
        return "A "+ super.toString() + " transformer";
    }

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        
        ArrayList<Square> moves = new ArrayList<>();
        if(color == true){
            if(start.getRow()<7 && start.getCol()<7){
                
                Square up = b.getSquareArray()[start.getRow()+1][start.getCol()];
                moves.add(up);
                
            
            //check down left
            if(start.getCol()>0&& b.getSquareArray()[start.getRow()+1][start.getCol()-1].isOccupied() && b.getSquareArray()[start.getRow()+1][start.getCol()-1].getOccupyingPiece().getColor() != color){
                Square downLeft = b.getSquareArray()[start.getRow()+1][start.getCol()-1];
                moves.add(downLeft);
            }
            //check down right

            if(start.getCol()>0&& b.getSquareArray()[start.getRow()+1][start.getCol()+1].isOccupied() && b.getSquareArray()[start.getRow()+1][start.getCol()+1].getOccupyingPiece().getColor() != color){
                Square downRight = b.getSquareArray()[start.getRow()+1][start.getCol()+1];
                moves.add(downRight);
            }


            }
        }
    	return moves;

    }
    
}