// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  private final CANSparkMax leftMotor1 = new CANSparkMax(DriveConstants.kLeftMotor1Port, MotorType.kBrushless);
  private final CANSparkMax leftMotor2 = new CANSparkMax(DriveConstants.kLeftMotor2Port, MotorType.kBrushless);
  private final CANSparkMax rightMotor1 = new CANSparkMax(DriveConstants.kRightMaster, MotorType.kBrushless);
  private final CANSparkMax rightMotor2 = new CANSparkMax(DriveConstants.kRightFollower, MotorType.kBrushless);
  private final DifferentialDrive drive = new DifferentialDrive(leftMotor1, rightMotor1);

  public void Drive (double left, double right) {
    drive.tankDrive(left, right);
    drive.setMaxOutput(1);
    drive.setSafetyEnabled(false);
    
  }

  public void tankDrive(double left, double right) {
    drive.tankDrive(DriveConstants.kLeftDriveSpeed, DriveConstants.kRightDriveSpeed);

  }

  public Drivetrain() {
    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor2);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    drive.tankDrive(0, 0);
  }
}
