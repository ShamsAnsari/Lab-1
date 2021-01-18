import java.util.Scanner;

public class Lab1Main {
    public static void main(String[] args){

        Wallet wallet = new Wallet();

        boolean exit = false;
        Scanner scan = new Scanner(System.in);


        System.out.println(
                 "\n====================================================="
                +"\n***********Welcome To Wallet International***********"
                +"\n=====================================================");

        while(!exit){
            System.out.println("Main menu\n" +
                    "\t1 - View my balance\n" +
                    "\t2 - Withdraw Cash\n" +
                    "\t3 - Deposit funds\n" +
                    "\t4 - Exit\n" +
                    "Enter a choice: ");
            int input = scan.nextInt();
            switch (input){
                case 1:
                    System.out.println("Your balance is:");
                    wallet.printInfo();
                    break;
                case 2:
                    System.out.println("Withdraw menu\n" +
                            "\t1 - Withdraw USD\n" +
                            "\t2 - Withdraw C2D\n" +
                            "\tEnter a choice: ");
                    input = scan.nextInt();
                    System.out.println("Enter amount(if amount is greater than balance: no amount will be deducted):");
                    double
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        }




    }
}
