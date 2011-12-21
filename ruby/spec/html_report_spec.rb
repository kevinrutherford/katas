require 'machine'
require 'robot'
require 'html_report'
require 'stringio'

describe HtmlReport do
  it 'should report the state of everything' do
    line = []
    line << Machine.new("mixer", "left")

    extruder = Machine.new("extruder", "center")
    extruder.put("paste")
    line << extruder

    oven = Machine.new("oven", "right")
    oven.put("chips")
    line << oven

    robot = Robot.new
    robot.move_to(extruder)
    robot.pick

    out = StringIO.new
    HtmlReport.report(out, line, robot)

    expected = <<END_OF_EXPECTED
<h1>FACTORY REPORT</h1>
<ul>
<li>Machine mixer</li>
<li>Machine extruder</li>
<li>Machine oven bin=chips</li>
</ul>
<p>Robot location=extruder bin=paste</p>
<hr>
END_OF_EXPECTED
    out.string.should == expected
  end
end


