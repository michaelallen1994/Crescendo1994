// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

  public static class DriveConstants { 
    public static final int kLeftMotor1Port = 3;
    public static final int kLeftMotor2Port = 2;
    public static final int kRightMotor1Port = 4;
    public static final int kRightMotor2Port = 1;
    public static final int kLeftMaster = 3;
    public static final int kLeftFollower = 2;
    public static final int kRightMaster = 4;
    public static final int kRightFollower = 1;
    public static final double kLeftDriveSpeed = .5;
    public static final double kRightDriveSpeed = .5;

     }
    public static class LoaderConstants {
      public static final int kLoaderMotor1Port = 5;
      public static final int kLoaderMotor2Port = 6;
      public static final double kLoad = 1;
      public static final double kUnload = 1;
      public static final double kStop = 0;
    }
    public static class ClimberConstants {
      public static final int kClimberMotorPort = 6;
      public static final double kClimb = .5;
      public static final double kDecend = -.5;
      public static final double kStop = 0;
    }
}
