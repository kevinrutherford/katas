require 'machine'
require 'robot'

describe Robot do
  it 'should behave as expected' do
    sorter = Machine.new("Sorter", "left")
    sorter.put("chips")
    oven = Machine.new("Oven", "middle")
    robot = Robot.new

    sorter.bin.should == "chips"
    oven.bin.should be_nil
    robot.location.should be_nil
    robot.bin.should be_nil

    robot.move_to(sorter)
    robot.pick
    robot.move_to(oven)
    robot.release

    robot.bin.should be_nil
    robot.location.should == oven
    sorter.bin.should be_nil
    oven.bin.should == "chips"
  end
end

