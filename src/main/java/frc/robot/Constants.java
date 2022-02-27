package frc.robot;

public final class Constants {
  public static final double INCHES_TO_METERS = 0.0254;

  public static final class DriveConstants {
    public static final int LEFT_MOTOR_1_PORT = 1;
    public static final int LEFT_MOTOR_2_PORT = 2;
    public static final int RIGHT_MOTOR_1_PORT = 3;
    public static final int RIGHT_MOTOR_2_PORT = 4;

    public static final boolean RIGHT_MOTORS_INVERSED = false;
    public static final boolean LEFT_MOTORS_INVERSED = true;
    public static final boolean STEERING_INVERSED = false;

    public static final double INITIAL_MAX_INPUT = .8;
  }

  public static final class ShooterConstants {
    public static final int UPPER_KICKER_CONTROLLER_PORT = 7;
    public static final int LOWER_KICKER_CONTROLLER_PORT = 8;
    public static final int SHOOTER_CONTROLLER_PORT = 9;

    public static final boolean SHOOTER_INVERSED = false;
    public static final boolean UPPER_KICKER_INVERSED = false;
    public static final boolean LOWER_KICKER_INVERSED = true;

    public static final double SHOOTER_DISTANCE_PER_PULSE = 1/42 * Math.PI * 5;
    public static final double VELOCITY_CONVERSION_FACTOR = 1/42 * Math.PI * 5;
    public static final double ENCODER_DISTANCE_PER_PULSE = 0;
    public static final double MAX_INPUT = 0;
  }

  public static final class IntakeConstants {
    public static final int INTAKE_RUN_PORT = 5;

    public static final boolean INTAKE_RUN_INVERSED = false;
  }

  public static final class ClimberConstants {
    public static final int CLIMBER_RUN_PORT = 10;
    public static final int CLIMBER_DEPLOY_PORT = 11;

    public static final boolean CLIMBER_RUN_INVERSED = false;
    public static final boolean CLIMBER_DEPLOY_INVERSED = false;
    public static final double CLIMBER_DEPLOY_CONVERSTION_FACTOR = 0;
  }

  public static final class PositioningConstants {
    public static final double GEAR_RATIO = 1 / 10.75;

    public static final double WHEEL_DIAMETER_INCHES = 6;
    public static final double WHEEL_DIAMETER_METERS = WHEEL_DIAMETER_INCHES * INCHES_TO_METERS;
    public static final double WHEEL_CIRCUMFRENCE = WHEEL_DIAMETER_INCHES * Math.PI;
  }

  public static final class ControlConstants {
    public static final double LOWER_KICKER_INITIAL_RUN_SPEED = .5;
    public static final double LOWER_KICKER_INITIAL_REVERSE_SPEED = .75;
    public static final double UPPER_KICKER_INITIAL_RUN_SPEED = .35;
    public static final double UPPER_KICKER_INITIAL_REVERSE_SPEED = .5;
    public static final double SHOOTER_INITIAL_RUN_SPEED = .8;
    public static final double SHOOTER_INITIAL_REVERSE_SPEED = .25;
    public static final double INTAKE_INITIAL_RUN_SPEED = .25;
    public static final double INTAKE_INITIAL_REVERSE_SPEED = .25;
    public static final double CLIMBER_RUNNER_INITIAL_RUN_SPEED = .9;
    public static final double CLIMBER_RUNNER_INITIAL_REVERSE_SPEED = .2;
    public static final double CLIMBER_DEPLOYER_INITIAL_RUN_SPEED = .1;
    public static final double CLIMBER_DEPLOYER_INITIAL_REVERSE_SPEED = .1;
  }

  public static final class AutoConstants {
    public static final double AUTO_ROTATE_SPEED = 0.2;
  }
}