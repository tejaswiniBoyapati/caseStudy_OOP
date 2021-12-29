package exam;

import java.util.Scanner;
import java.io.IOException;

public class ADWM {
	private int[] pin;
	public int request_option;
	
	public ADWM() {
		this.pin[0] = 1234;
		this.pin[1] = 3456;
		this.pin[2] = 5678;
		this.request_option = -1;
	}
	
	public int[] getPin() {
		return this.pin;
	}
	public int getRequestOption() {
		return this.request_option;
	}
	
	public void setRequestOption(int option) {
		this.request_option=option;
	}
	public void setPin(int pin) {
		this.pin[0] = pin;
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

	public void getRequest() throws IOException {
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
}
