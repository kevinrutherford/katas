import junit.framework.TestCase;

import java.util.ArrayList;
import java.io.StringWriter;
import java.io.IOException;

public class HtmlReportTest extends TestCase {
	public HtmlReportTest(String name) {
		super(name);
	}

	public void testReport() throws IOException {
		ArrayList<Machine> line = new ArrayList<Machine>();
		line.add(new Machine("mixer", "left"));

		Machine extruder = new Machine("extruder", "center");
		extruder.put("paste");
		line.add(extruder);

		Machine oven = new Machine("oven", "right");
		oven.put("chips");
		line.add(oven);

		Robot robot = new Robot();
		robot.moveTo(extruder);
		robot.pick();

		StringWriter out = new StringWriter();
		HtmlReport.report(out, line, robot);

		String expected = "<h1>FACTORY REPORT</h1>\n"
				+ "<ul>\n<li>Machine mixer</li>\n<li>Machine extruder</li>\n"
				+ "<li>Machine oven bin=chips</li>\n</ul>\n"
				+ "<p>Robot location=extruder bin=paste</p>\n" + "<hr>\n";

		assertEquals(expected, out.toString());
	}
}
