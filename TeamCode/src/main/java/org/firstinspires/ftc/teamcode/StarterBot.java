package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class StarterBot extends LinearOpMode {
    private DcMotor leftDrive;
    private DcMotor rightDrive;

    private DcMotor intakeMotor;

    private int driveMode = 0;

    private boolean lastOptionsState = false;

    private String displayMode;


    @Override
    public void runOpMode() {
        // Assigning motors to variables. Initilizing
        leftDrive = hardwareMap.get(DcMotor.class, "lmotor");
        rightDrive = hardwareMap.get(DcMotor.class, "rmotor");

        intakeMotor = hardwareMap.get(DcMotor.class, "imotor");


        // Sets the direction of the motors to make sure the robot drives forward and doesn't spin
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait until start button is pressed
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.dpad_left) {
                driveMode = 0;
            } else if (gamepad1.dpad_up) {
                driveMode = 1;
            } else if (gamepad1.dpad_right) {
                driveMode = 2;
            }


            // If triangle is currently pressed and lastOptionsState is false run this if statement
            // This prevents the button from being pressed again rapidly and switching modes
            if (gamepad1.triangle && !lastOptionsState) {
                driveMode++;
                if (driveMode > 2) {
                    driveMode = 0;
                }
            }

            // Sets lastOptionsState to true or false depending if the button is pressed.
            lastOptionsState = gamepad1.triangle;

            switch (driveMode) {
                case 0:
                    tankDrive();
                    displayMode = "Tank";
                    break;
                case 1:
                    arcadeDrive();
                    displayMode = "Arcade";
                    break;
                case 2:
                    carDrive();
                    displayMode = "Car";
                default:
                    tankDrive();
                    displayMode = "Tank";
                    break;

            }
            intake();

            telemetry.addData("Left Drive Power", leftDrive.getPower());
            telemetry.addData("Right Drive Power", rightDrive.getPower());
            telemetry.addData("Intake Power", intakeMotor.getPower());
            telemetry.addData("Drive Mode", displayMode);
            telemetry.update();






        }

    }


    private void intake() {
        float outtake;
        float intake;


        outtake = gamepad2.left_trigger;
        intake = gamepad2.right_trigger;

        intakeMotor.setPower(intake - outtake);
    }

    private void arcadeDrive() {
        float leftSticky;
        float rightStickx;

        // Get stick values
        leftSticky = gamepad1.left_stick_y;
        rightStickx = gamepad1.right_stick_x;

        leftDrive.setPower(leftSticky + rightStickx);
        rightDrive.setPower(leftSticky - rightStickx);

    }

    private void carDrive() {
        float forward;
        float backward;
        float turn;

        backward = gamepad1.left_trigger;
        forward = gamepad1.right_trigger;
        turn = gamepad1.right_stick_x;

        leftDrive.setPower((forward - backward) + turn);
        rightDrive.setPower((forward - backward) - turn);


    }
    private void tankDrive() {
        float leftSticky = gamepad1.left_stick_y;
        float rightSticky = gamepad1.right_stick_y;

        leftDrive.setPower(leftSticky);
        rightDrive.setPower(rightSticky);

    }
}
