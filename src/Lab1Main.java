import java.util.Scanner;

public class Lab1Main {

    /**
     * Pseudo code for loop
     * while(running)
     *      print main menu
     *      get user menu choice
     *          - 1: (view balance)
     *              print balance
     *
     *          - 2: (Withdraw Cash)
     *              print withdraw cash menu
     *              get user choice of currency
     *              get user amount of withdrawal
     *              subtract amount from wallet
     *                  - create USD object from input
     *                  - call wallet subtract
     *
     *          - 3: (Deposit Cash)
     *              print deposit cash menu
     *              get user choice of currency
     *              get user amount of deposit
     *              add amount to wallet
     *                  - create USD object from input
     *                  - call wallet add
     *
     *          - 4: (Compare)
     *              print Compare cash menu
     *              get user choice of currency
     *              get user amount to compare
     *              create money object
     *              call compare from wallet
     *                   - result < 0 wallet(specific currency) has less money
     *                   - result > 0  wallet(specific currency) has more money
     *                   - result = 0  equal(specific currency) amount
     *          -5:  (exit)
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        Wallet wallet = new Wallet();

        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        printWelcome();
        while (!exit) {
            printMainMenu();
            int input = scan.nextInt();
            printDash();
            switch (input) {
                case 1: //View Balance
                    //Print balance
                    System.out.println("Your balance is:");
                    wallet.printInfo();
                    printDash();
                    break;
                case 2: //Withdraw Cash

                    //Get currency type
                    printWithdrawMenu();
                    input = scan.nextInt();

                    //Get withdraw amount
                    System.out.print("Enter amount (Ex: $5.00): $");
                    double val = scan.nextDouble();

                    //Subtract from wallet
                    if (input == 1) {

                        wallet.sub(new USD((int) val, (int) (val * 100 % 100), "USD"));// dollar amount, cents amount, name
                    } else if (input == 2) {
                        wallet.sub(new C2D((int) val, (int) (val * 100 % 100), "C2D", 1.36));
                    }

                    System.out.println("**No amount will be deducted if there are any irregularities**");
                    printDash();
                    break;
                case 3://Deposit Cash

                    //Get deposit currency
                    printDepositMenu();
                    input = scan.nextInt();

                    //Get deposit amount
                    System.out.print("Enter amount (Ex: $5.00): $");
                    val = scan.nextDouble();

                    //Add amount to wallet
                    if (input == 1) {
                        wallet.add(new USD((int) val, (int) (val * 100 % 100), "USD"));
                    } else if (input == 2) {
                        wallet.add(new C2D((int) val, (int) (val * 100 % 100), "C2D", 1.36));
                    }

                    System.out.println("**No amount will be added if there are any irregularities**");
                    printDash();
                    break;

                case 4://Compare Menu
                    //Get currency type
                    printCompareMenu();
                    input = scan.nextInt();

                    //Get amount to compare
                    System.out.print("Enter amount (Ex: $5.00): $");
                    val = scan.nextDouble();

                    //Create money
                    USD money = null;
                    int result;
                    if (input == 1) {
                        money = new USD((int) val, (int) (val * 100 % 100), "USD");
                    } else if (input == 2) {
                        money  = new C2D((int) val, (int) (val * 100 % 100), "C2D", 1.36);
                    } else {
                        break;
                    }

                    //get comparison result
                    result = wallet.compare(money);

                    //Print comparison result
                    if(result < 0){
                        System.out.println("$" + val + " is greater than " + money.getName() + " balance");

                    }
                    else if(result > 0){
                        System.out.println("$" + val + " is less than " + money.getName() + " balance");
                    }
                    else {
                        System.out.println("$" + val + " is equal to " + money.getName() + " balance");
                    }
                    printDash();
                    break;
                case 5://Exit
                    exit = true;
                    printDash();
                    break;
            }

        }

    }

    /**
     * Prints welcome banner
     */
    public static void printWelcome(){
        System.out.println(
                "\n====================================================="
                        + "\n***********Welcome To Wallet International***********"
                        + "\n=====================================================");

    }

    /**
     * prints Compare  menu with input message
     */
    public static void printCompareMenu(){
        System.out.print("Compare menu\n" +
                "\t1 - Compare USD\n" +
                "\t2 - Compare C2D\n" +
                "\tEnter a choice: ");
    }

    /**
     * Prints Deposit menu with input message
     */
    public static void printDepositMenu(){
        System.out.print("Deposit menu\n" +
                "\t1 - Deposit USD\n" +
                "\t2 - Deposit C2D\n" +
                "\tEnter a choice: ");
    }

    /**
     * Prints withdraw menu with input message
     */
    public static void printWithdrawMenu(){
        System.out.print("Withdraw menu\n" +
                "\t1 - Withdraw USD\n" +
                "\t2 - Withdraw C2D\n" +
                "\tEnter a choice: ");
    }

    /**
     * prints main menu with input message
     */
    public static void printMainMenu(){
        System.out.print("Main menu\n" +
                "\t1 - View my balance\n" +
                "\t2 - Withdraw Cash\n" +
                "\t3 - Deposit funds\n" +
                "\t4 - Compare\n" +
                "\t5 - Exit\n" +
                "Enter a choice: ");
    }
    public static void printDash() {
        System.out.println("-----------------------------------------------------");
    }
}

