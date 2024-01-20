// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LoaderConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Loader extends SubsystemBase {
  private final CANSparkMax loaderMotor = new CANSparkMax(LoaderConstants.kLoaderMotorPort, MotorType.kBrushed);
  /** Creates a new TestLoader. */

  public void load() {
    loaderMotor.set(LoaderConstants.kLoad);

  }

  public void unload() {
    loaderMotor.set(LoaderConstants.kUnload);

  }

  public void stop(){
    loaderMotor.set(LoaderConstants.kStop);
    
  }
  public Loader() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
