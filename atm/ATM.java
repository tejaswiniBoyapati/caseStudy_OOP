package exam;

import java.util.Scanner;
import java.io.IOException;

public interface ATM {
	public void pinError()throws IOException;	
	public void optionError()throws IOException;
	public void verifyPin() throws IOException ;
	public void getRequestATM() throws IOException;
		
}
