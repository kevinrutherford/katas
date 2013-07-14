
module("HtmlReport");

test("should report the state of everything", function() {
  expect(1);

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
	HtmlReport.report(out, line, robot);

	expected = '<h1>FACTORY REPORT</h1>\n' +
             '<h2>mixer</h2>\n' +
             '<ul>\n' +
             '<li>location = left</li>\n' +
             '<li>no bin</li>\n' +
             '</ul>\n' +
             '<h2>extruder</h2>\n' +
             '<ul>\n' +
             '<li>location = center</li>\n' +
             '<li>no bin</li>\n' +
             '</ul>\n' +
             '<h2>oven</h2>\n' +
             '<ul>\n' +
             '<li>location = right</li>\n' +
             '<li>bin containing chips</li>\n' +
             '</ul>\n' +
             '<h2>Robot</h2>\n' +
             '<ul>\n' +
             '<li>location = extruder</li>\n' +
             '<li>bin containing paste</li>\n' +
             '</ul>\n';

	assertThat(out.join(''), is( equalTo( expected ) ));
});