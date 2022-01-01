package exam;

import java.io.IOException;
import java.util.Scanner;

public class end_banking_system  {
	boolean transSuccess;
	boolean sufficientFunds;
	
	end_banking_system(){
		this.sufficientFunds=false;
		this.transSuccess=false;
	}
	
	public void setSufficientFunds(boolean status) {this.sufficientFunds=status;}
	public void setTransSuccess(boolean status) {this.transSuccess=status;}
	
	public boolean getSufficientFunds() {return this.sufficientFunds;}
	public boolean getTransSuccess() {return this.transSuccess;}
	
	public boolean checkIFSC( String verify, accounts reciever) {
		
		if(reciever.IFSC.equals(verify)) {return true;}
		else {return false;}
	}
	
	public void amountToTransfer(accounts sender) {
		Scanner s = new Scanner(System.in);
		float x=(float)1000.0;
		System.out.print("Enter money to transfer : 1000.0 ");
		
		System.out.print("\n");
		
		sender.setTransAmount(x);
		s.close();
		
	}
	
	public void transfer(accounts sender, accounts reciever) {
		sender.setBalance(sender.balance-sender.transAmount);
		reciever.setTransAmount(sender.transAmount);
		reciever.setBalance(reciever.balance+reciever.transAmount);
	}
	
	public void moneytransfer(accounts sender,accounts reciever) {
		boolean status = getTransSuccess();
		boolean funds = getSufficientFunds();
		
		funds =  reciever.checkBalanceForMinBal(sender.balance);
		
		if(funds) {
			System.out.print("Suffient funds available\n");
			amountToTransfer(sender);
			transfer(sender,reciever);
			status=true;
		}
		else{
			status=false;
		}
		
		if(status) {
			System.out.println("Transaction succesful");
		}
		else {
			System.out.println("Transaction terminated");
		}
		setSufficientFunds(funds);
		setTransSuccess(status);

		
	}
	
	public void bankTransfer(accounts sender, accounts reciever) {
		 String IFSC;
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("Enter the IFSC of benificiary : ");
		 IFSC=sc.next();
		 
		 System.out.print("\n");
		 
		 if(checkIFSC(IFSC,reciever)) {
			 sender.getBenificiary();
			 moneytransfer(reciever,sender);
			 sc.close();
		 }
		 else {
			 System.out.println("The IFSC of benificiary not matched");
			 sc.close();
		 }
		
		 
	}
	
}
