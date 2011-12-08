Imports System.Collections.Generic
Imports System.IO
Imports NUnit.Framework

Namespace ReportGeneratorVB.Tests
    <TestFixture()> _
    Public Class ReportTest
        <Test()> _
        Public Sub TestReport()
            Dim line As IList(Of Machine) = New List(Of Machine)()
            line.Add(New Machine("mixer", "left"))

            Dim extruder As New Machine("extruder", "center")
            extruder.Put("paste")
            line.Add(extruder)

            Dim oven As New Machine("oven", "right")
            oven.Put("chips")
            line.Add(oven)

            Dim robot As New Robot()
            robot.MoveTo(extruder)
            robot.Pick()

            Dim output As New StringWriter()
            Report.report(output, line, robot)

            Dim expected As String = "FACTORY REPORT" & vbLf + "Machine mixer" & vbLf & "Machine extruder" & vbLf + "Machine oven bin=chips" & vbLf & vbLf + "Robot location=extruder bin=paste" & vbLf + "========" & vbLf

            Assert.That(expected, [Is].EqualTo(output.ToString()))
        End Sub
    End Class
End Namespace