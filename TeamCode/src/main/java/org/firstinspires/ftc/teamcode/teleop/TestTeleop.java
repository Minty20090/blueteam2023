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
        double speed = .9;



        waitForStart();
        boolean isSpinning = false;

        while (opModeIsActive()) {


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


            int liftHeight = 0;
            // =================================
            // DO NOT TEST MANUAL LIFT!!!!!!!
            // =================================
            if(gamepad1.left_bumper == true){


            } else {

            }

            if(gamepad1.right_bumper == true){


            } else {


            }

            // =============================
            // WHAT THE MOTORS ARE DOING
            // =============================
            // baseLift = encoders go from 0 to X, with 0 being down, and X being vertically up
            // firstJointRight and firstJointLeft = values are going to opposite (if right = x, then left = 1-x)
            // ***** IF ***** arm/wrist is going in the opposite direction, swap values for right and left !!

            // ====================
            // CONTROLS
            // ====================
//             A,B,Y - presets (ground, low, medium)
//             DPAD up and down - move wrist up and down
//             Bumpers - manual control of lift (DO NOT TOUCH!!!!!)
//             right and left trigger - open and close claw respectively


            if (gamepad1.a == true) {
                // arm1 down
                robot.baseLift.setTargetPosition(0);
                robot.baseLift.setPower(.5);
                // arm2 flat
                robot.firstJointRight.setPosition(1);
                robot.firstJointLeft.setPosition(0);
                // wrist flat
                robot.wrist.setPosition(1);
                liftHeight = 0;
            }
            if(gamepad1.b == true){
                // arm1 down
                robot.baseLift.setTargetPosition(0);
                robot.baseLift.setPower(.5);
                // arm2 up at 70~ degrees
                robot.firstJointRight.setPosition(.3);
                robot.firstJointLeft.setPosition(.7);
                // wrist flat
                robot.wrist.setPosition(.3);
                liftHeight = 100;
            }

            if(gamepad1.y == true){
                // arm1 is 110~ degrees up
                robot.baseLift.setTargetPosition(100);
                robot.baseLift.setPower(.5);
                // arm2 vertical 80-90 degrees
                robot.firstJointRight.setPosition(0);
                robot.firstJointLeft.setPosition(1);
                // wrist flat
                robot.wrist.setPosition(.3);
                liftHeight = 200;

            }
            if(gamepad1.dpad_up == true) {
                // make wrist go up
                robot.wrist.setPosition(robot.wrist.getPosition() + .05);
            }
            else if(gamepad1.dpad_down == true) {
                //make wrist go down//
                robot.wrist.setPosition(robot.wrist.getPosition() - .05);
            }

            if(gamepad1.right_trigger == 0) {
                //open claw
                robot.clawRight.setPosition(0);
                robot.clawRight.setPosition(1);
            }
            if(gamepad1.left_trigger == 0) {
                //close claw
                robot.clawRight.setPosition(1);
                robot.clawRight.setPosition(0);
            }




        }


    }


}


//hi