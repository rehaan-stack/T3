import java.util.*;
import java.lang.*;

class Man {
    double balance = 500000.00;
    double withdraw;
    double deposit;
    Scanner sc = new Scanner(System.in);
    Userbank ub = new Userbank();
    ATMmachine at = new ATMmachine(ub);

    Man() {
        options();
    }

    void options() {
        while (true) {
            System.out.println("Welcome to ATM Machine :- ");
            System.out.println("Enter 1 for Withdraw");
            System.out.println("Enter 2 for Deposit");
            System.out.println("Enter 3 for Check Balance");
            System.out.println("Enter 4 for Exit");
            switch_case();
        }

    }

    void switch_case() {
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op) {
            case 1:
                System.out.println("Enter Amount to Withdraw :");
                withdraw = sc.nextDouble();
                at.withdraw_fuc(balance, withdraw);
                break;

            case 2:
                System.out.println("Enter Amount to deposit :");
                deposit = sc.nextDouble();
                at.deposit_fuc(balance, deposit);
                break;

            case 3:
                at.check_fuc(balance);
                break;

            case 4:
                System.out.println("Thankyou .....");
                System.exit(0);
        }

    }

    public static void main(String[] args) {
        Man mn = new Man();
    }
}

class Userbank {
    double withdraw_user(double balan, double wiraw) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdrawn Operation is performed ");
        System.out.println("The withdrawing amount is " + wiraw);
        if (balan >= wiraw) {
            balan -= wiraw;
            System.out.println("Do you Want To Check Your Current Balance [yes/no]:");
            String opt = sc.next();
            while (opt.equalsIgnoreCase("yes")) {
                balance_user(balan);
                break;
            }
            System.out.println("Your Transaction For Withdrawing Money is Successfully Done.");
            System.out.println("ThankYou For Visiting.....");
        } else {
            System.out.println("sorry insufficient balance ");
            System.out.println("Your Transaction is Got Failure");
            System.out.println();
        }
        return balan;
    }

    double deposit_user(double balace, double desit) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deposit Operation is performed ");
        System.out.println("The Depositing amount is " + desit);
        balace += desit;
        System.out.println("Do you Want To Check Your Current Balance [yes/no]:");
        String opth = sc.next();
        while (opth.equalsIgnoreCase("yes")) {
            balance_user(balace);
            break;
        }
        System.out.println("Your Transaction for Money Deposit is  Successfully Done.");
        System.out.println("ThankYou For Visiting.....");
        return balace;
    }

    void balance_user(double bal) {
        System.out.println("The Current Balance is " + bal);
    }
}

class ATMmachine {
    private Userbank ub;

    public ATMmachine(Userbank ub) {
        this.ub = ub;
    }

    public void withdraw_fuc(double bal, double with) {
        ub.withdraw_user(bal, with);
    }

    public void deposit_fuc(double am, double dep) {
        ub.deposit_user(am, dep);
    }

    public void check_fuc(double ba) {
        ub.balance_user(ba);
    }
}