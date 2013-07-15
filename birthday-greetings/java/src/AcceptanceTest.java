import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcceptanceTest {

	private static final String EMPLOYEE_DATA_FILE = "./employee_data.txt";
	private static final int SMTP_PORT = 25;
	private List<Message> messagesSent;
	private BirthdayService service;
	
	@Before
	public void setUp() throws Exception {
		createDataFile();
		messagesSent = new ArrayList<Message>();

		service = new BirthdayService() {			
			@Override
			protected void sendMessage(Message msg) throws MessagingException {
				messagesSent.add(msg);
			}
		};
	}
	
	private void createDataFile() throws FileNotFoundException, UnsupportedEncodingException {
		File f = new File(EMPLOYEE_DATA_FILE);
		if (f.canRead()) return;
		PrintWriter writer = new PrintWriter(f, "UTF-8");
		writer.println("last_name, first_name, date_of_birth, email");
		writer.println("Doe, John, 1982/10/08, john.doe@foobar.com");
		writer.println("Ann, Mary, 1975/03/11, mary.ann@foobar.com");
		writer.close();
	}

	@Test
	public void baseScenario() throws Exception {
		service.sendGreetings(EMPLOYEE_DATA_FILE, new OurDate("2008/10/08"), "localhost", SMTP_PORT);
		
		assertEquals("message not sent?", 1, messagesSent.size());
		Message message = messagesSent.get(0);
		assertEquals("Happy Birthday, dear John!", message.getContent());
		assertEquals("Happy Birthday!", message.getSubject());
		assertEquals(1, message.getAllRecipients().length);		
		assertEquals("john.doe@foobar.com", message.getAllRecipients()[0].toString());		
	}
	
	@Test
	public void willNotSendEmailsWhenNobodysBirthday() throws Exception {		
		service.sendGreetings(EMPLOYEE_DATA_FILE, new OurDate("2008/01/01"), "localhost", SMTP_PORT);
		
		assertEquals("what? messages?", 0, messagesSent.size());
	}
}
