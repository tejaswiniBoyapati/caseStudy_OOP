package exam;

public class testBankTransfer {

	public static void main(String[] args) {
		accounts a = new accounts("ABCD123","Savings account","544332212",(float)45000.20);
		accounts b = new accounts("EFGH567","Savings account","632451157",(float)56000.30);
		
		end_banking_system c = new end_banking_system();
		
		c.bankTransfer(a, b);
	}

}
