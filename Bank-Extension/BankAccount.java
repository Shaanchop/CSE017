public class BankAccount implements Closeable, Comparable<BankAccount>
{



private long number;
// Stores account number
private String owner;
// Stores account owner name
private double balance;
// Stores account balance
private static long nextNumber = 1111111111L;
// Static variable to keep track of the next 10-digit account number to be assigned


public BankAccount(String o, double b)
{
    owner = o;
    balance = b;
    number = nextNumber++;
}
//Initalizes a BankAccount object


public BankAccount(long n,String o, double b) throws BadFormatException // Variables arguments are one letter
{
    String str = Long.toString(n);
if (!str.matches("\\d{10}")) {
        throw new BadFormatException("Invalid account number ( " + n + " ), must have 10 digits");
    }

    number = n;
    owner = o;
    balance = b;
    


}
// a bank account constructor that throws a badformat exception if the account number does NOT have 10 digits

@Override 
public boolean isCloseable() 
{
    return this.balance <= 100.0;
}
// checks if the account is closeable based on if the balance is less than or equal to 100 dollars

//Initalizes a BankAccount object

public long getNumber()
{
    return number;
}
// returns the account number
public String getOwner()
{ 
    return owner;

}
// returns the account owner name
public double getBalance() 
{ 
    
    return balance; 


}
// returns the balance of the account


public void setNumber(long n)
{
    n = number;
}
// mutator method to set the account number
public void setOwner(String newO)
{
    newO = owner;
}
//mutator method to set the account owner name

public void deposit(double amount)
{

    balance+=amount;

}
//mutator method to deposit an amount into the account

public String fileString()
{
    return getNumber() + "," + getOwner() + "," + getBalance();
}
// file string method that returns information about the bankAccount, later to be implemented into the save method

public boolean withdraw(double amount) throws IllegalTransactionException, NullPointerException
{
    if(amount < balance)
    {
        balance = balance - amount;
        return true;
    }
    else
    {
        throw new IllegalTransactionException("Amount exceeds account balance");
    }
}
//accesor method to withdraw an amount from an account
@Override 
public int compareTo(BankAccount ba)
{
    return Double.compare(ba.getBalance(), balance);
}

public String toString(){
   return String.format("%-10d\t%-30s\t$%-10.2f",
                         number, owner, balance);
}
//toString method that returns the proper spaced out string representation of the BankAccount object based on the test cases

}