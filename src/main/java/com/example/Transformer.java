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


    public ArrayList<Square> getLegalMoves(Board b, Square currentSquare) {
        ArrayList<Square> moves = new ArrayList<Square>();
        for (Square s : getControlledSquares(b.getSquareArray(), currentSquare)) {
            if (s.isOccupied() && s.getOccupyingPiece().getColor() != getColor()) {
                moves.add(s);
            }
        }
        if (getColor()) {
            if (currentSquare.getRow() - 1 >= 0 && !b.getSquareArray()[currentSquare.getRow() - 1][currentSquare.getCol()].isOccupied()) {
                moves.add(b.getSquareArray()[currentSquare.getRow() - 1][currentSquare.getCol()]);
            }
            if (currentSquare.getRow() == 6 && !b.getSquareArray()[currentSquare.getRow() - 1][currentSquare.getCol()].isOccupied() && !b.getSquareArray()[currentSquare.getRow() - 2][currentSquare.getCol()].isOccupied()) {
                moves.add(b.getSquareArray()[currentSquare.getRow() - 2][currentSquare.getCol()]);
            }
        } else {
            if (currentSquare.getRow() + 1 < 8 && !b.getSquareArray()[currentSquare.getRow() + 1][currentSquare.getCol()].isOccupied()) {
                moves.add(b.getSquareArray()[currentSquare.getRow() + 1][currentSquare.getCol()]);
            }
            if (currentSquare.getRow() == 1 && !b.getSquareArray()[currentSquare.getRow() + 1][currentSquare.getCol()].isOccupied() && !b.getSquareArray()[currentSquare.getRow() + 2][currentSquare.getCol()].isOccupied()) {
                moves.add(b.getSquareArray()[currentSquare.getRow() + 2][currentSquare.getCol()]);
            }
        }
        return moves;
    }

    public ArrayList<Square> getControlledSquares(Square[][] board, Square currentSquare) {
        ArrayList<Square> controlled = new ArrayList<Square>();
        int drow = getColor() ? -1 : 1;
        if (currentSquare.getRow() + drow >= 0 && currentSquare.getRow() + drow < 8) {
            if (currentSquare.getCol() + 1 < 8) {
                controlled.add(board[currentSquare.getRow() + drow][currentSquare.getCol() + 1]);
            }
            if (currentSquare.getCol() - 1 >= 0) {
                controlled.add(board[currentSquare.getRow() + drow][currentSquare.getCol() - 1]);
            }
        }
        return controlled;
    }
    
}