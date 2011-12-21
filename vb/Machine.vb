Namespace ReportGeneratorVB
    Public Class Machine
        Private _name As String
        Private _bin As String
        Private _location As String

        Public Sub New(ByVal name As String, ByVal location As String)
            Me._name = name
            Me._location = location
        End Sub

        Public Function Take() As String
            Dim result As String = _bin
            _bin = Nothing
            Return result
        End Function

        Public Function Bin() As String
            Return _bin
        End Function

        Public Sub Put(ByVal bin As String)
            Me._bin = bin
        End Sub

        Public Function Name() As String
            Return _name
        End Function
    End Class
End Namespace