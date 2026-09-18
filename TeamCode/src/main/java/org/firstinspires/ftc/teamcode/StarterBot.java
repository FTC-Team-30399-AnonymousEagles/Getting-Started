package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class StarterBot extends LinearOpMode {
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor intakeMotor;
    public int driveMode = 0;

    public boolean lastOptionsState = false;

    public String displayMode = "Tank";

    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "lmotor");
        rightDrive = hardwareMap.get(DcMotor.class, "rmotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "imotor");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.triangle && !lastOptionsState) {
                driveMode++;
                if (driveMode > 2) {
                    driveMode = 0;
                }
            }

            lastOptionsState = gamepad1.triangle; //

            if (gamepad1.dpad_left) {
                driveMode = 0;
            } else if (gamepad1.dpad_up) {
                driveMode = 1;
            } else if (gamepad1.dpad_right) {
                driveMode = 2;
            }

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
                    break;
                default:
                    tankDrive();
                    displayMode = "Tank";
                    break;
            }
            intake();

            telemetry.addData("Left Power", leftDrive.getPower()); // Displays leftmotor power.
            telemetry.addData("Right Power", leftDrive.getPower()); // Displays leftmotor power.
            telemetry.addData("Right Stick X", gamepad1.right_stick_x); // Displays rightstick axis
            telemetry.addData("Intake Power", intakeMotor.getPower());
            telemetry.addData("Position", leftDrive.getCurrentPosition()); // Shows current robot rotation count position. So 1434 1435
            telemetry.addData("Drive Mode", displayMode);
            telemetry.update();

        }
    }

    public void intake() {
        float intake;
        float outtake;

        intake = gamepad2.right_trigger; // 0 to 1
        outtake = gamepad2.left_trigger; // 0 to 1

        intakeMotor.setPower(intake - outtake);
    }

    public void tankDrive() {
        float leftStickY;
        float rightStickY;

        leftStickY = -gamepad1.left_stick_y;
        rightStickY = -gamepad1.right_stick_y;

        leftDrive.setPower(leftStickY);
        rightDrive.setPower(rightStickY);
    }

    public void arcadeDrive() {
        float leftStickY;
        float rightStickX;

        leftStickY = -gamepad1.left_stick_y;
        rightStickX = gamepad1.right_stick_x;

        leftDrive.setPower(leftStickY + rightStickX);
        rightDrive.setPower(leftStickY - rightStickX);
    }

    public void carDrive() {
        float forward;
        float backward;
        float turn;

        forward = gamepad1.right_trigger;
        backward = gamepad1.left_trigger;
        turn = gamepad1.right_stick_x;

        leftDrive.setPower((forward - backward) + turn);
        rightDrive.setPower((forward - backward) - turn);
    }

}
