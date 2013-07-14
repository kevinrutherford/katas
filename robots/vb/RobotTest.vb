Imports NUnit.Framework

Namespace ReportGeneratorVB.Tests
    <TestFixture()> _
    Public Class RobotTest
        <Test()> _
        Public Sub TestRobot()
            Dim sorter As New Machine("Sorter", "left")
            sorter.Put("chips")
            Dim oven As New Machine("Oven", "middle")
            Dim robot As New Robot()

            Assert.That("chips", [Is].EqualTo(sorter.Bin()))
            Assert.That(oven.Bin(), [Is].Null)
            Assert.That(robot.Location(), [Is].Null)
            Assert.That(robot.Bin(), [Is].Null)

            robot.MoveTo(sorter)
            robot.Pick()
            robot.MoveTo(oven)
            robot.Release()

            Assert.That(robot.Bin(), [Is].Null)
            Assert.That(oven, [Is].EqualTo(robot.Location()))
            Assert.That(sorter.Bin(), [Is].Null)
            Assert.That("chips", [Is].EqualTo(oven.Bin()))
        End Sub
    End Class
End Namespace