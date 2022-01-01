package exam;
import java.io.IOException;
import java.util.Scanner;

public class accounts{
	String IFSC;
	String accountNum;
	String accountDetails;
	float balance;
	float minBalance;
	float transAmount;
	String benificiaryAccIFSC;
	String benificiaryAccNum;
	String benificiaryAccountDetails;
	boolean accStatus; 
	
	public accounts() {
		this.IFSC="";
		this.accountDetails="";
		this.accountNum="";
		this.balance=(float) 0.0;
		this.minBalance=(float) 1000.0;
		this.transAmount=(float) 0.0;
		this.benificiaryAccIFSC="";
		this.benificiaryAccNum="";
		this.benificiaryAccountDetails="";
		this.accStatus=true;
	}
	
	public accounts(String IFSC,String accDetails,String accNum,float bal) {
		this.IFSC=IFSC;
		this.accountDetails=accDetails;
		this.accountNum=accNum;
		this.balance=(float) bal;
		this.minBalance=(float) 1000.0;
		this.transAmount=(float) 0.0;
		this.benificiaryAccIFSC="";
		this.benificiaryAccNum="";
		this.benificiaryAccountDetails="";
		this.accStatus=true;
	}
	
	public String getIFSC() {return this.IFSC;}
	public String getAccDetails() {return this.accountDetails;}
	public String getAccNum() {return this.accountNum;}
	public float getBalance() {return this.balance;}
	public float getMinBalance() {return this.minBalance;}
	public float getTransAmount() {return this.transAmount;}
	public String getBenificiaryIFSC() {return this.benificiaryAccIFSC;}
	public String getBenificiaryAccDetails() {return this.accountDetails;}
	public String getBenificiaryAccNum() {return this.benificiaryAccNum;}
	public boolean getAccStatus() {return this.accStatus;}
	
	public void setBalance(float bal) {this.balance=bal;}
	public void setMinBalance(float minBal) {this.minBalance=minBal;}
	public void setTransAmount(float transAmount) {this.transAmount=transAmount;}
	public void setIFSC(String IFSC) {this.IFSC=IFSC;}
	public void setAccDetails(String accDetails ) {this.accountDetails=accDetails;}
	public void setAccNum(String accNum) {this.accountNum=accNum;}
	public void setBenificiaryIFSC(String IFSC) { this.benificiaryAccIFSC=IFSC;}
	public void setBenificiaryAccDetails(String accDetails ) { this.accountDetails=accDetails;}
	public void setBenificiaryAccNum(String accNum) { this.benificiaryAccNum=accNum;}
	public void setAccStatus(boolean status) {this.accStatus=status;}
	
	public void getBenificiary() {
		String IFSC="";
		String accNum="";
		String accDetails="";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the IFSC of benificiary : ");
		IFSC=sc.next();
		System.out.println();
		
		System.out.print("Enter the account number of benificiary : ");
		accNum=sc.next();
		System.out.println();
		
		System.out.print("Enter the account details of benificiary : ");
		accDetails=sc.next();
		System.out.println();
		
		setBenificiaryIFSC(IFSC);
		setBenificiaryAccDetails(accDetails);
		setBenificiaryAccNum(accNum);
		sc.close();
	}
	
	public void deposit() {
		float money=(float) 0.0;
		float bal=getBalance();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the ammount to deposit: ");
		money=sc.nextFloat();
		System.out.println();
		
		setBalance(bal+money);
		sc.close();
	}
	
	public boolean checkBalanceForMinBal(float bal) {
		boolean status;
		if(bal>= getMinBalance()) {
			status = true;
		}
		else {
			status =false;
		}
		return status;
	}
	
	public void withDraw() {
		float money=(float) 0.0;
		float bal=getBalance();
	    Scanner sc = new Scanner(System.in);
		
		if(checkBalanceForMinBal(bal)) {
			System.out.print("Enter the ammount to withdraw: ");
			money=sc.nextFloat();
			
			System.out.println();
			
			setBalance(bal-money);
			System.out.println("Amount withdrawn "+Float.toString(money));		
		}
		else {
			System.out.println("Not suffinient account balance please deposit cash.");	
		}
		sc.close();
	}
}
