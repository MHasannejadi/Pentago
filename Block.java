/**
 * this class manage every block from 4 block of a board and save its information 
 * and rotate it
 * @author Mohammad Hassannejadi
 * @version 1.0
 */
public class Block{
    private int blocks[][]; // 0 means empty , 1 means black , 2 means red 
    private int copyBlocks[][];
    public Block(){
        blocks = new int[3][3];
        copyBlocks = new int[3][3];
        for(int i = 0 ; i < 3 ; i++){
            for( int j =0 ; j<3 ; j++){
                blocks[i][j] = 0;
            }
        }
    }
    /**
     * getter type of one location
     * @param x x coordinate of block
     * @param y y coordinate of block
     * @return type of block //0 empty 1 black 2 red
     */
    public int getBlock(int x , int y){
        return blocks[x][y];
    }
    /**
     * add a cell to this block
     * @param type type of block
     * @param x x of block
     * @param y y of block
     */
    public void addCell(int type , int x , int y){
        blocks[x][y] = type;
    }
    /**
     * rotate a block
     * @param direction 0 anticlockwise and 1 clockwise
     *
     */
    public void rotate(int direction){
        
            
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0; j < 3 ; j++){
                copyBlocks[i][j] = blocks[i][j];
            }
        }
        
        if(direction == 0){  // anticlockwise
           
            blocks[0][0] = copyBlocks[2][0];
            blocks[0][1] = copyBlocks[1][0];
            blocks[0][2] = copyBlocks[0][0];
            blocks[1][0] = copyBlocks[2][1];
            blocks[1][2] = copyBlocks[0][1];
            blocks[2][0] = copyBlocks[2][2];
            blocks[2][1] = copyBlocks[1][2];
            blocks[2][2] = copyBlocks[0][2];
        }
        else{ //clockwise
            blocks[0][0] = copyBlocks[0][2];
            blocks[0][1] = copyBlocks[1][2];
            blocks[0][2] = copyBlocks[2][2];
            blocks[1][0] = copyBlocks[0][1];
            blocks[1][2] = copyBlocks[2][1];
            blocks[2][0] = copyBlocks[0][0];
            blocks[2][1] = copyBlocks[1][0];
            blocks[2][2] = copyBlocks[2][0];
        }
    }
}