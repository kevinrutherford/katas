Namespace ReportGeneratorVB
	Public Class Robot
        Private _bin As String
        Private _location As Machine

		Public Function Location() As Machine
            Return _location
		End Function

		Public Sub MoveTo(location As Machine)
            Me._location = location
		End Sub

		Public Sub Pick()
            _bin = _location.Take()
		End Sub

		Public Function Bin() As String
            Return _bin
		End Function

		Public Sub Release()
            _location.Put(Bin)
            _bin = Nothing
		End Sub
	End Class
End Namespace