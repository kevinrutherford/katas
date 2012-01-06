
module("Robot");

test("should behave as expected", function() {
  expect(8);

	var sorter = new Machine('Sorter', 'left');
	sorter.put('chips');
	var oven = new Machine('Oven', 'middle');
	var robot = new Robot();

	assertThat( sorter.bin, is( equalTo( 'chips' ) ) );
	assertThat( oven.bin, is( nil() ) );
	assertThat( robot.location, is( nil() ) );
	assertThat( robot.bin, is( nil() ) );

	robot.move_to(sorter);
	robot.pick();
	robot.move_to(oven);
	robot.release();

	assertThat( robot.bin, is( nil() ) );
	assertThat( robot.location, is( equalTo( oven ) ) );
	assertThat( sorter.bin, is( nil() ) );
	assertThat( oven.bin, is( equalTo( 'chips' ) ) );

});