// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;

public class limel extends SubsystemBase {

    private static final double cameraHeight = Constants.LimelightConstants.cameraHeight; // Height of the camera from the floor in meters
    private static final double cameraForward = Constants.LimelightConstants.cameraForward; // Forward offset of the camera from the center of the robot in meters
    private static final double cameraSideOffset = Constants.LimelightConstants.cameraSideOffset; // Side offset of the camera from the center of the robot in meters 
    private static final double cameraPitch = Constants.LimelightConstants.cameraPitch; // Pitch of the camera in degrees
    private static final double cameraYaw = Constants.LimelightConstants.cameraYaw; // Yaw of the camera in degrees
    private static final double cameraRoll = Constants.LimelightConstants.cameraRoll; // Roll of the camera in degrees

  private double tx; // Horizontal offset from crosshair to target in degrees

  public double getTx() {
    return tx;
  }

  private double ty; // Vertical offset from crosshair to target in degrees
  public double getTy() {
    return ty;
  }

  private double ta; // Target area (0% to 100% of image)
  public double getTa() {
    return ta;
  }

  private double txnc; // Horizontal offset from principal pixel/point to target in degrees
  public double getTxnc() {
    return txnc;
  }

  private double tync; // Vertical offset from principal pixel/point to target in degrees
  public double getTync() {
    return tync;
  }
  private boolean hasTarget; // Do you have a valid target?
  public boolean hasTarget() {
    return hasTarget;
  }

  public limel() {
configureLimelight();
  }

  public void configureLimelight() {
   /*  LimelightHelpers.setPipelineIndex("limelight", 0); // Set the pipeline index to 0
    LimelightHelpers.setLEDMode("limelight", 3); // Set the LED mode to on
    LimelightHelpers.setCamMode("limelight", 0); // Set the camera mode to vision processing
    LimelightHelpers.setStreamMode("limelight", 0); // Set the stream mode to standard*/

      LimelightHelpers.setCameraPose_RobotSpace(
      "limelight",
      cameraForward,
      cameraSideOffset,
      cameraHeight,
      cameraRoll,
      cameraPitch,
      cameraYaw
    );
  }


  public LimelightHelpers.PoseEstimate getPoseEstimate() {
    return LimelightHelpers.getBotPoseEstimate_wpiBlue_MegaTag2("limelight");
  }

  public Pose2d getRobotPose(){
    LimelightHelpers.PoseEstimate poseEstimate = getPoseEstimate();
    return poseEstimate.pose;
  }


  public boolean seeTag(){

    LimelightHelpers.PoseEstimate poseEstimate = getPoseEstimate();
    return poseEstimate.tagCount > 0;
  }



  @Override
  public void periodic() {

    tx = LimelightHelpers.getTX("limelight"); // Horizontal offset from crosshair to target in degrees
   ty = LimelightHelpers.getTY("limelight"); // Vertical offset from crosshair to target in degrees
    ta = LimelightHelpers.getTA("limelight"); // Target area (0% to 100% of image)
    hasTarget = LimelightHelpers.getTV("limelight"); // Do you have a valid target?

    txnc = LimelightHelpers.getTXNC("limelight"); // Horizontal offset from principal pixel/point to target in degrees
    tync = LimelightHelpers.getTYNC("limelight"); // Vertical offset from principal pixel/point to target in degrees
  }

  @Override
  public void simulationPeriodic() {
  }
}