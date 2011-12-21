Windows - Visual Studio:

1. Open Visual Studio, Create new Project
		File -> new -> Project and choose  a SolutionName, Location and ProjectName

2. Add files to project for directory ~/xp123/vb/*
		Project -> Add Existing Item
		Machine.vb, Robot.vb, Report.vb,
		RobotTest.vb, ReportTest.vb

3. Add reference nunit.framework.dll
		Project -> Add Reference
		~/xp123/lib/nunit.framework.dll

4. Compile source code
		Build -> Build Solution

5. Run unit tests in test runner of your choice (Resharper, nunit-gui, nunit-console).
6. Refactor code and repeat steps 4 and 5.

