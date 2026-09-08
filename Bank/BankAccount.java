public class BankAccount
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

public BankAccount(long n,String o, double b) // Variables arguments are one letter
{
    number = n;
    owner = o;
    balance = b;
}
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

public boolean withdraw(double amount)
{
    if(amount < balance)
    {
        balance = balance - amount;
        return true;
    }
    else
    {
        return false;
    }
}
//accesor method to withdraw an amount from an account

public String toString(){
   return String.format("%-10d\t%-30s\t$%-10.2f",
                         number, owner, balance);
}
//toString method that returns the proper spaced out string representation of the BankAccount object based on the test cases

}