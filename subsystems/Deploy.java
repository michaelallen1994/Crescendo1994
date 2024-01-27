// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DeployConstants;

public class Deploy extends SubsystemBase {
  private final CANSparkMax deployMotor = new CANSparkMax(DeployConstants.kDeployMotorPort, MotorType.kBrushless);
  private SparkPIDController pidController;
  private double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  private RelativeEncoder encoder;

  encoder = deployMotor.getEncoder(SparkRelativeEncoder.Type.kQuadrature, 4096);
  deployMotor.restoreFactoryDefaults();
  pidController = deployMotor.getPIDController();
  pidController = deployMotor.setFeedbackDevice(encoder);

  // PID coefficients
    kP = 0.1; 
    kI = 1e-4;
    kD = 1; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = 1; 
    kMinOutput = -1;

  // setPID coefficients
    pidController.setP(kP);
    pidController.setI(kI);
    pidController.setD(kD);
    pidController.setIZone(kIz);
    pidController.setFF(kFF);
    pidController.setOutputRange(kMinOutput, kMaxOutput);

  // display PID coefficients on SmartDashboard
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
    SmartDashboard.putNumber("Set Rotations", 0);
    
    // read PID coefficients from SmartDashboard
     double p = SmartDashboard.getNumber("P Gain", 0);
     double i = SmartDashboard.getNumber("I Gain", 0);
     double d = SmartDashboard.getNumber("D Gain", 0);
     double iz = SmartDashboard.getNumber("I Zone", 0);
     double ff = SmartDashboard.getNumber("Feed Forward", 0);
     double max = SmartDashboard.getNumber("Max Output", 0);
     double min = SmartDashboard.getNumber("Min Output", 0);
     double rotations = SmartDashboard.getNumber("Set Rotations", 0);
 
     // if PID coefficients on SmartDashboard have changed, write new values to controller
     if((p != kP)) { pidController.setP(p); kP = p; }
     if((i != kI)) { pidController.setI(i); kI = i; }
     if((d != kD)) { pidController.setD(d); kD = d; }
     if((iz != kIz)) { pidController.setIZone(iz); kIz = iz; }
     if((ff != kFF)) { pidController.setFF(ff); kFF = ff; }
     if((max != kMaxOutput) || (min != kMinOutput)) { 
       pidController.setOutputRange(min, max); 
       kMinOutput = min; kMaxOutput = max; }

     pidController.setReference(rotations, CANSparkMax.ControlType.kPosition);
    
     SmartDashboard.putNumber("SetPoint", rotations);
     SmartDashboard.putNumber("ProcessVariable", encoder.getPosition());

      /** Creates a new Deploy. */
  public Deploy() {
    deployMotor.set(DeployConstants.kStop);
  }

  public void Deploying() {
    deployMotor.set(DeployConstants.kDeploy);
    
  }

  public void Retract() {
    deployMotor.set(DeployConstants.kRetract);
     
  }

  public void Mid () {
    deployMotor.set(DeployConstants.kMid);
  }

  public void Stop () {
    deployMotor.set(DeployConstants.kStop);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
