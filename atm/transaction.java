package exam;

import java.io.IOException;
import java.util.Scanner;

public class transaction extends ADWM{
	public float withdraw_cash;
	public float withdraw_limit;
	public float deposit_limit;
	public float total;
	private float deposit_cash;
	private float balance;
	
	public transaction() {
		this.balance = (float) 0.0;
		this.withdraw_cash = (float) 0.0;
		this.withdraw_limit = (float) 10000.0;
		this.deposit_limit = (float) 10000.0;
		this.total = (float) 0.0;
		this.deposit_cash = (float) 0.0;
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
