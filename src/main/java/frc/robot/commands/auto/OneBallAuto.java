package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.FieldPositioningSystem;
import frc.robot.subsystems.IntakeSystem;
import frc.robot.subsystems.ShooterSystem;

public class OneBallAuto extends SequentialCommandGroup {
    public OneBallAuto(DriveSystem driveSystem, FieldPositioningSystem positioningSystem, IntakeSystem intakeSystem, ShooterSystem shooterSystem) {
        addCommands(
            new ShootFromStart(driveSystem, positioningSystem, intakeSystem, shooterSystem),
            new MoveXInchesBackwards(driveSystem, positioningSystem, 60, .4)

        );

    }
    
}
