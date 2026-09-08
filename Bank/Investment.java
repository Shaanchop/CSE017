public class Investment extends BankAccount
{
    
    private String type;
    // Stores the type of investment account

    public Investment(String owner, double balance, String t)
    {
        super(owner, balance);
        type = t; // MUST be either "Property" "Growth" or "Shares"
    }
    public Investment(long number, String owner, double balance, String t)
    {
        super(number, owner, balance);
        type = t;
    }
    //Investment account constructor extending the BankAccount class

    public String getType()
    {
        return type;
    }
    //Accessor method to get the type of investment account

    public void setType(String t)
    {
        type = t;
    }
    //Mutator method to set the type of investment account

    public double getProfitOrLoss(double risk)
    {
        double result = 0.0;
        if(risk >= 0.5)
        {
            result = getBalance()*0.05;
            deposit(result);
            return result;
        }
        else
        {
            result = getBalance()*0.02;
            withdraw(result);
            return -result;
        }
    }
    //Method that calculaes profit or loss based on the risk

    @Override

    public String toString()
    {
        return String.format("%-16s%-16d%-32s$%-15.2f%s", 
        "Investment", getNumber(), getOwner(), getBalance(), getType());
    }
    //toString method that returns the proper spaced out string representation of the Investment object based on the test cases


}