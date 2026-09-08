public class Bank
{
    private BankAccount[] accounts;
    private int count;
    // variable to keep track of the number of accounts in the bank along with the array of bank accounts with bank account objects

    public Bank()
    {
        count = 0;
        accounts = new BankAccount[50];
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

    public void sort() {
 for (int i=1; i<accounts.length; i++) {
     //Insert element i in the sorted sub-list
     if(accounts[i] != null){
         

     BankAccount currentVal = accounts[i];
     int j = i;
     while (j>0 && currentVal.getBalance()<(accounts[j - 1].getBalance())){
       // Shift element (j-1) into element (j)
       accounts[j] = accounts[j - 1];
       j--;
 	}
 	// Insert currentVal at position j
 	accounts[j] = currentVal;
   }
}
}

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
            if(accounts[i].getNumber() == number && accounts[i] != null)
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