package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotUtils;
import frc.robot.subsystems.ShooterSystem;

public class RunShooter extends CommandBase{
    ShooterSystem shooterSystem;
    double voltage;
    public RunShooter(ShooterSystem shooterSystem, double voltage) {
        this.shooterSystem = shooterSystem;

        this.voltage = voltage;

    }
    public void execute() {
        shooterSystem.ShooterRunVoltage(voltage);

    }
    public void end(boolean interrupted) {
        shooterSystem.ShooterStop();
        RobotUtils.sendToShuffleboard("RunShooter voltage", voltage);

    }
    
}
