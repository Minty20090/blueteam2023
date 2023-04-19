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
//        robot.baseLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.firstJointLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.baseLift.setTargetPosition(0);
//        robot.firstJointLift.setTargetPosition(0);
//        robot.baseLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.firstJointLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);


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
//             Bumpers - move wrist up and down
//             right and left trigger - open and close claw respectively

            if(gamepad1.b == true){
                robot.firstJointLift.setPower(1);
            }
            else if (gamepad1.a == true) {
                robot.firstJointLift.setPower(-1);
            }
            else {
                robot.firstJointLift.setPower(0);
            }


            if (gamepad1.x == true) {
                robot.baseLift.setPower(-1);
            }
            else if(gamepad1.y == true){
                robot.baseLift.setPower(1);
            }
            else {
                robot.baseLift.setPower(0);
            }

            double currentPosition = robot.wrist.getPosition();

            if(gamepad1.right_bumper == true) {
                // make wrist go up
                currentPosition = robot.wrist.getPosition();
                if (currentPosition <=1){
                    robot.wrist.setPosition( currentPosition + .01);
                }

            }
            if(gamepad1.left_bumper == true) {
                //make wrist go down//
                currentPosition = robot.wrist.getPosition();
                robot.wrist.setPosition(currentPosition - .01);
            }

            if(gamepad1.right_trigger >.3) {
                //open claw
                robot.clawRight.setPosition(1);
                robot.clawRight.setPosition(1);
            }
            if(gamepad1.left_trigger > .3) {
                //close claw
                robot.clawRight.setPosition(0);
                robot.clawRight.setPosition(0);
            }
            if (gamepad1.x == true){

            }
            telemetry.addLine("first joint encoder count: " + robot.firstJointLift.getCurrentPosition() );
            telemetry.addLine("target position: " + robot.firstJointLift.getTargetPosition() );
            telemetry.addLine("base lift encoder count: " + robot.baseLift.getCurrentPosition() );
            telemetry.addLine("target position: " + robot.baseLift.getTargetPosition() );

            telemetry.update();

        }


    }
    void baseLiftMotorControl(int tolerance, boolean lock){
        int difference = Math.abs(robot.baseLift.getTargetPosition() - robot.baseLift.getCurrentPosition());
        int check=102930293;
        while(difference > tolerance) {

            difference = Math.abs(robot.baseLift.getTargetPosition() - robot.baseLift.getCurrentPosition());

            robot.baseLift.setPower(0.1);
            sleep(100);
            if (difference == Math.abs(robot.baseLift.getTargetPosition() - robot.baseLift.getCurrentPosition())){
                break;
            }


        }
        robot.baseLift.setTargetPosition(robot.baseLift.getCurrentPosition());

        if(!lock)
        {
            robot.baseLift.setPower(0);
            robot.firstJointLift.setPower(0);
        }

    }
    void firstJointLiftControl(int tolerance, boolean lock){
        int difference = Math.abs(robot.firstJointLift.getTargetPosition() - robot.firstJointLift.getCurrentPosition());
        int check=102930293;
        while(difference > tolerance)

        {
            difference = Math.abs(robot.firstJointLift.getTargetPosition() - robot.firstJointLift.getCurrentPosition());
            robot.firstJointLift.setPower(0.1);
            sleep(100);
            if (difference == Math.abs(robot.firstJointLift.getTargetPosition() - robot.firstJointLift.getCurrentPosition())){
                break;
            }



        }

        robot.firstJointLift.setTargetPosition(robot.firstJointLift.getCurrentPosition());


        if(!lock)
        {
            robot.baseLift.setPower(0);
            robot.firstJointLift.setPower(0);
        }

}

}


//hi