class HtmlReport
  def HtmlReport.report(out, machines, robot)
    out.print("<h1>FACTORY REPORT</h1>\n")
    out.print("<ul>\n")
    machines.each do |machine|
      out.print("<li>")
      out.print "Machine #{machine.name}"
      out.print " bin=#{machine.bin}" if machine.bin != nil
      out.print("</li>\n")
    end
    out.print("</ul>\n")
    out.print("<p>")
    out.print "Robot"
    if robot.location != nil
      out.print " location=#{robot.location.name}"
    end
    out.print " bin=#{robot.bin}" if robot.bin != nil
    out.print("</p>\n")
    out.print("<hr>\n")
  end
end

