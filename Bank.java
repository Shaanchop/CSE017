import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Bank
{
    private BankAccount[] accounts;
    private BankAccount[] closed;
    private int count;
    private int closedCount;
    // variable to keep track of the number of accounts in the bank along with the array of bank accounts with bank account objects

    public Bank()
    {
        count = 0;
        closedCount = 0;
        accounts = new BankAccount[50];
        closed = new BankAccount[50];
    }
    // Constructor to initialize the bank with an empty array of bank accounts and set the count to 0
    public Bank(String filenameString)
    {
        count = 0;
        closedCount = 0;
        accounts = new BankAccount[50];
        closed = new BankAccount[50];
        read(filenameString);
    }
    // Constructor to initialize the bank with an empty array of bank accounts and set the count to 0

    public void add(BankAccount ba)
    {
        if(count < accounts.length && ba != null)
            {
                accounts[count] = ba;
                count++;
            }
            
        
        }
    //Add a new account to the bank after initalizing the bank account object. The account is added to the next available index

private void read(String filename) {
        File file = new File(filename);
        try (Scanner newScanner = new Scanner(file)) {
            while(newScanner.hasNextLine()) {
                String line = newScanner.nextLine().trim();
                if(line.isEmpty()) continue;
                
                String[] tokens = line.split(",");
                String accountType = tokens[0];
                
                try {
                    long number = Long.parseLong(tokens[1]);
                    String name = tokens[2];
                    double balance = Double.parseDouble(tokens[3]);
                    
                    // Check if the last token is "closed"
                    boolean isClosed = tokens[tokens.length - 1].equalsIgnoreCase("closed");
                    BankAccount ba = null;

                    if(accountType.equalsIgnoreCase("Checking")) {
                        ba = new Checking(number, name, balance);
                    } else if(accountType.equalsIgnoreCase("Savings")) {
                        ba = new Savings(number, name, balance, Double.parseDouble(tokens[4]));
                    } else if (accountType.equalsIgnoreCase("Investment")) {
                        ba = new Investment(number, name, balance, tokens[4]);
                    }

                    if (ba != null) {
                        if (isClosed) {
                            addClosed(ba);
                        } else {
                            add(ba);
                        }
                    }
                } catch(BadFormatException e) {
                    System.out.println("Bad format exception: " + e.getMessage());
                } catch(Exception e) {
                    System.out.println("Error parsing account line: " + line);
                }
                // catch the badformat exception and print the error message to the console. also catch other general exceptinos after that
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    // Method to read bank account data from a file. It reads each line, splits it into tokens, and creates the appropriate BankAccount object based on the account type.
    // If the last token is "closed", the account is added to the closed accounts array; otherwise, it is added to the active accounts array.
    public void save(String filename)
    {
        File file = new File(filename);


        
        try(PrintWriter p1 = new PrintWriter(file);) {
            
            for(int i = 0; i < count; i++)
            {
                if(accounts[i] != null) {
                    String text = accounts[i].fileString();
                    p1.println(text);
                }
            }
            for(int i = 0; i < closedCount; i++) {
                if (closed[i] != null) {
                    p1.println(closed[i].fileString() + ",closed");
                }
            }
        }
         catch (FileNotFoundException e) {
            System.out.println("Error, file not found");
        }
    


        
    }
    // method to save bank account data to a file


    public int closedSize()
    {
        return closedCount;
    }

    private void addClosed(BankAccount ba)
    {
        if(closedCount < closed.length && ba != null)
        {
            closed[closedCount++] = ba;
        }
    }
    // method to add a closed account to the closed array

    public void updateSavings()
    {
        int c =0;
    for(int i = 0; i < count; i++){
        {
            if(accounts[i] instanceof Savings && accounts[i] != null) 
            {
                ((Savings) accounts[i]).applyMonthlyInterest();
                c++;
            }
        }    

    }
    System.out.println(c + " Savings accounts updated");
}
// method to update all savings accounts by applying monthly interest
    public void updateInvestment(double risk)
    {
        int c=0;
        for(int i = 0; i < count; i++)
        {
            if(accounts[i] instanceof Investment)
            {
                 ((Investment) accounts[i]).getProfitOrLoss(risk);
                 c++;
            }
        }
        System.out.println(c + " Investment accounts were updated");
}
// method to update all investment account by applying the profitorloss method based ont he risk parameter

    public void viewChecking()
    {
        int c = 0;
        for(int i = 0; i < count; i++)
        {
            if(accounts[i] instanceof Checking)
            {
                System.out.println(accounts[i]);
                c++;
            }
        }
        System.out.println("There are " + c + " Checking accounts");
    }
    // method to view and COUNT all checking accounts in the bank


    public void viewSavings()
    {
        int c = 0;
        for(int i = 0; i < count; i++)
        {
            if(accounts[i] instanceof Savings)
            {
                System.out.println(accounts[i]);
                c++;
            }
        }
        System.out.println("There are " + c + " Savings accounts");
    }
    // method to view and COUNT all savings accounts in the bank

    public void viewInvestment()
    {
        int c = 0;
        for(int i = 0; i < count; i++)
        {
            if(accounts[i] instanceof Investment)
            {
                System.out.println(accounts[i]);
                c++;
            }
        }
        System.out.println("There are " + c + " Investment accounts");
    }
    // method to view and COUNT all investment accounts in the bank

    public void viewClosed()
    {
        for(int i = 0; i < closedCount; i++)
        {
            if(closed[i] != null)
            {
                System.out.println(closed[i]);
            }
        }
    }
    // method to view all closed accounts in the bank

    public void viewCloseable()
    {
        int c = 0;
    for(int i = 0; i < count; i++)
    {
        if(accounts[i].isCloseable() == true)
        {
            c++;
        }
    }
    System.out.println(c + " accounts are closeable");

    }
    // method to view and COUNT all closeable accounts in the bank 

    public void sort() {
        Arrays.sort(accounts, 0, count);
}
// overloaded sort method sorts the accounts array based on the natural ordering defined in the BankAccount class (by account number). It uses the Arrays.sort method to sort only the portion of the array that contains active accounts (from index 0 to count).

    public int size()
    {
        return count;
    }
    //accessor method to return the number of accounts in the bank

    public BankAccount find(long number)
    {
        // Loop through the accounts array to find the account with the given number
        for(int i = 0; i < count; i++)
        {
            if(accounts[i].getNumber() == number)
            {
                return accounts[i];
            }
        }
        // If the account is not found, return null
        return null;
    }

    public BankAccount remove(long number)
    {
        for(int i = 0; i < count; i++)
        {
            if(accounts[i].getNumber() == number)
            {
                BankAccount removed = accounts[i];
                for(int j = i; j < count-1; j++)
                {
                    accounts[j] = accounts[j+1];
                }
                accounts[count-1] = null;
                count--;
                return removed;
            }
        }
        return null;
    }
    //removes an account from the bank based on the account number. If account found, it is removed from the array and the count is decremented. The removed account is returned. If the account is not found, null is returned.
    public void closeAccounts()
    {
        int c = 0;

        while(c < count)
        {
            if(accounts[c].isCloseable() && accounts[c] != null)
            {
                addClosed(accounts[c]);
                accounts[c] = accounts[count-1];
                accounts[count-1] = null;
                count--;
                
                
            }
            else
            {
                c++;
            }
        }

        System.out.println(closedCount + " accounts were closed");
    }
    // closes a bank account by adding it to the closed array.
    // the account is set equal to the value of the last account in the acccounts array to ensure the last account in the array is not lost
    // the last account in the array is then set to null and the count is decremented
    //if the account is not closeable, variable c is incremented and we check the next account in the bank account array

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    // Add the header row to match output.reference
    sb.append(String.format("%-16s%-16s%-32s%-16s%s\n", 
        "Type", "Number", "Owner", "Balance", "Interest/Type"));
        
    // Append each account on a new line
    for (int i = 0; i < count; i++) {
        sb.append(accounts[i].toString()).append("\n");
    }
    return sb.toString();
}
//toString method that returns the proper spaced out string representation of the Bank object based on the test cases



}