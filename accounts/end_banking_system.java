package exam;

import java.io.IOException;
import java.util.Scanner;

public class end_banking_system implements sender,benificiary{
	String IFSC;
	String IFSC1;
	String sender_accountNum;
	String sender_accountDetails;
	String benificiary_accountNum;
	String benificiary_accountDetails;
	public end_banking_system() {
		this.IFSC="IDIB10000001";
		this.IFSC1="IDIB10000002";
		this.benificiary_accountDetails="Indian Bank - Vellore";
		this.benificiary_accountNum="33345663453";
		this.sender_accountNum="53545963453";
		this.sender_accountDetails="ICICI Bank - Chennai";
	}
	public String getIFSC() {return this.IFSC;}
	public String getIFSC1() {return this.IFSC1;}
	public String getsender_accountNum(){return this.sender_accountNum;}
	public String getsender_accountDetails(){return this.sender_accountDetails;}
	public String getbenificiary_accountNum(){return this.benificiary_accountNum;}
	public String getbenificiary_accountDetails(){return this.benificiary_accountDetails;}
	
	public void setIFSC(String IFCS){this.IFSC=IFSC;}
	public void setIFSC1(String IFCS){this.IFSC1=IFSC;}
	public void setsender_accountNum(String accNum){this.sender_accountNum=accNum;}
	public void setsender_accountDetails(String accDetails){this.sender_accountDetails=accDetails;}
	public void setbenificiary_accountNum(String accNum){this.benificiary_accountNum=accNum;}
	public void setbenificiary_accountDetails(String accDetails){this.benificiary_accountDetails=accDetails;}
	
	public void sender_accountNumber() {}
	public void sender_accountDetails() {}
	public void benificiary_accountNumber() {}
	public void benificiary_accountDetails() {}
	public void IFSC_code() {}
	public void bankAccount() {}
	public void onlinePortal() {}
	public void authorities() {}

}
