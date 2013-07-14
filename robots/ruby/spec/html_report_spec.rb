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
<h2>mixer</h2>
<ul>
<li>location = left</li>
<li>no bin</li>
</ul>
<h2>extruder</h2>
<ul>
<li>location = center</li>
<li>no bin</li>
</ul>
<h2>oven</h2>
<ul>
<li>location = right</li>
<li>bin containing chips</li>
</ul>
<h2>Robot</h2>
<ul>
<li>location = extruder</li>
<li>bin containing paste</li>
</ul>
END_OF_EXPECTED
    out.string.should == expected
  end
end


