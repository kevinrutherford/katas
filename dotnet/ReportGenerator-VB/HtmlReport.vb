Imports System.Collections.Generic
Imports System.IO

Namespace ReportGeneratorVB
    Public Class HtmlReport
        Public Shared Sub report(ByVal output As StringWriter, ByVal machines As IList(Of Machine), ByVal robot As Robot)
            output.Write("<h1>FACTORY REPORT</h1>" & vbLf)

            Dim line As IEnumerator(Of Machine) = machines.GetEnumerator()
            output.Write("<ul>" & vbLf)
            While line.MoveNext()
                Dim machine As Machine = line.Current
                output.Write("<li>")
                output.Write("Machine " + machine.Name())

                If machine.Bin() IsNot Nothing Then
                    output.Write(" bin=" + machine.Bin())
                End If

                output.Write("</li>" & vbLf)
            End While
            output.Write("</ul>" & vbLf)

            output.Write("<p>")
            output.Write("Robot")
            If robot.Location() IsNot Nothing Then
                output.Write(" location=" + robot.Location().Name())
            End If

            If robot.Bin() IsNot Nothing Then
                output.Write(" bin=" + robot.Bin())
            End If

            output.Write("</p>" & vbLf)

            output.Write("<hr>" & vbLf)
        End Sub
    End Class
End Namespace