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
				+ "<h2>mixer</h2>\n"
				+ "<ul>\n"
				+ "<li>location = left</li>\n"
				+ "<li>no bin</li>\n"
				+ "</ul>\n"
				+ "<h2>extruder</h2>\n"
				+ "<ul>\n"
				+ "<li>location = center</li>\n"
				+ "<li>no bin</li>\n"
				+ "</ul>\n"
				+ "<h2>oven</h2>\n"
				+ "<ul>\n"
				+ "<li>location = right</li>\n"
				+ "<li>bin containing chips</li>\n"
				+ "</ul>\n"
				+ "<h2>Robot</h2>\n"
				+ "<ul>\n"
				+ "<li>location = extruder</li>\n"
				+ "<li>bin containing paste</li>\n"
				+ "</ul>\n";

		assertEquals(expected, out.toString());
	}
}
