Windows - Creating Visual Studio
================================
C# and VB.net Steps below for C# change paths and project types for VB
	1.	Open Visual Studio, Create new Project
		File -> new -> Project and choose  a SolutionName, Location and ProjectName

	2.	Add files to project for directory ~/xp123/dotnet/ReportGenerator-CS/*
		Project -> Add Existing Item
		Machine.cs, Robot.cs, Report.cs,
		RobotTest.cs, ReportTest.cs

	3.	Add reference nunit.framework.dll
		Project -> Add Reference
		~/xp123/lib/nunit.framework.dll

	4.	Compile source code
		Build -> Build Solution

	5.	Run unit tests in test runner of your choice (Resharper, nunit-gui, nunit-console)

	6.	Refactor code and repeat steps 4 and 5 

Mono
====
C# Only
	1.	Open shell move Working Directory to
		~/xp123/dotnet/ReportGenerator-CS

	2.	Create bin directotory
		mkdir bin

	3.	Copy nunit.framework.dll into bin directory
		cp ../lib/nunit.framework.dll bin/.

	4.	Compile source code into bin
		gmcs -t:library -r:../lib/nunit.framework.dll -recurse:*.cs -out:bin/ReportGenerator.dll

	5.	Run unit tests
		nunit-console bin/ReportGenerator.dll 

	6.	Refactor code and repeat steps 4 and 5
