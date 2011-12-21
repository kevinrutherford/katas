Windows - Visual Studio:

1. Open Visual Studio, Create new Project
		File -> new -> Project and choose  a SolutionName, Location and ProjectName

2. Add files to project for directory xp123/csharp/*
		Project -> Add Existing Item
		Machine.cs, Robot.cs, Report.cs,
		RobotTest.cs, ReportTest.cs

3. Add reference nunit.framework.dll
		Project -> Add Reference
		xp123/lib/nunit.framework.dll

4. Compile source code
		Build -> Build Solution

5. Run unit tests in test runner of your choice (Resharper, nunit-gui, nunit-console)
6. Refactor code and repeat steps 4 and 5.

Mono:

1. cd csharp
2. mkdir bin
3. cp ../lib/nunit.framework.dll bin/.
4. gmcs -t:library -r:../lib/nunit.framework.dll -recurse:*.cs -out:bin/ReportGenerator.dll
5. nunit-console bin/ReportGenerator.dll 
6. Refactor code and repeat steps 4 and 5

