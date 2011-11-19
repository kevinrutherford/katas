import java.util.*;
import java.io.*;

public class HtmlReport {
    public static void report(Writer out, List<Machine> machines, Robot robot)
            throws IOException 
    {
        out.write("<h1>FACTORY REPORT</h1>\n");

        Iterator<Machine> line = machines.iterator();
        out.write("<ul>\n");
        while (line.hasNext()) {
            Machine machine = (Machine) line.next();
            out.write("<li>");
            out.write("Machine " + machine.name());

            if (machine.bin() != null)
                out.write(" bin=" + machine.bin());

            out.write("</li>\n");
        }
        out.write("</ul>\n");

        out.write("<p>");
        out.write("Robot");
        if (robot.location() != null)
            out.write(" location=" + robot.location().name());

        if (robot.bin() != null)
            out.write(" bin=" + robot.bin());

        out.write("</p>\n");

        out.write("<hr>\n");
    }
}
