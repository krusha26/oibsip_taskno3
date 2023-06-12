// Task-3 (Oasis Infobyte)
// ATM Interface

import java.util.*;

interface AtmOperation{
    public void transactionHistory();
    public void withdrawAmount();
    public void depositAmount();
    public void transferAmount();
    public void viewBalance();

}

class ATM{
    private double balance = 100000;

    public ATM(){

    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

}

class AtmOperationImpl implements AtmOperation{
    ATM atm = new ATM();
    Scanner sc = new Scanner(System.in);
    
    int transactions = 0;
    String transactionHistory = "";

    public void transactionHistory(){
        if(transactions == 0){
            System.out.println("No transactions yet!");
        }
        else{
            System.out.println("No. of transactions: "+transactions);
            System.out.println(transactionHistory);
        }
    }

    public void withdrawAmount(){
        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        try{
            if(atm.getBalance() >= amount && amount <= 20000){
                atm.setBalance(atm.getBalance() - amount);
                System.out.println("Withdraw Successfully.");
                transactions++;

                String st = transactions+" "+amount+" Rs Withdrawed\n";
                transactionHistory = transactionHistory.concat(st);
            }
            else if (amount > 20000 && atm.getBalance() < amount) {
                System.out.println("Insufficient balance!");
                System.out.println("You can only withdraw amount upto 20000 at a time.");
            }
            else if (amount > 20000) {
                System.out.println("You can only withdraw amount upto 20000 at a time.");
            }
            else{
                System.out.println("Insufficient balance!");
            }
        }
        catch(Exception e){

        }
    }

    public void depositAmount(){
        System.out.println("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        try{
            if (amount <= 100000) {
                atm.setBalance(atm.getBalance() + amount);
                System.out.println("\nSuccessfully Deposited!");
                transactions++;
                String st = transactions+" "+amount+" Rs deposited.\n";
                transactionHistory = transactionHistory.concat(st);
            }
            else{
                System.out.println("Sorry!!The maximum limit is 100000");
            }
        }
        catch(Exception e){

        }
    }

    public void transferAmount(){
        System.out.println("Enter recipient name: ");
        String recip = sc.nextLine();
        System.out.println("Enter recepient id: ");
        int recipid = sc.nextInt();
        System.out.println("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        try{
            if (atm.getBalance() >= amount) {
                if (amount <= 20000) {
                    atm.setBalance(atm.getBalance() - amount);
                    System.out.println("Successfully transfered to "+recip);
                    transactions++;
                    String st = transactions+" "+amount+" Rs transfered to "+recip+".\n";
                    transactionHistory = transactionHistory.concat(st);
                }
                else{
                    System.out.println("Sorry!!The maximum limit to transfer is 20000/-");
                }
            }
            else{
                System.out.println("Insufficient balance!");
            }
        }
        catch(Exception e){

        }
    }

    public void viewBalance(){
        System.out.println("Available balance is: "+atm.getBalance());
    }
}

public class AtmInterface{
    public static void main(String args[]){
        AtmOperationImpl op = new AtmOperationImpl();

        System.out.println("*****ATM INTERFACE*****");
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter the user name: ");
            String username = sc.nextLine();
            System.out.println("Enter the userid : ");
            int userid = sc.nextInt();
            System.out.println("Enter the user pin: ");
            int userpin = sc.nextInt();

            while (true) {
                System.out.println("*******************");
                System.out.println("1.Transactions History\n2.Withdraw Amount\n3.Deposit Amount\n4.Transfer Amount\n5.View Available Balance\n6.Quit");
                System.out.println("*******************");

                System.out.println("Enter your choice: ");
                int ch = sc.nextInt();
                switch(ch){
                    case 1:op.transactionHistory();
                           break;
                    case 2:op.withdrawAmount();
                           break;
                    case 3:op.depositAmount();
                           break;
                    case 4:op.transferAmount();
                           break;
                    case 5:op.viewBalance();
                           break;
                    case 6:System.out.println("Collect your ATM card");
                           System.exit(0);
                           break;
                    default:
                            System.out.println("Please enter the number in range of 1-6");
                }
            }
        }
        catch(Exception e){
            System.out.println("Invalid!!");
        }
    }
}