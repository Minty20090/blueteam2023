package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Projects.hi;
@TeleOp(name = "TestTeleop")

public class TestTeleop extends LinearOpMode {
    public hi robot = new hi();


    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        int rightPosition = 0;
        int leftPosition = 0;
        int[] positions;
        double speed = .5;

        waitForStart();
        boolean isSpinning = false;

        while (opModeIsActive()) {
            if(gamepad1.a == true) {
                robot.fLeftWheel.setPower(.3);
                robot.bLeftWheel.setPower(.3);
                robot.fRightWheel.setPower(.3);
                robot.bRightWheel.setPower(.3);
                sleep(1700);
                robot.fLeftWheel.setPower(0);
                robot.bLeftWheel.setPower(0);
                robot.fRightWheel.setPower(0);
                robot.bRightWheel.setPower(0);
            }
            if (gamepad1.b == true) {
                robot.fLeftWheel.setPower(-.3);
                robot.bLeftWheel.setPower(-.3);
                robot.fRightWheel.setPower(.3);
                robot.bRightWheel.setPower(.3);
                sleep(1200);
                robot.fLeftWheel.setPower(0);
                robot.bLeftWheel.setPower(0);
                robot.fRightWheel.setPower(0);
                robot.bRightWheel.setPower(0);
            }
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            robot.fLeftWheel.setPower(frontLeftPower*speed);
            robot.bLeftWheel.setPower(backLeftPower*speed);
            robot.fRightWheel.setPower(frontRightPower*speed);
            robot.bRightWheel.setPower(backRightPower*speed);




        }


    }


}
