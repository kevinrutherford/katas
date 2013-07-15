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
		writer.println("last_name, first_name, date_of_birth, email, anniversary");
		writer.println("Doe, John, 1982/10/08, john.doe@foobar.com, 2009/07/01");
		writer.println("Ann, Mary, 1975/03/11, mary.ann@foobar.com, 2009/08/01");
		writer.close();
	}

	@Test
	public void sendsMessageForBirthdays() throws Exception {
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

	@Test
	public void sendsMessageForAnniversary() throws Exception {
		service.sendGreetings(EMPLOYEE_DATA_FILE, new OurDate("2012/08/01"), "localhost", SMTP_PORT);

		assertEquals("message not sent?", 1, messagesSent.size());
		Message message = messagesSent.get(0);
		assertEquals("Happy Anniversary, dear Mary!", message.getContent());
		assertEquals("Happy Anniversary!", message.getSubject());
		assertEquals(1, message.getAllRecipients().length);
		assertEquals("mary.ann@foobar.com", message.getAllRecipients()[0].toString());
	}
}
