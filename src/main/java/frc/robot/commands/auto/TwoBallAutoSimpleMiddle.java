package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.*;

public class TwoBallAutoSimpleMiddle extends SequentialCommandGroup{
    public TwoBallAutoSimpleMiddle(DriveSystem driveSystem, IntakeSystem intakeSystem, FieldPositioningSystem positioningSystem, ShooterSystem shooterSystem, double distanceFromBall) {
        addCommands(
            new ParallelCommandGroup(
                new AutoIntakeDownBackward(driveSystem, positioningSystem),
                new AutoShoot(intakeSystem, shooterSystem)
            ),
            new RotateToAngle(driveSystem, positioningSystem, 164, .6),
            new ParallelRaceGroup(
                new SequentialCommandGroup(
                    new MoveXInchesForward(driveSystem, positioningSystem, distanceFromBall + IntakeConstants.INTAKE_LENGTH, .5),
                    new Wait(.1),
                    new MoveXInchesBackwards(driveSystem, positioningSystem, 10, 0.7),
                    new RotateToAngle(driveSystem, positioningSystem, 164, .6)
                ),
                new AutoIntake(intakeSystem, shooterSystem)
            ),
            new MoveXInchesForward(driveSystem, positioningSystem, distanceFromBall-5, .45),
            new AutoShoot(intakeSystem, shooterSystem)
        );

    }
    
}
