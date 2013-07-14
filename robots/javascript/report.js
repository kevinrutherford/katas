
var Report = {

  report: function(out, machines, robot) {
    out.push('FACTORY REPORT\n');

    for (var i = 0, machinesLength = machines.length; i < machinesLength; i++) {
    	var machine = machines[i];

      out.push('Machine ' + machine.name);
      if (machine.bin != null) {
      	out.push(' bin=' + machine.bin);
      }
      out.push('\n');
    }

    out.push('\n');
    out.push('Robot');

    if (robot.location != null) {
      out.push(' location=' + robot.location.name);
    }
    if ( robot.bin != null) {
    	out.push(' bin=' + robot.bin);
    }
    out.push('\n');
    out.push('========\n');
  }

};

