// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Deploy;

public class Retracting extends Command {
  private final Deploy deploy;
  /** Creates a new Retracting. */
  public Retracting(Deploy subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    deploy = subsystem;
    addRequirements(deploy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    deploy.Retract();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    deploy.Retract();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    deploy.Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
