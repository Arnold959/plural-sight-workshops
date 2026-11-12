package BigDecimal;

import java.math.BigDecimal;

public class MoneyMath {

    public static void main(String[] args) {

        // Step 1: Create three variables starting at 0
        float floatMoney = 0;
        double doubleMoney = 0;
        BigDecimal bigMoney = BigDecimal.ZERO;

        // Step 2: Loop 10 times
        for (int i = 0; i < 10; i++) {

            // Add 10 cents to each variable
            floatMoney += 0.10f;
            doubleMoney += 0.10;
            bigMoney = bigMoney.add(new BigDecimal("0.10"));

            // Print the values side by side
            System.out.println("Float: " + floatMoney
                    + " | Double: " + doubleMoney
                    + " | BigDecimal: " + bigMoney);
        }

        // Step 3: Reset all variables to 0
        floatMoney = 0;
        doubleMoney = 0;
        bigMoney = BigDecimal.ZERO;

        // Step 4: Loop 1000 times
        for (int i = 0; i < 1000; i++) {

            // Add 19.99 to each variable
            floatMoney += 19.99f;
            doubleMoney += 19.99;
            bigMoney = bigMoney.add(new BigDecimal("19.99"));
        }

        // Print the results after the loop
        System.out.println("\nAfter 1000 iterations:");

        System.out.println("Float: " + floatMoney);
        System.out.println("Double: " + doubleMoney);
        System.out.println("BigDecimal: " + bigMoney);

        // Step 5: Compare the values
        System.out.println("\nComparing the values:");

        System.out.println("Float and Double: "
                + (floatMoney == doubleMoney));

        System.out.println("Double and BigDecimal: "
                + (BigDecimal.valueOf(doubleMoney).compareTo(bigMoney) == 0));

    }
}

