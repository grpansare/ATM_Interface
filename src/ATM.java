

import java.util.Currency;
import java.util.Scanner;

public class ATM {
    int pin;
    double balance;
    Scanner sc=new Scanner(System.in);
    public int withdraw(UserAccount u,double amount){
        balance=u.getBalance();
        if(balance<amount) return 0;
        balance-=amount;
        u.setBalance(balance);
        return 1;
    }
    public void deposit(UserAccount u1,double amount){
        balance= u1.getBalance();
        balance+=amount;
        u1.setBalance(balance);

    }
    public double getBalance(UserAccount u1){
        balance=u1.getBalance();
        return  balance;
    }
    public boolean authenticate(UserAccount u1,int pin){
        if (pin != u1.getPin()) {
            System.out.println("Pin is not correct");
            System.out.println("enter your pin again");
            pin=sc.nextInt();
            authenticate(u1,pin);

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Currency cur = Currency.getInstance("USD");
        // Get and print the symbol of the currency
        String symbol = cur.getSymbol();

        UserAccount u1 = new UserAccount();
        ATM atm;
        System.out.println("Welcome to the ATM !!");
        System.out.println("Set your pin");
        int pin = sc.nextInt();
        boolean bool=true;
        boolean auth=false;
        u1.setPin(pin);
        System.out.println("pin is successfully set.");
        System.out.println("enter your pin");

        pin = sc.nextInt();
        atm = new ATM();
        boolean authenticate = atm.authenticate(u1, pin);
        if (authenticate) {

            while (bool) {
                System.out.println("-------------------------------------------------------");
                System.out.println("what do you want to do?");
                System.out.println("1.Withdraw\n2.Deposit\n3.Check balance\n4.Exit");
                System.out.println("Choose one of the options above");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("enter amount to withdraw:"+symbol);
                        double amount = sc.nextDouble();
                        int result = atm.withdraw(u1, amount);
                        if (result == 0) {
                            System.out.println("balance is not sufficiant");
                            break;
                        }
                        System.out.println("The Amount "+symbol+" "+amount+" withdrawn successfully");

                        break;

                    case 2:
                        System.out.print("enter amount to be deposited:"+symbol);

                        amount = sc.nextDouble();
                        atm.deposit(u1, amount);
                        System.out.println("the amount "+symbol+""+amount+" deposited successfully");

                        break;
                    case 3:

                        double balance = atm.getBalance(u1);
                        System.out.println("your balance:"+symbol+" " + balance);

                        break;
                    case 4:
//                        System.exit(0);
                        System.out.println("Thank You");
                        bool = false;
                        break;
                }

            }
        }


    }
}

