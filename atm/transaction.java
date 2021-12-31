package exam;

import java.io.IOException;
import java.util.Scanner;

public class transaction implements ADWM,ATM{
	public float withdraw_cash;
	public float withdraw_limit;
	public float deposit_limit;
	public float total;
	private float deposit_cash;
	private float balance;
	private int[] pin;
	public int request_option;
	
	public transaction() {
		this.balance = (float) 0.0;
		this.withdraw_cash = (float) 0.0;
		this.withdraw_limit = (float) 10000.0;
		this.deposit_limit = (float) 10000.0;
		this.total = (float) 0.0;
		this.deposit_cash = (float) 0.0;
		this.pin[0] = 1234;
		this.pin[1] = 3456;
		this.pin[2] = 5678;
		this.request_option = -1;
	}

	public void setRequestOption(int option) {
		this.request_option=option;
	}
	public void setPin(int pin) {
		this.pin[0] = pin;
	}
	public void setBalance(float balance) {
		this.balance=balance;
	}
	public void setWithdraw_cash(float withdraw_cash) {
		this.withdraw_cash=withdraw_cash;
	}
	public void setWithdraw_limit(float withdraw_limit) {
		this.withdraw_limit=withdraw_limit;
	}
	public void setDeposit_limit(float deposit_limit) {
		this.deposit_limit=deposit_limit;
	}
	public void setTotal(float total) {
		this.total=total;
	}
	public void setDeposit_cash(float deposit_cash) {
		this.deposit_cash=deposit_cash;
	}
	
	public int[] getPin() {
		return this.pin;
	}
	public int getRequestOption() {
		return this.request_option;
	}
	public float getBalance() {
		return this.balance;
	}
	public float getWithdraw_cash() {
		return this.withdraw_cash;
	}
	public float getWithdraw_limit() {
		return this.withdraw_limit;
	}
	public float getDeposit_limit() {
		return this.deposit_limit;
	}
	public float getTotal() {
		return this.total;
	}
	public float getDeposit_cash() {
		return this.deposit_cash;
	}
	
	public void balanceError()throws IOException {
		System.out.println("**********ERROR IN BALANCE CHECK BALANCE**********");
	}
	public void withdraw_cashERROR()throws IOException {
		System.out.println("**********ERROR IN withdraw_cash CHECK withdraw_cash**********");
	}
	public void withdraw_limitERROR()throws IOException {
		System.out.println("**********ERROR IN withdraw_limit CHECK withdraw_limit**********");
	}
	public void deposit_limitERROR()throws IOException {
		System.out.println("**********ERROR IN deposit_limit CHECK deposit_limit**********");
	}
	public void totalERROR()throws IOException {
		System.out.println("**********ERROR IN TOTAL CHECK TOTAL**********");
	}
	public void deposit_cashError()throws IOException {
		System.out.println("**********ERROR IN DEPOSIT CASH CHECK DEPOSIT CASH**********");
	}
	public void pinError()throws IOException {
		System.out.println("**********ERROR IN PIN CHECK PIN**********");
	}
	public void optionError()throws IOException {
		System.out.println("**********ERROR in OPTION CHECK OPTION**********");
	}
	
	public void verifyPin() throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] temp = getPin();
		int pin;
		boolean x=false;
		
		System.out.println("Enter Pin : ");
		pin = sc.nextInt();
		try {
			if (pin == temp[0] || pin == temp[1] || pin == temp[2] ) {
				x= true;
			}
		else {
				x= false;
			}
		}
		catch(Exception e) {
			pinError();
		}
		
		if(x) {
			System.out.println("Correct pin");
		}
		else{
			System.out.println("In-correct pin");
		}
		sc.close();
	}
	public void getRequestATM() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------Enter your option----------------------\n1.Check Balance\n2.WithDraw Cash\nEnter your option here : ");
		int option=-1;
		try {
			option = sc.nextInt();
			
			}
		catch(Exception e) {
			this.optionError();
		}	
		
		try {
			setRequestOption(option);
			}
		catch(Exception e) {
			this.optionError();		
		}
		sc.close();
	}
	public void getRequestADWM() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------Enter your option----------------------\n1.Check Balance\n2.Withdraw Cash\n3.Deposit Cash\nEnter your option here : ");
		int option=-1;
		try {
			option = sc.nextInt();
			
			}
		catch(Exception e) {
			this.optionError();
		}	
		
		try {
			setRequestOption(option);
			}
		catch(Exception e) {
			this.optionError();		
		}
		sc.close();
	}
	public float withdraw()throws IOException {
		Scanner sc = new Scanner(System.in);
		float bal ;
		float tot=(float) 0.0;
		float withdrawCash;
		
		try {
			bal = getBalance();
		}
		catch(Exception e ) {
			balanceError();
		}
		
		try {
			withdrawCash = sc.nextFloat();
			if(withdrawCash <= getWithdraw_limit()) {
				if(withdrawCash <= getBalance()) {
					setWithdraw_cash(withdrawCash);
				}
				else {
					System.out.println("Withdraw cash exceeded account balance.");
				}
			}
			else {
				System.out.println("Withdraw cash limit exceeded.");
			}
		}
		catch(Exception e ) {
			
		}
		sc.close();
		return tot;
	}
	
	public float deposit()throws IOException {
		Scanner sc = new Scanner(System.in);
		float bal ;
		float tot = (float) 0.0;
		float depositCash;
		
		try {
			bal = getBalance();
			setBalance(bal);
		}
		catch(Exception e ) {
			balanceError();
		}
		
		try {
			System.out.println("Enter amount you want to deposit : ");
			depositCash = sc.nextFloat();
			if(depositCash <= getDeposit_limit() ) {setDeposit_cash(depositCash);}
			else {
				System.out.println("Deposit cash limit exceeded.");
			}
			
		}
		catch(Exception e ) {
			deposit_cashError();
		}
		tot = getDeposit_cash();
		bal = getBalance() + getDeposit_cash();
		
		sc.close();
		return tot;
	}
	
	public void transaction() throws IOException {
		
		int option =  getRequestOption();
		float trans;
		if(option == 1) {
			System.out.println("Current balance : "+ Float.toString(getBalance()));
		}
		
		else if(option == 2) {
			trans=withdraw();
			if(trans != 0.0) {System.out.println(Float.toString(trans)+ " has been deposited.");}
			else{System.out.println(Float.toString(trans)+ " Some error in transaction.");}
		}
		else if(option == 3) {
			trans=deposit();
			if(trans != 0.0) {System.out.println(Float.toString(trans)+ " has been withdrawn.");}
			else{System.out.println(Float.toString(trans)+ " Some error in transaction.");}
		}
		else if( option == -1) {
			System.out.println("No option was selected");
		}
		else {
			System.out.println("INVAILD option was selected");
		}
	
	}
	
}
