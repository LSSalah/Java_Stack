import java.util.Random;

public class BankAccount {
	private String accountNumber = "";
	private Double balance = 0.0;
	private Double savings= 0.0;
	public static int numberOfAccounts = 0;
	public static Double totalAmount = 0.0;
	
	public BankAccount() {
		String accountNumber = newAccountNumber();
		Double balance = 0.0;
		Double savings = 0.0;
        numberOfAccounts++;
        System.out.println("New user created with account number: " + accountNumber + ".");
		System.out.println("Total accounts created: " + numberOfAccounts + ".");		
    }
	
//	Getters
	public static int accountCount() {
        return numberOfAccounts;
		
	}
	
	public Double totalAmount() {
		Double totalAmount = balance + savings;
		System.out.println(totalAmount);
        return totalAmount;
    }
	
	public Double getBalance() {
		return balance;
	}
	
	public Double getSavings() {
		return savings;
	}
	
//	Setters
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setSavings(Double savings) {
		this.savings = savings;
	}
	
//	Methods
	private String newAccountNumber() {
		String numberTable = "0123456789";
		String randomNumber = "";
		
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++) {
			char num = numberTable.charAt(rand.nextInt(10));
			randomNumber += num;
		}
		accountNumber = randomNumber;
		return randomNumber;	
	}
	
	public void accountDeposit(String type, Double depositAmount) {
		if(type == "checking" || type == "Checking") {
			setBalance(getBalance() + depositAmount);
			totalAmount += depositAmount;
		}
		if(type == "savings" || type == "Savings") {
			setSavings(getSavings() + depositAmount);
			totalAmount += depositAmount;
		}
		else {
			System.out.println("Please choose an account type.");
		}	
	}
	
	public void accountWithdrawal(String type, Double withdrawalAmount) {
		if(type == "checking" || type == "Checking") {
			if(getBalance() < withdrawalAmount) {
				System.out.println("Insufficient Funds!");
			}
			else {
			setBalance(getBalance() - withdrawalAmount);
			totalAmount -= withdrawalAmount;
			}
		}
		if(type == "savings" || type == "Savings") {
			if(getSavings() < withdrawalAmount) {
				System.out.println("Insufficient Funds!");
			}
			else {
			setSavings(getSavings() - withdrawalAmount);
			totalAmount -= withdrawalAmount;
			}
		}
	}
	
	
}
