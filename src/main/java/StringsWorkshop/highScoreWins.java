package StringsWorkshop;

import java.util.Scanner;

public class highScoreWins {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the game score");
        String game = scanner.nextLine().trim();
        findWinner(game);
        scanner.close();
    }
    //Method to find the winning team
    public static void findWinner(String game){
        //Separate teams and score
        String[] info = game.split("[|]");
        String[] teams = info[0].split(":");
        String[] scores = info[1].split(":");
        //Get team names
        String team1 = teams[0].trim();
        String team2 = teams[1].trim();
        //Convert score to integers
        int score1 = Integer.parseInt(scores[0].trim());
        int score2 = Integer.parseInt(scores[1].trim());
        //Find the winner
        if (score1 > score2){
            System.out.println("Congratulations! You won! " + team1);
        } else if (score2 > score1){
            System.out.println("Congratulations! You won! " + team2);
        } else  {
            System.out.println("It's a tie! ");
        }
    }
}
