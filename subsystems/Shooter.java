// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  private final CANSparkMax shooterMotor1 = new CANSparkMax(ShooterConstants.kShooterMotor1Port, MotorType.kBrushed);
  private final CANSparkMax shooterMotor2 = new CANSparkMax(ShooterConstants.kShooterMotor2Port, MotorType.kBrushed);
  /** Creates a new Shooter. */
  public Shooter() {

  }

  public void Shoot() {
    shooterMotor1.set(ShooterConstants.kShoot);
    shooterMotor2.set(ShooterConstants.kClear);

  }

  public void Clear() {
    shooterMotor1.set(ShooterConstants.kClear);
    shooterMotor2.set(ShooterConstants.kShoot);

  }

  public void Stop() {
    shooterMotor1.set(ShooterConstants.kStop);
    shooterMotor2.set(ShooterConstants.kStop);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
