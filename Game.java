import java.util.Scanner;
/**
 * This class contains a map and its play method to manage game generally and 
 * get input and connect with map class to do different actions of game
 * @author Mohammad Hassannejadi
 * @version 1.0 
 */
public class Game {
    
    private Map map;
    /**
     * constructor of game to create an instance of map
     */
    public Game(){
        map = new Map();
    }
    /**
     * play method is manage inputs and pass them to map and manage game generally 
     */
    public void play(){
        while(!map.checkFullMap()){
            try{
                map.show();
                System.out.println("Turn: "+map.getTurn());
                Scanner obj = new Scanner(System.in);
                while(true){
                    System.out.println("Please choose a coordinate");
                    String input = obj.next();
                    int numY = Integer.parseInt(""+input.charAt(0));
                    char word = input.charAt(1);
                    int numX = 0;
                    if((numY>0 && numY<7)&&(word == 'A' || word == 'B' || word == 'C' || word == 'D' || word == 'E' || word == 'F')){
                        if(word=='A'){
                            numX = 1;
                        }
                        if(word=='B'){
                            numX = 2;
                        }
                        if(word=='C'){
                            numX = 3;
                        }
                        if(word=='D'){
                            numX = 4;
                        }
                        if(word=='E'){
                            numX = 5;
                        }
                        if(word=='F'){
                            numX = 6;
                        }
                        if(!map.checkEmpty(numX, numY)){
                            System.out.println("Wrong coordiante");
                        }
                        else{
                            map.addCell(numX,numY);
                            break;
                        }

                    }
                    else{
                        System.out.println("Wrong input !!!");
                    }
                    
                }
                map.show();
                if(map.blackWin() && map.redWin()){
                   
                    System.out.println("Draw :|");
                    break;
                }
                else if(map.blackWin()){
                   
                    System.out.println("Black wins :)");
                    break;
                }
                else if(map.redWin()){
                    
                    System.out.println("Red wins :)");
                    break;
                }    
                while(true){
                    System.out.println("Please choose a block form 1 to 4");
                    int blockNum = obj.nextInt();
                    System.out.println("please enter a rotate direction : 0 = anticlockwise , 1 = clockwise"); 
                    int direction = obj.nextInt();
                    if((blockNum>0 && blockNum<5)&&(direction == 0 || direction == 1)){
                        map.rotateBlock(blockNum, direction);
                        break;
                    }
                    else{
                        System.out.println("Something went wrong :( . Try again");
                    }
                }
                
                if(map.blackWin() && map.redWin()){
                    map.show();
                    System.out.println("Draw :|");
                    break;
                }
                else if(map.blackWin()){
                    map.show();
                    System.out.println("Black wins :)");
                    break;
                }
                else if(map.redWin()){
                    map.show();
                    System.out.println("Red wins :)");
                    break;
                }    
            }catch(Exception e){
                System.out.println("Something is wrong :( Try again.");
                System.out.println();
            }
            if(map.checkFullMap()){
                map.show();
                System.out.println("Draw :|");
            }
        }      
    }   

}

