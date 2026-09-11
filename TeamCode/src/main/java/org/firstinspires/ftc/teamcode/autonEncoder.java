package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
@Disabled
public class autonEncoder extends LinearOpMode {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private ElapsedTime runtime = new ElapsedTime();
    static final double COUNTS_PER_MOTOR_REV = 0;
    static final double DRIVE_GEAR_REDUCTION = 0.0;
    static final double WHEEL_DIAMETER_INCHES = 0.0;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV *
            DRIVE_GEAR_REDUCTION)
            / (WHEEL_DIAMETER_INCHES * 3.1415);

    @Override
    public void runOpMode() {}


}
