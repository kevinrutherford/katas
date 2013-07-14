import java.util.*;
import java.io.*;

public class HtmlReport {
    public static void report(Writer out, List<Machine> machines, Robot robot)
            throws IOException 
    {
        out.write("<h1>FACTORY REPORT</h1>\n");

        Iterator<Machine> line = machines.iterator();
        while (line.hasNext()) {
        	Machine machine = (Machine) line.next();
        	out.write("<h2>" + machine.name() + "</h2>\n");
        	out.write("<ul>\n");
            out.write("<li>location = " + machine.location + "</li>\n");

            if (machine.bin() != null)
                out.write("<li>bin containing " + machine.bin() + "</li>\n");
            else
                out.write("<li>no bin</li>\n");            	

            out.write("</ul>\n");
        }

        out.write("<h2>Robot</h2>\n<ul>\n");
        if (robot.location() != null)
            out.write("<li>location = " + robot.location().name() + "</li>\n");

        if (robot.bin() != null)
            out.write("<li>bin containing " + robot.bin() + "</li>\n");

        out.write("</ul>\n");
    }
}
