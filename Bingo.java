import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Bingo {
    //instantiate card along with other class variables for the game
    static int[][] board = new int[5][5];
    static boolean repeatsAllowed = false;
    static boolean win = false;
    static int htotal = 0, vtotal = 0, dtotal = 0;
    static ArrayList<Integer> calledNumbers = new ArrayList<>(50);
    static ArrayList<String> winType = new ArrayList<>(1);

    public static void main(String args[])throws IOException{
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to Bingo!");
        System.out.println("~~~~~~~~~~~~~~~~~");
        fillCard(board);
        System.out.println("Here's your card for this round.");
        showCard(false);

        //ask the player how they'd like to play the game
        try {
            System.out.println("Do you want to play the game with repeating numbers? (true/yes and false/no)");
            Scanner scanscan= new Scanner(System.in);
            repeatsAllowed = scanscan.nextBoolean();
            scanscan.close();
            System.out.println();

            //play
            playGame(true); 
        } catch (Exception inputMismatchException) {
            System.out.println("Try again and enter either true or false.");
        }
  
    }

    //method that sets up the card using for loops
    public static void fillCard(int[][] b)throws IOException{
        File file = new File("bingo.in");
        Scanner scanny = new Scanner(file);

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                board[i][j] = scanny.nextInt();
                //System.out.println(i + j);
            }
        }
        scanny.close();
    }

    //method that prints the card (include version for win)
    public static void showCard(boolean w){
        System.out.println("**********************************");
        String[] letters = {"B", "I", "N", "G", "O"};
        if(!w){
            for(int i = -1; i<5; i++){
                for(int j = 0; j<5; j++){
                    if(i==-1){
                        System.out.print(letters[j]+ "\t");
                    }
                    else System.out.print(board[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else{
            for(int i = -1; i<5; i++){
                for(int j = 0; j<5; j++){
                    if(i==-1){
                        System.out.print(letters[j]+ "\t");
                    }
                    else if(board[i][j]==0){
                        System.out.print("X" + "\t");
                    }
                    else{
                        System.out.print(board[i][j] + "\t");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("**********************************");
        System.out.println();
    }

    //method that checks for win & resets counter values prevent overlap
    public static boolean checkForWin(){
        //scan for horizontal win
        for(int[]i:board){
            htotal = 0;
            for(int j:i){
                htotal+=j;
            }
            if(htotal==0){
                win=true;
                break;
            }
        }

        //scan for vertical win
        for(int j =0; j<board[0].length; j++){
            vtotal = 0;
            for(int i = 0; i<board.length; i++){
                vtotal+=board[i][j];
            }
            if(vtotal==0){
                win=true;
                break;
            }
        }

        //scan for forward diagonal win
        dtotal=0;
        for(int i = 0; i<board.length; i++){
            dtotal+=board[i][i];
        }
        if(dtotal==0){
            win=true;
        }
        else{
            dtotal=0;
            for(int i = 0; i<board.length; i++){
                int j=4;
                dtotal+=board[i][j-i];
            }
            if(dtotal==0){
                win=true;
            } 
        } 
        return win;
    }

    //method that picks random number between 1 and 75
    public static int pickNum(boolean r){
        int num = (int)(1+(Math.random()* 75));
        if(r){
            calledNumbers.add(num);
        }
        else{
            while(calledNumbers.contains(num)){
                num = (int)(1+(Math.random()* 75));
            }
            calledNumbers.add(num);
        }
        return num;
    }

    //actual gameplay that loops until a row/column/diagonal is crossed off
    public static void playGame(boolean r){ 
        boolean gameOver=false;    
        while(gameOver==false){
            int calledNum = pickNum(r);
            updateCard(calledNum);
            gameOver=checkForWin();
        }

        //winning dialogue/code
        System.out.println("Here are the called Numbers: "+calledNumbers);
        System.out.println();
        System.out.println("It only took "+calledNumbers.size()+" calls but you got a "+getWinType() +" win!");
        System.out.println("Congratulations, take a look at your winning card! ");
        showCard(win);
        System.out.println("~~~~~~~~~~~~~~~~");
        System.out.println("Play again soon!");
        System.out.println("~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println();
        reset();
    }

    //changes values to 0 when the number called is on the board
    public static void updateCard(int num){
        for(int i=0; i<5; i++){
            for( int j = 0; j<5; j++){
                if(board[i][j]==num){
                    board[i][j]=0;
                }
            }
        }
    }

    //resets the class values at the end of the game
    public static void reset(){
        calledNumbers.clear();
        win=false;
        repeatsAllowed=false;
        winType.clear();
    }

    //determines how the player won
    public static String getWinType(){
        String type="";
        if(htotal==0){
            winType.add("horizontal");
        }
        if(vtotal==0){
            winType.add("vertical");
        }
        if(dtotal==0){
            winType.add("diagonal");
        }

        if(winType.size()==3){
            type=winType.get(0) + ", "+ winType.get(1) + ", and " + winType.get(2);
        }
        else if(winType.size()==2){
            type=winType.get(0) + " and " + winType.get(1);
        }
        else{
            type=winType.get(0);
        }
        return type;
    }

}
