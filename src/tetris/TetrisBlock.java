
package tetris;

import java.awt.Color;
import java.util.Random;


public class TetrisBlock {
    private int[][] shape;
    private Color color;
    private int x, y;
    private int[][][] shapes;
    private int currentRotation;
    
    private Color[] availableColors = {Color.green,Color.red, Color.blue, Color.pink};
    
    public TetrisBlock(int[][] shape){
        this.shape = shape;
       
        initShapes();
       
    }
    
    private void initShapes(){
        shapes = new int[4][][];
        for(int i=0; i <4; i++){
            int r= shape[0].length;
            int c = shape.length;
            shapes[i]= new int [r][c];
            for(int y=0; y<r; y++){
                for(int x = 0; x <c; x++){
                    shapes[i][y][x] = shape[c-x-1][y];
                }
            }
            shape = shapes[i];
        }
    }
    
    public void spawn(int gridWidth){
        
        Random r = new Random();
        //make block come down with random rotations
        currentRotation = r.nextInt(4);
        shape = shapes[currentRotation];
        y= 0 - getHeight();
        x= (gridWidth- getWidth())/2;
        x=r.nextInt(gridWidth-getWidth());
        
        color = availableColors[r.nextInt(availableColors.length)];
    }
    
    public int[][] getShape(){ return shape;}
    
    public Color getColor(){return color;}
    
    public int getHeight(){return shape.length;}
    
    public int getWidth(){return shape[0].length;}
    
    public int getX(){return x;}
    
    public void setX(int newX){x= newX;}
    
    public int getY(){return y;}
    public void setY(int newY){x= newY;}
    
    //method for moving blocks
    public void moveDown(){y++;}
    
    public void moveLeft(){x--;}
    
    public void moveRight(){x++;}
    
    public void rotate(){
        //switch from one shape to the next
        currentRotation++;
        if(currentRotation>3) currentRotation =0;
        shape = shapes[currentRotation];
    }
    
    public int getBottomEdge() {return y + getHeight();}
    
    public int getLeftEdge(){return x;}
    
    public int getRightEdge(){return x + getWidth();}
    
}
