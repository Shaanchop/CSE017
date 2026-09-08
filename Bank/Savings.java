public class Savings extends BankAccount
{

private double yearlyInterestRate;
// Stores the yearly interest rate for the savings account

public Savings(String owner, double balance, double yInterestRate)
{
    super(owner, balance);
    yearlyInterestRate = yInterestRate;
}
//Savings account constructor extending the BankAccount class
public Savings(long number, String owner, double balance, double yInterestRate)
{
    super(number, owner, balance);
    yearlyInterestRate = yInterestRate;
}
//Savings account constructor extending the BankAccount class

public double getYearlyInterestRate()
{
    return yearlyInterestRate;
}
//Accesor method to get the yearly interest rate of the savings account

public void setYearlyInterestRate(double num)
{
    yearlyInterestRate = num;
}
//mutator method to set the yearly interest rate of the savings account

public double applyMonthlyInterest() 
{
    double monthlyInterestRate = ((yearlyInterestRate/12)/100)*getBalance();
    deposit(monthlyInterestRate);
    return monthlyInterestRate;
}
//Modifies the balance of the savings account by applying monthly interest rate. Monthly interest rate applied is returned

@Override

public String toString() {
    return String.format("%-16s%-16d%-32s$%-15.2f%.2f", 
        "Savings", getNumber(), getOwner(), getBalance(), getYearlyInterestRate());
}
//toString method that returns the proper spaced out string representation of the Savings object based on the test cases

}