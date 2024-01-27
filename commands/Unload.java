// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Loader;

public class Unload extends Command {
  private final Loader loader;
  /** Creates a new Load. */
  public Unload(Loader subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    loader = subsystem;
    addRequirements(loader);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    loader.unload();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    loader.unload();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    loader.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
