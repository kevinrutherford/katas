
describe("Report", function() {

	it("should report the state of everything", function() {

		var line = [];
		line.push( new Machine("mixer", "left") );

		var extruder = new Machine("extruder", "center");
		extruder.put("paste");
		line.push( extruder );

		var oven = new Machine("oven", "right");
		oven.put("chips");
		line.push( oven );

		var robot = new Robot();
		robot.move_to(extruder);
		robot.pick();

		var out = [];
		Report.report(out, line, robot);

	    expected ='FACTORY REPORT\n' +
	             'Machine mixer\n' +
	             'Machine extruder\n' +
	             'Machine oven bin=chips\n' +
	             '\n' +
	             'Robot location=extruder bin=paste\n' +
	             '========\n';

		assertThat(out.join(''), is( equalTo( expected ) ));
	});

});