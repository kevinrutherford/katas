
var HtmlReport = {

  report: function(out, machines, robot) {
    out.push('<h1>FACTORY REPORT</h1>\n');

    for (var i = 0, machinesLength = machines.length; i < machinesLength; i++) {
    	var machine = machines[i];

      out.push('<h2>' + machine.name + '</h2>\n');
      out.push('<ul>\n');
      out.push('<li>location = ' + machine.location + '</li>\n');

      if (machine.bin != null) {
        out.push('<li>bin containing ' + machine.bin + '</li>\n');
      } else {
        out.push('<li>no bin</li>\n');
      }

      out.push('</ul>\n');
    }

    out.push('<h2>Robot</h2>\n');
    out.push('<ul>\n');

    if (robot.location != null) {
      out.push('<li>location = ' + robot.location.name + '</li>\n');
    }

    if ( robot.bin != null) {
    	out.push('<li>bin containing ' + robot.bin + '</li>\n');
    }

    out.push('</ul>\n');
  }

};

