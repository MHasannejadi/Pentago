import java.util.ArrayList;
/**
 * This class is manage positions and board of game and change them
 * and check end of game
 * @author Mohammad Hassannejadi 
 * @version 1.0
 */
public class Map{
    private int map[][];
    private char visualMap[][]; 
    private ArrayList<Block> blocks;
    private int turn;
    private Block block1;
    private Block block2;
    private Block block3;
    private Block block4;
    /**
     * constructor of map class to first assign of maps and blocks
     */
    public Map(){
        turn = 0;
        visualMap = new char[100][100];
        map = new int[100][100];
        blocks = new ArrayList<Block>();
        block1 = new Block();
        blocks.add(block1);
        block2 = new Block();
        blocks.add(block2);
        block3 = new Block();
        blocks.add(block3);
        block4 = new Block();
        blocks.add(block4);
    }
    /**
     * check if map is full or no
     * @return true if full 
     */
    public boolean checkFullMap(){
        int cont = 0;
        for(int i = 0 ; i<6 ; i++){
            for(int j = 0 ; j<6 ; j++){
                if(map[i][j]!=0){
                    cont++;
                }
            }
        }
        if(cont == 36){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * check a location is empty or no
     * @param x x of location
     * @param y y
     * @return true if empty
     */
    public boolean checkEmpty(int x , int y){
        x--;
        y--;
        if(x<3 && y<3){
            if(blocks.get(0).getBlock(x, y) == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else if(x<3 && y>2){
            y -= 3;
            if(blocks.get(2).getBlock(x, y) == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else if(y<3 && x>2){
            x -= 3;
            if(blocks.get(1).getBlock(x, y) == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            x -= 3;
            y -= 3;
            if(blocks.get(3).getBlock(x, y) == 0){
                return true;
            }
            else{
                return false;
            }
        }

        
    }
    /**
     * assign map array with blocks locations
     */
    public void updateMap(){
        for(int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j<3 ; j++){
                map[i][j] = blocks.get(0).getBlock(i, j);
            }
        }
        for(int i = 3 ; i<6 ; i++){
            for(int j=0 ; j<3 ; j++){
                map[i][j] = blocks.get(1).getBlock(i-3, j);
            }
        }
        for(int i = 0 ; i<3 ; i++){
            for(int j=3 ; j<6 ; j++){
                map[i][j] = blocks.get(2).getBlock(i, j-3);
            }
        }
        for(int i = 3 ; i<6 ; i++){
            for(int j=3 ; j<6 ; j++){
                map[i][j] = blocks.get(3).getBlock(i-3, j-3);
            }
        }
    }
    /**
     * add a bead or cell to board and block
     * @param x x location
     * @param y y
     */
    public void addCell(int x , int y){
        x--;
        y--;
        
        if(turn%2==0){ //black turn
            
            if(x<3 && y<3){
                blocks.get(0).addCell(1, x, y);
            }
            else if(x<3 && y>2){
                y -= 3;
                blocks.get(2).addCell(1, x, y);
            }
            else if(y<3 && x>2){
                x -= 3;
                blocks.get(1).addCell(1, x, y);
            }
            else{
                x -= 3;
                y -= 3;
                blocks.get(3).addCell(1, x, y);
            }
        }
        else{ //red turn
           
            if(x<3 && y<3){
                blocks.get(0).addCell(2, x, y);
            }
            else if(x<3 && y>2){
                y -= 3;
                blocks.get(2).addCell(2, x, y);
            }
            else if(y<3 && x>2){
                x -= 3;
                blocks.get(1).addCell(2, x, y);
            }
            else{
                x -= 3;
                y -= 3;
                blocks.get(3).addCell(2, x, y);
            }
        }
        updateMap();
        turn++;
    }

    /**
     * check  if black  win or no
     * @return true if black wins
     */
    
    public boolean blackWin(){
        for(int i = 0 ; i<6 ; i++){
            for(int j = 0 ; j<6 ; j++){
                if(map[i][j] == 1){
                    if(i>0&&map[i-1][j] == 1){ //1
                        int ci = i; //copy i
                        int cj = j;
                        int counter = 1; //black counter
                        while(ci>=0 && map[ci][cj] == 1){
                            ci--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(i<5&&map[i + 1][j] == 1) {
                            ci = i;
                            cj = j;
                            while(ci<6 && map[ci][cj] == 1){
                                ci++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                    else if(j>0&&map[i][j-1] == 1){ //2
                        int ci = i; //copy i
                        int cj = j;
                        int counter = 1; //black counter
                        while(cj>=0 && map[ci][cj] == 1){
                            cj--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(j<5&&map[i][j + 1] == 1) {
                            ci = i;
                            cj = j;
                            while(cj<6 && map[ci][cj] == 1){
                                cj++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                    else if(i>0&&j>0&&map[i-1][j-1] == 1){ //3
                        int ci = i; //copy i
                        int cj = i;
                        int counter = 1; //black counter
                        while(cj>=0 && ci>=0 && map[ci][cj] == 1){
                            cj--;
                            ci--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(i<5&&j<5&&map[i + 1][j + 1] == 1) {
                            ci = i;
                            cj = j;
                            while(cj<6 && ci<6 && map[ci][cj] == 1){
                                cj++;
                                ci++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                    else if(j<5&&i>0&&map[i-1][j+1] == 1){ //4
                        int ci = i; //copy i
                        int cj = j;
                        int counter = 1; //black counter
                        while(cj<6 && ci>=0 && map[ci][cj] == 1){
                            cj++;
                            ci--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(i<5&&j>0&&map[i + 1][j - 1] == 1) {
                            ci = i;
                            cj = j;
                            while(cj>=0 && ci<6 && map[ci][cj] == 1){
                                cj--;
                                ci++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                    
                }
            }
        } 
        return false;   
        
    }
    
    /**
     * check  if red  win or no
     * @return true if red wins
     */
    
    public boolean redWin(){
        
        for(int i = 0 ; i<6 ; i++){
            for(int j = 0 ; j<6 ; j++){
                if(map[i][j] == 2){
                    if(i>0&&map[i-1][j] == 2){ //1
                        int ci = i; //copy i
                        int cj = j;
                        int counter = 1; //red counter
                        while(ci>=0 && map[ci][cj] == 2){
                            ci--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(i<5&&map[i + 1][j] == 2) {
                            ci = i;
                            cj = j;
                            while(ci<6 && map[ci][cj] == 2){
                                ci++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                    else if(j>0&&map[i][j-1] == 2){ //2
                        int ci = i; //copy i
                        int cj = j;
                        int counter = 1; //red counter
                        while(cj>=0 && map[ci][cj] == 2){
                            cj--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(j<5&&map[i][j + 1] == 2) {
                            ci = i;
                            cj = j;
                            while(cj<6 && map[ci][cj] == 2){
                                cj++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                    else if(i>0&&j>0&&map[i-1][j-1] == 2){ //3
                        int ci = i; //copy i
                        int cj = i;
                        int counter = 1; //red counter
                        while(cj>=0 && ci>=0 && map[ci][cj] == 2){
                            cj--;
                            ci--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(i<5&&j<5&&map[i + 1][j + 1] == 2) {
                            ci = i;
                            cj = j;
                            while(cj<6 && ci<6 && map[ci][cj] == 2){
                                cj++;
                                ci++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                    else if(j<5&&i>0&&map[i-1][j+1] == 2){ //4
                        int ci = i; //copy i
                        int cj = j;
                        int counter = 1; //red counter
                        while(cj<6 && ci>=0 && map[ci][cj] == 2){
                            cj++;
                            ci--;
                            counter++;
                        }
                        counter--;
                        if(counter > 4){
                            return true;
                        }
                        else if(i<5&&j>0&&map[i + 1][j - 1] == 2) {
                            ci = i;
                            cj = j;
                            while(cj>=0 && ci<6 && map[ci][cj] == 2){
                                cj--;
                                ci++;
                                counter++;
                            }
                            counter--;
                            if(counter > 4){
                                return true;
                            }
                        }
                    }
                   
                }
            }
        }
        return false; 
    }
    /**
     * rotate selected block
     * @param n number of block
     * @param direction directio of rotate
     */
    public void rotateBlock(int n , int direction){ // n : number of block , rotate direction : 0 = anticlockwise , 1 = clockwise 
        blocks.get(n-1).rotate(direction);
        updateMap();
    }

    public String getTurn(){
        if(turn%2==0){
            return "Black";
        }
        else{
            return "Red";
        }
    }

    /**
     * adding elements of  characters to map array 
     */
    public void addElements(){
        for(int i=0; i<3*7+2; i++)
        {
            for(int j=0; j<6*7+3; j++)
            {
                if(j<22&&i<12){
                    if((i%3==1)&&((j%6)!=2)&&(j>1)&&(j<20||j>26))
                    {
                        visualMap[j][i]='_';

                    }

                    else if((i>1)&&(j%6==2)&&(i!=11)&&(i!=12)&&(i!=13))
                    {
                        visualMap[j][i]='|';

                    }
                    else
                    {
                        visualMap[j][i]=' ';

                    }
                }
                else if(j<22&&i>12){
                    if((i%3==1)&&((j%6)!=2)&&(j>1)&&(j<20||j>26))
                    {
                        visualMap[j][i-2]='_';

                    }

                    else if((i>1)&&(j%6==2)&&(i!=11)&&(i!=12)&&(i!=13))
                    {
                        visualMap[j][i-2]='|';

                    }
                    else
                    {
                        visualMap[j][i-2]=' ';

                    }
                }
                else if(j>23&&i<12){
                    if((i%3==1)&&((j%6)!=2)&&(j>1)&&(j<20||j>26))
                    {
                        visualMap[j-3][i]='_';

                    }

                    else if((i>1)&&(j%6==2)&&(i!=11)&&(i!=12)&&(i!=13))
                    {
                        visualMap[j-3][i]='|';

                    }
                    else
                    {
                        visualMap[j-3][i]=' ';

                    }
                }
                else if(j>23&&i>12){
                    if((i%3==1)&&((j%6)!=2)&&(j>1)&&(j<20||j>26))
                    {
                        visualMap[j-3][i-2]='_';

                    }

                    else if((i>1)&&(j%6==2)&&(i!=11)&&(i!=12)&&(i!=13))
                    {
                        visualMap[j-3][i-2]='|';

                    }
                    else
                    {
                        visualMap[j-3][i-2]=' ';

                    }
                }
                

            }
        }
        visualMap[5][0] = 'A';
        visualMap[11][0] = 'B';
        visualMap[17][0] = 'C';
        visualMap[26][0] = 'D';
        visualMap[32][0] = 'E';
        visualMap[38][0] = 'F';
        visualMap[0][3] = '1';
        visualMap[0][6] = '2';
        visualMap[0][9] = '3';
        visualMap[0][13] = '4';
        visualMap[0][16] = '5';
        visualMap[0][19] = '6';

        for(int i=0 ; i<6 ; i++){
            for(int j=0 ; j<6 ; j++){
                if(i<3 && j<3){
                    if(map[i][j]==1){
                        visualMap[6*i+5][3*j+3]='B'; //black
                        //visualMap[6*i+5][3*j+3]='☆';
                    }
                    else if(map[i][j]==2){
                        visualMap[6*i+5][3*j+3]='R'; //red
                    // visualMap[6*i+5][3*j+3]='★';
                    }
                }
                else if(i>2 && j<3){
                    if(map[i][j]==1){
                        visualMap[6*i+8][3*j+3]='B'; //black
                        //visualMap[6*i+5][3*j+3]='☆';
                    }
                    else if(map[i][j]==2){
                        visualMap[6*i+8][3*j+3]='R'; //red
                    // visualMap[6*i+5][3*j+3]='★';
                    }
                }
                else if(i>2 && j>2){
                    if(map[i][j]==1){
                        visualMap[6*i+8][3*j+4]='B'; //black
                        //visualMap[6*i+5][3*j+3]='☆';
                    }
                    else if(map[i][j]==2){
                        visualMap[6*i+8][3*j+4]='R'; //red
                    // visualMap[6*i+5][3*j+3]='★';
                    }
                }
                else if(i<3 && j>2){
                    if(map[i][j]==1){
                        visualMap[6*i+5][3*j+4]='B'; //black
                        //visualMap[6*i+5][3*j+3]='☆';
                    }
                    else if(map[i][j]==2){
                        visualMap[6*i+5][3*j+4]='R'; //red
                    // visualMap[6*i+5][3*j+3]='★';
                    }
                }
            }
        }
    }
    /**
     * show the map and players
     */
    public void show(){
        addElements();
        for(int i=0 ; i<3*8+2 ; i++){
            for(int j=0 ; j<7*8+2 ; j++){
                System.out.print(visualMap[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}