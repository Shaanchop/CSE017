public class Checking extends BankAccount {
    
    public Checking(String owner, double balance) 
    {
        super(owner, balance);
    }
    //Checking account constructor extending the BankAccount class

    public Checking(long number, String owner, double balance) throws BadFormatException
    {


        super(number, owner, balance);

        
    }
    //Overloaded Checking account constructor extending the BankAccount class now includes throwable exception for badFormat


@Override
    public String fileString() {
        return "Checking," + getNumber() + "," + getOwner() + "," + getBalance();
    }
    // file string method that returns information about the bankAccount, later to be implemented into the save method

    @Override
    public String toString() 
    {
        return String.format("%-16s%-16d%-32s$%-15.2f", 
        "Checking", getNumber(), getOwner(), getBalance());
    }
    //toString method that returns the proper spaced out string representation of the Checking object based on the test cases
}