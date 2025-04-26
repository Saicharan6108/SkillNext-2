
import java.util.Scanner;

class Customer
{
    // this is a bank account

    private int accountno;
    public String name;
    private float Balance;
    public Customer(int accountno,String name) {
        this.accountno=accountno;
        this.name=name;
        this.Balance=0.0f;
    }

    void deposit(float amount)
    {
        this.Balance+=amount;
    }

    void withdraw(float amount)
    {
        if(this.Balance>amount) this.Balance-=amount;
        else System.out.println("insufficient balance");
    }

    void checkBalance()
    {
        System.out.println("Balance of "+this.accountno+": "+this.Balance);
    }
    
}



public class c2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("enter accno and name: ");
        int acc=sc.nextInt();
        String n=sc.next();
        Customer c=new Customer(acc,n);
        boolean exit=false;
        while(!exit)
        {
            System.out.print("deposit or withdraw or check or exit: ");
            String command=sc.next();
            switch(command) {
                case "deposit":
                    c.deposit(sc.nextFloat());
                    System.out.println("deposited");
                    break;
                case "withdraw":
                    c.withdraw(sc.nextFloat());
                    break;
                case "check":
                    c.checkBalance();
                    break;
                case "exit":
                    exit=true;
                    break;
            }
        }

        


    }
}
