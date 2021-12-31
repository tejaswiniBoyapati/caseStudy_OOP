package exam;

import java.util.Scanner;
import java.io.IOException;

public interface ADWM {
	public void pinError()throws IOException;	
	public void optionError()throws IOException;
	public void verifyPin() throws IOException ;
	public void getRequestADWM() throws IOException;
}
