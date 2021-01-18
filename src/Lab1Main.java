import java.util.Scanner;

public class Lab1Main {
    public static void main(String[] args) {

        Wallet wallet = new Wallet();

        boolean exit = false;
        Scanner scan = new Scanner(System.in);


        System.out.println(
                "\n====================================================="
                        + "\n***********Welcome To Wallet International***********"
                        + "\n=====================================================");

        while (!exit) {
            System.out.print("Main menu\n" +
                    "\t1 - View my balance\n" +
                    "\t2 - Withdraw Cash\n" +
                    "\t3 - Deposit funds\n" +
                    "\t4 - Compare\n" +
                    "\t5 - Exit\n" +
                    "Enter a choice: ");
            int input = scan.nextInt();
            printDash();
            switch (input) {
                case 1:
                    System.out.println("Your balance is:");
                    wallet.printInfo();
                    printDash();
                    break;
                case 2:
                    System.out.print("Withdraw menu\n" +
                            "\t1 - Withdraw USD\n" +
                            "\t2 - Withdraw C2D\n" +
                            "\tEnter a choice: ");
                    input = scan.nextInt();
                    System.out.print("Enter amount (Ex: $5.00): $");
                    double val = scan.nextDouble();
                    if (input == 1) {
                        wallet.sub(new USD((int) val, (int) (val * 100 % 100), "USD"));
                    } else if (input == 2) {
                        wallet.sub(new C2D((int) val, (int) (val * 100 % 100), "C2D", 1.36));
                    }
                    System.out.println("**No amount will be deducted if there are any irregularities**");
                    printDash();
                    break;
                case 3:
                    System.out.print("Deposit menu\n" +
                            "\t1 - Deposit USD\n" +
                            "\t2 - Deposit C2D\n" +
                            "\tEnter a choice: ");
                    input = scan.nextInt();
                    System.out.print("Enter amount (Ex: $5.00): $");
                    val = scan.nextDouble();

                    if (input == 1) {
                        wallet.add(new USD((int) val, (int) (val * 100 % 100), "USD"));
                    } else if (input == 2) {
                        wallet.add(new C2D((int) val, (int) (val * 100 % 100), "C2D", 1.36));
                    }
                    System.out.println("**No amount will be added if there are any irregularities**");
                    printDash();
                    break;
                case 4:
                    System.out.print("Compare menu\n" +
                            "\t1 - Compare USD\n" +
                            "\t2 - Compare C2D\n" +
                            "\tEnter a choice: ");
                    input = scan.nextInt();
                    System.out.print("Enter amount (Ex: $5.00): $");
                    val = scan.nextDouble();
                    USD money = null;
                    int result;
                    if (input == 1) {
                        money = new USD((int) val, (int) (val * 100 % 100), "USD");
                    } else if (input == 2) {
                        money  = new C2D((int) val, (int) (val * 100 % 100), "C2D", 1.36);
                    } else {
                        break;
                    }
                    result = wallet.compare(money);

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
                case 5:
                    exit = true;
                    printDash();
                    break;
            }

        }

    }

    public static void printDash() {
        System.out.println("-----------------------------------------------------");
    }
}

