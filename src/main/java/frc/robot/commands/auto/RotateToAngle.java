package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotUtils;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.FieldPositioningSystem;

public class RotateToAngle extends CommandBase {
    private DriveSystem driveSystem;
    private FieldPositioningSystem fieldPositioningSystem;

    private double desiredAngle, velocity, marginOfError, angleDifference, startingError;
    private final double rampRate = 0.5;

    private int directionConstant;

    public RotateToAngle(DriveSystem driveSystem, FieldPositioningSystem fieldPositioningSystem, double desiredAngle, double velocity) {
        this.driveSystem = driveSystem;
        this.fieldPositioningSystem = fieldPositioningSystem;

        this.desiredAngle = desiredAngle;
        this.velocity = velocity;
        marginOfError = 2;

    }

    public void initialize() {
        fieldPositioningSystem.zeroPosition();
        marginOfError = 2;

        startingError = Math.abs(desiredAngle);
    
        SmartDashboard.putNumber("desiredAngle", desiredAngle);

        driveSystem.setRampRate(rampRate);

        if (desiredAngle > 180)
            directionConstant = -1;
        else
            directionConstant = 1;

    }

    public void execute() {
        double angle = fieldPositioningSystem.angle;

        angleDifference = Math.abs(desiredAngle - angle); // Current angle discrepancy
        
        if (angleDifference < desiredAngle / 1.75) {
            double proportion = angleDifference / (startingError / 1.75);

            // Determine the drive power to use
            double minPower = .325;
            double power = proportion * (velocity - minPower) + minPower;

            driveSystem.tankDrive(directionConstant * power, -directionConstant * power);
        }
        else {
            driveSystem.tankDrive(velocity, -velocity);
        }

        RobotUtils.sendToShuffleboard("angleDifference", angleDifference);
    }

    public void end(boolean interrupted) {
        driveSystem.tankDrive(0,0);
    }

    public boolean isFinished() {
        return angleDifference <= marginOfError;
    }
}