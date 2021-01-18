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
            System.out.print("Main menu\n" +
                    "\t1 - View my balance\n" +
                    "\t2 - Withdraw Cash\n" +
                    "\t3 - Deposit funds\n" +
                    "\t4 - Exit\n" +
                    "Enter a choice: ");
            int input = scan.nextInt();
            printDash();
            switch (input){
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
                    if(input == 1){
                        wallet.sub(new USD((int)val,(int)(val * 100 % 100), "USD" ));
                    }else if(input == 2) {
                        wallet.sub(new C2D((int) val, (int)( val * 100 % 100), "C2D", 1.36));
                    }
                    System.out.println("**No amount will be deducted if withdrawal is greater than balance**");
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

                    if(input == 1){
                        wallet.add(new USD((int)val,(int)(val * 100 % 100), "USD" ));
                    }else if(input == 2) {
                        wallet.add(new C2D((int) val, (int) (val * 100 % 100), "C2D", 1.36));
                    }
                    System.out.println("**No amount will be deducted if withdrawal is greater than balance**");
                    printDash();
                    break;
                case 4:
                    exit = true;
                    printDash();
                    break;
            }

        }

    }

    public static void printDash(){
         System.out.println("-----------------------------------------------------");
    }
}

