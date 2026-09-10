package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class StarterBot extends LinearOpMode {
    private DcMotor leftDrive;
    private DcMotor rightDrive;

    private DcMotor intakeMotor;


    @Override
    public void runOpMode() {
        // Assigning motors to variables. Initilizing
        leftDrive = hardwareMap.get(DcMotor.class, "lmotor");
        rightDrive = hardwareMap.get(DcMotor.class, "rmotor");

        // Sets the direction of the motors to make sure the robot drives forward and doesn't spin
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait until start button is pressed
        waitForStart();

        while (opModeIsActive()) {
            carDrive();
            intake();
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

    }
}
