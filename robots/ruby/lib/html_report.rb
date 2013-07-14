class HtmlReport
  def HtmlReport.report(out, machines, robot)
    out.print("<h1>FACTORY REPORT</h1>\n")
    machines.each do |machine|
      out.print "<h2>#{machine.name}</h2>\n"
      out.print("<ul>\n")
      out.print("<li>location = #{machine.location}</li>\n")
      if machine.bin != nil
        out.print("<li>bin containing #{machine.bin}</li>\n")
      else
        out.print("<li>no bin</li>\n")
      end
      out.print("</ul>\n")
    end
    out.print "<h2>Robot</h2>\n"
    out.print("<ul>\n")
    if robot.location != nil
      out.print "<li>location = #{robot.location.name}</li>\n"
    end
    out.print "<li>bin containing #{robot.bin}</li>\n" if robot.bin != nil
    out.print("</ul>\n")
  end
end

