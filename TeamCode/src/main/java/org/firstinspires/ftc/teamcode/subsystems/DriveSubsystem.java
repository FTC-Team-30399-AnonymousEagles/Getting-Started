package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem {
    public DcMotor leftDrive;
    public DcMotor rightDrive;

    public DriveSubsystem(@NonNull HardwareMap hardwareMap) {
        leftDrive = hardwareMap.get(DcMotor.class, "lmotor");
        rightDrive = hardwareMap.get(DcMotor.class, "rmotor");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void tankDrive(double leftStickY, double rightStickY) {
        leftDrive.setPower(leftStickY);
        rightDrive.setPower(rightStickY);
    }

    public void arcadeDrive(double leftStickY, double rightStickX) {
        leftDrive.setPower(leftStickY + rightStickX);
        rightDrive.setPower(leftStickY - rightStickX);
    }

    public void carDrive(double forward, double backward, double turn) {
        // forward = gamepad1.right_trigger;
        // backward = gamepad1.left_trigger;
        // turn = gamepad1.right_stick_x;

        leftDrive.setPower((forward - backward) + turn);
        rightDrive.setPower((forward - backward) - turn);
    }
}
