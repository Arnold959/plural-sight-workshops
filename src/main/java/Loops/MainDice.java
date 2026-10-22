package Loops;

public class MainDice {
    public static void main(String[] args) {
        //Create Dice object
        Dice dice = new Dice();
        //Variables
        int roll1;
        int roll2;
        int sum;
        //Counters
        int twoCounter = 0;
        int fourCounter = 0;
        int sixCounter = 0;
        int sevenCounter = 0;
        //Roll dice 100 times
        for  (int i = 1; i <= 100; i++) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            sum = roll1 + roll2;
            //Display each roll
            System.out.println("Roll 1: " + i +roll1 + " -" + " Roll 2: "
                    + roll2 + " Sum: " + sum);
            //Count the sums
            if (sum == 2) {
                twoCounter++;
            }
            if (sum == 4) {
                fourCounter++;
            }
            if (sum == 6) {
                sixCounter++;
            }
            if (sum == 7) {
                sevenCounter++;
            }
        }
        //Display final results
        System.out.println("\nFinal Results:");
        System.out.println("Sum of 2:" + twoCounter);
        System.out.println("Sum of 4:" + fourCounter);
        System.out.println("Sum of 6:" + sixCounter);
        System.out.println("Sum of 7:" + sevenCounter);

    }
}
