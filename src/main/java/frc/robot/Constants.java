// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static final double robotLength = Units.inchesToMeters(25.5);
  public static final double robotWidth = Units.inchesToMeters(25.5);
  public static double setMaxOutput(double value, double maxOutput){
    return Math.min(maxOutput, Math.max(value, -maxOutput));
  }

  public static final class JoystickButtonNumbers{
    public static final int shootButtonNumber = 6;
    public static final int inButtonNumber = 2;
    public static final int ampButtonNumber = 3;
    public static final int primetiveButtonNumber = 4;
    public static final int climbDoneButtonNumber = 5;
    public static final int aimButtonNumber = 5;
    public static final int resetGyroButtonNumber = 2;
  }

  public static final class IntakeConstants{
    public static final double intakeInPosition = 0.0;
    public static final double intakePrimetivePosition = 0.0;
  }

  public static final class ShooterConstants{
    public static final double shooterPrimetivePosition = 0.0;
    public static final double shooterAMPSetpoint = 0.0;
    public static final double shooterSpeedSetpoint = 4580;
  }

  public static final class ApriltagConstants{
    public static final int blueSpeakerCenterID = 7;
    public static final int blueSpeakerLeftID = 8;
    public static final int blueAMPID = 9;
    public static final int bluesourceRightID = 1;
    public static final int blueSourceLeftID = 2;

    public static final int redSpeakerCenterID = 4;
    public static final int redRightSpeakerID = 3;
    public static final int redAMPID = 5;
    public static final int redSourceRightID = 9;
    public static final int redSourceLeftID = 10;

    public static final double speakerHeight = 204.5;//cm
    public static final double armHeight = 28.16;//cm

    public static final double limelightToArmDistance = 0;
    public static final double armAndEndEffectorAngle = 120.0;

    public static double[] redModeSelect(int targetID){
      double[] setpoint;
      switch (targetID) {
        case redAMPID:
          setpoint = new double[]{0, 0, 0, 0};
          break;
        case redSourceLeftID:
          setpoint = new double[]{0, 0, 0, 0};
          break;
        case redSpeakerCenterID,redRightSpeakerID , redSourceRightID:
          setpoint = new double[]{0,0,0,0}; 
        default:
          setpoint = new double[]{0, 0, 0, 0};
          break;
        
      }
      return setpoint;
    }
    public static double[] blueModeSelect(int targetID){
      double[] setpoint;
      switch (targetID) {
        case blueAMPID:
          setpoint = new double[]{0, 0, 0, 0};
          break;
        case blueSourceLeftID:
          setpoint = new double[]{0, 0, 0, 0};
          break;
        case blueSpeakerCenterID, blueSpeakerLeftID, bluesourceRightID:
          setpoint = new double[]{0,0,0,0}; 
        default:
          setpoint = new double[]{0, 0, 0, 0};
          break;
        
      }
      return setpoint;
    }

  }

  public static final class SwerveModuleConstants{
    public static final double wheelDiameter = Units.inchesToMeters(4);
    public static final double driveMotorGearRatio = 1/6.75;
    public static final double turningMotorGearRatio = 1.0/(150/7);
    public static final double driveEncoderRot2Meter = driveMotorGearRatio*Math.PI*wheelDiameter;
    public static final double turningEncoderRot2Rad = turningMotorGearRatio*2*Math.PI;
    public static final double driveEncoderRPM2MeterPerSec = driveEncoderRot2Meter/60.0;
    public static final double turningEncoderRPM2RadPerSec = turningEncoderRot2Rad/60.0;
    public static final double turningMotorkP = 0.015;
    public static final double maxDriveMotorSpeed = 4.0;
  }
  public static final class SwerveConstants{
    public static final int leftFrontDriveID = 7;
    public static final int leftFrontTurningID = 8;
    public static final int rightFrontDriveID = 1;
    public static final int rightFrontTurningID = 2;  
    public static final int leftRearDriveID = 5;
    public static final int leftRearTurningID = 6;
    public static final int rightRearDriveID = 3;
    public static final int rightRearTurningID = 4;

    public static final int leftFrontCANCoderID = 14;
    public static final int rightFrontCANCoderID = 11;
    public static final int leftRearCANCoderID = 13;
    public static final int rightRearCANCoderID = 12;

    public static final boolean leftFrontdriveMotorReversed = true;
    public static final boolean leftFrontTurningMotorReversed = true;
    public static final boolean rightFrontDriveMotorReversed = true;
    public static final boolean rightfrontTurningMotorReversed = true;
    public static final boolean leftRearDriveMotorreversed = false;
    public static final boolean leftRearTurningMotorReversed = true;
    public static final boolean rightRearDriveMotorReversed = false;
    public static final boolean rightRearTurningMotorReversed = true;

    public static final double leftFrontOffset = 0.129;
    public static final double rightFrontOffset = -0.355;
    public static final double leftRearOffset = -0.345;
    public static final double rightRearOffset = 0.042;
    
    public static double joysickValue(double value, double mineOutput){
      if(Math.abs(value) < mineOutput){
        return 0;
      }
      else{
        return value;
      }
    }

    public static final int gyroID = 10;
    //front left, front right, rear left, rear right
    public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
      new Translation2d(robotLength/2, robotWidth/2), 
      new Translation2d(robotLength/2, -robotWidth/2), 
      new Translation2d(-robotLength/2, robotWidth/2),
      new Translation2d(-robotLength/2, -robotWidth/2)
  );
  }
}
