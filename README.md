# Offseason_MK5_drivebase_learnin

WPILib 2026 Java **Command Robot** project (team 3767).

## Build

Open the folder in WPILib VS Code and use **Build Robot Code**, or run:

```powershell
.\gradlew.bat build
```

## Deploy

Connect to the robot (roboRIO on team 3767), then use **Deploy Robot Code** in WPILib VS Code, or run:

```powershell
.\gradlew.bat deploy
```

## Terminal builds outside WPILib VS Code

The build requires Java 17. WPILib VS Code sets this up automatically, but in a plain terminal you may need to point `JAVA_HOME` at the WPILib JDK first:

```powershell
$env:JAVA_HOME = 'C:\Users\Public\wpilib\2026\jdk'
```
