package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

public class DriveTeleopCommand extends CommandBase {
    DriveSubsystem m_drive;
    Gamepad gamepad1;

    public DriveTeleopCommand(DriveSubsystem m_drive, Gamepad gamepad1) {
        this.m_drive = m_drive;
        this.gamepad1 = gamepad1;
    }

    @Override
    public void initialize() {
        m_drive.tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
    }
}
