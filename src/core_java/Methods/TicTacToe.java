package core_java.Methods;

import java.util.Scanner;

public class TicTacToe {

    private char[][] gameBoard;
    private char player;
    private int turnCount;
    private Scanner scanner;
    private int playedRow;
    private int playedCol;

    TicTacToe(){
        this('X');
    }

    TicTacToe(char player){
        this.player = player;
        this.gameBoard = new char[3][3];
        this.turnCount = 0;
        this.scanner = new Scanner(System.in);
        initializeBoard();
    }

    public void start(){
        while(!isWinner() && !isBoardFull()){
            getUserInput();
            gameBoard[playedRow][playedCol] = player;
            printBoard();
            togglePlayers();
            turnCount++;
        }
        printWinner();
    }

    private void getUserInput() {
        System.out.print(player+"'s Turn: Enter row col: ");
        playedRow = scanner.nextInt() - 1;
        playedCol = scanner.nextInt() - 1;
        if(playedRow<0 || playedRow>2 || playedCol<0 || playedCol>2 || gameBoard[playedRow][playedCol]!='-'){
            System.out.println("Invalid input. Please enter again.");
            getUserInput();
        }
    }

    private void togglePlayers() {
        if(player=='X'){
            player='O';
        }else{
            player='X';
        }
    }

    private void printBoard(){
        for(char[] arr: gameBoard){
            for(char e: arr){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    private void initializeBoard(){
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                this.gameBoard[row][col] = '-';
            }
        }
    }

    private void printWinner(){
        togglePlayers();
        System.out.println();
        if(isWinner()){
            System.out.println("Congrats "+player+"!! You won.");
        }else{
            System.out.println("DRAW");
        }
    }

    private boolean isWinner(){
        if(turnCount<5) return false;
        char currentPlayer = gameBoard[playedRow][playedCol];
        if (isRowWin(currentPlayer)) return true;
        if (isColWin(currentPlayer)) return true;
        if (isBackwardDiagonalWin(currentPlayer)) return true;
        if (isForwardDiagonalWin(currentPlayer)) return true;
        return false;
    }

    private boolean isForwardDiagonalWin(char currentPlayer) {
        int row;
        int col;
        for(row=0; row<3; row++){
            col = 2-row;
            if(gameBoard[row][col]!= currentPlayer){
                return false;
            }
        }
        return true;
    }

    private boolean isBackwardDiagonalWin(char currentPlayer) {
        int col;
        int row;
        for(row=0; row<3; row++){
            col = row;
            if(gameBoard[row][col]!= currentPlayer){
                return false;
            }
        }
        return true;
    }

    private boolean isColWin(char currentPlayer) {
        int col;
        int row;
        col = playedCol;
        for(row=0; row<3; row++){
            if(gameBoard[row][col]!= currentPlayer){
                return false;
            }
        }
        return true;
    }

    private boolean isRowWin(char currentPlayer) {
        int row, col;
        row = playedRow;
        for(col=0; col<3; col++){
            if(gameBoard[row][col]!= currentPlayer){
                return false;
            }
        }
        return true;
    }

    private boolean isBoardFull(){
        return turnCount==9;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe('X');
        game.start();
    }
}
