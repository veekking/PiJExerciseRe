import java.util.StringTokenizer;
import java.util.Scanner;
import java.lang.String;
import java.util.NoSuchElementException;
import java.lang.StringBuilder;

public class MailServer_txt {
public static void main(String[] args) {
	System.out.println("Welcome to my mail server");
	Scanner myScan = new Scanner(System.in);
	
	String sender = new String(CommandCheck(myScan, "MAIL FROM"));
	System.out.println("OK");
	
	String receiver = new String(CommandCheck(myScan, "RPCT TO"));
	System.out.println("OK");
	
	String content = new String(CommandCheck(myScan, "DATA"));
	
	System.out.println("Sending Email");
	System.out.println("from: " + sender);
	System.out.println("to: " + receiver);
	System.out.println(content);
	
	System.out.println("...done!");
}

private static String CommandCheck(Scanner scan, String str) {
	String emailStr = new String();
	try {
		StringTokenizer st = new StringTokenizer(scan.nextLine(), ":");
		String cmd = st.nextToken();
		
		// For every command it takes, always check "QUITE" first
		if (cmd.equals("QUIT")) {System.out.println("Bye"); System.exit(0);}
		
		// Comared command input against "MAIL FROM", "RCPT TO", and "DATA"
		while (!cmd.equals(str)) {
			System.out.println("Invalid Command");
			return CommandCheck(scan, str); //If invalid, the function call itself
		}
        
		// if the command is "MAIL FROM" or "RCPT TO", validate the email address and return
		// if the command is "Data", read the input text
		if (!str.equals("DATA")){
			String emailTxt = st.nextToken();
			while (!emailValidation(emailTxt)) {  // Email validate
				System.out.println("Invalid email address");
				scan.next();
				return CommandCheck(scan, str);   //If email address is incorrect, function call itself again
			}
			return emailTxt;
		} else {
			 
			return ReadText(scan);               // Read the input text
		}
	} catch (NoSuchElementException exp ) {
		System.out.println("Invalid Command");
		return CommandCheck(scan,  str);
		
	}
	
}
    private static boolean emailValidation(String mail ) {
        String[] parts = mail.split("@");
        if (parts.length == 2) return true;
        return false;
    }
    
    private static String ReadText(Scanner sc) {
    	StringBuilder rTxt = new StringBuilder();
    	while (sc.hasNext()) {
    		String st = sc.nextLine();
    		if (st.equals(".")) break;
    		rTxt.append(st);
    		rTxt.append(System.lineSeparator());
    	}
    	return rTxt.toString();
    	}
    

}
