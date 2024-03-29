// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private final CANSparkMax climberMotor = new CANSparkMax(ClimberConstants.kClimberMotorPort, MotorType.kBrushless);

  public void Climb() {
    climberMotor.set(ClimberConstants.kClimb);

  }

  public void Decend() {
    climberMotor.set(ClimberConstants.kDecend);

  }

  public void Stop() {
    climberMotor.set(ClimberConstants.kStop);
  }
  
  public Climber() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
