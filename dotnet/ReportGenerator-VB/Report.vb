Imports System.Collections.Generic
Imports System.IO

Namespace ReportGeneratorVB
	Public Class Report
		Public Shared Sub report(output As StringWriter, machines As IList(Of Machine), robot As Robot)
			output.Write("FACTORY REPORT" & vbLf)

			Dim line As IEnumerator(Of Machine) = machines.GetEnumerator()
			While line.MoveNext()
				Dim machine As Machine = line.Current
				output.Write("Machine " + machine.Name())

				If machine.Bin() IsNot Nothing Then
					output.Write(" bin=" + machine.Bin())
				End If

				output.Write(vbLf)
			End While
			output.Write(vbLf)

			output.Write("Robot")
			If robot.Location() IsNot Nothing Then
				output.Write(" location=" + robot.Location().Name())
			End If

			If robot.Bin() IsNot Nothing Then
				output.Write(" bin=" + robot.Bin())
			End If

			output.Write(vbLf)

			output.Write("========" & vbLf)
		End Sub
	End Class
End Namespace