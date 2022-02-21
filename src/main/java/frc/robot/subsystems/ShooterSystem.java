// Create a low goal and a method to roll out enemy balls. High goal shooter once finished with other two.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.revrobotics.RelativeEncoder;

import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class ShooterSystem extends SubsystemBase {
    // Shooter motor controllers
    public final static CANSparkMax shooterController = new CANSparkMax(ShooterConstants.SHOOTER_CONTROLLER_PORT, MotorType.kBrushless);
    public final static CANSparkMax upperKickerController = new CANSparkMax(ShooterConstants.UPPER_KICKER_CONTROLLER_PORT, MotorType.kBrushed);
    public final static CANSparkMax lowerKickerController = new CANSparkMax(ShooterConstants.LOWER_KICKER_CONTROLLER_PORT, MotorType.kBrushed);

    // Shooter motor controller encoders
    final RelativeEncoder shooterControllerEncoder = shooterController.getEncoder();
	public static final double ShooterRPM = 0;

    // Creates the ShooterSubsystem
    public ShooterSystem() {
        shooterController.restoreFactoryDefaults();
        shooterController.setIdleMode(IdleMode.kCoast);
        shooterController.setInverted(Constants.ShooterConstants.SHOOTER_INVERSED);

        shooterControllerEncoder.setPositionConversionFactor(ShooterConstants.SHOOTER_DISTANCE_PER_PULSE);
        shooterControllerEncoder.setVelocityConversionFactor(ShooterConstants.VELOCITY_CONVERSION_FACTOR);

        upperKickerController.setIdleMode(IdleMode.kCoast);
        upperKickerController.setInverted(Constants.ShooterConstants.UPPER_KICKER_INVERSED);

        upperKickerController.setIdleMode(IdleMode.kBrake);
        upperKickerController.setInverted(Constants.ShooterConstants.LOWER_KICKER_INVERSED);
    }

    public void periodic() {

    }

    public static double verifyVelocity(double speed) {
        int sign = (int) (speed / Math.abs(speed));
        if (Math.abs(speed) > ShooterConstants.MAX_INPUT)
            return sign * ShooterConstants.MAX_INPUT;
        return speed;
    }

    public static void ShooterRun(double speed) {
        shooterController.set(speed);
    }

    public static void ShooterStop() {
        shooterController.stopMotor();
    }

    public void ShooterReverse(double speed) {
        shooterController.set(-speed);
    }

    public static void UpperKickerRun(double speed) {
        upperKickerController.set(speed);
    }
    
    public static void UpperKickerReverse(double speed) {
        upperKickerController.set(-speed);
    }

    public static void UpperKickerStop() {
        upperKickerController.stopMotor();
    }
    
    public static void LowerKickerRun(double speed) {
        lowerKickerController.set(speed);
    }

    public static void LowerKickerReverse(double speed) {
        lowerKickerController.set(-speed);
    }

    public static void LowerKickerStop() {
        lowerKickerController.stopMotor();
    }
}