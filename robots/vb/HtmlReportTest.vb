Imports System.Collections.Generic
Imports System.IO
Imports NUnit.Framework

Namespace ReportGeneratorVB.Tests
    <TestFixture()> _
    Public Class HtmlReportTest

        <Test()> _
        Public Sub testReport()
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
            HtmlReport.report(output, line, robot)

            Dim expected As String = "<h1>FACTORY REPORT</h1>" & vbLf + "<ul>" & vbLf & "<li>Machine mixer</li>" & vbLf & "<li>Machine extruder</li>" & vbLf + "<li>Machine oven bin=chips</li>" & vbLf & "</ul>" & vbLf + "<p>Robot location=extruder bin=paste</p>" & vbLf + "<hr>" & vbLf

            Assert.That(expected, [Is].EqualTo(output.ToString()))
        End Sub
    End Class
End Namespace