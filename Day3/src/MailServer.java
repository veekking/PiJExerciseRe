import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import java.lang.String;


public class MailServer {
	public static void main(String[] args) {
		  Socket smtpSocket = null ;
		  DataOutputStream os = null;
		  DataInputStream is = null;
		 
		 String m_sHostName = new String("ffeng");
		 int m_iPort = 25;
		
		Date dDate = new Date();
		//DateFormat dFormat = DateFormat.getDateInstance(DateFormat.Full);
		try
		{ // Open port to server
		  smtpSocket = new Socket(m_sHostName, m_iPort);
		  os = new DataOutputStream(smtpSocket.getOutputStream());
		  is = new DataInputStream(smtpSocket.getInputStream());
		            
		  if(smtpSocket != null && os != null && is != null)
		  { // Connection was made.  Socket is ready for use.
		   System.out.println("Connection has build");
		  }
		}
		catch(Exception e)
		{ System.out.println("Host " + m_sHostName + "unknown"); }
	}

}
//http://www.developerfusion.com/code/1975/sending-email-using-smtp-and-java/