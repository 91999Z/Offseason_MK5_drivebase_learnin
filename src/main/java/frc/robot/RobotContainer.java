package frc.robot;

import frc.robot.subsystems.limel;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

    private final limel m_limelight = new limel();

    public RobotContainer() {
      
    }
    

public Command getAutonomousCommand() {
    return null;
}

    public limel getLimelight() {
        return m_limelight;
    }
    
}