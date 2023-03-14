package org.firstinspires.ftc.teamcode.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import org.firstinspires.ftc.teamcode.Projects.hi;
@Autonomous(name = "BasicAuto")
public class BasicAuto extends LinearOpMode{
    enum Parking{
        Right,
        Left
    }
    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();
    public hi robot = new hi();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map
        robot.init(hardwareMap);
        ParkingAUTO.Parking a = ParkingAUTO.Parking.Right;

        int direction = 1;
        int otherDirection = -1;
        boolean isRight = true;

        while(!isStarted()){


                previousGamepad1.copy(currentGamepad1);
                currentGamepad1.copy(gamepad1);


            if (currentGamepad1.right_bumper && !previousGamepad1.right_bumper){

                isRight = !isRight;
            }
            if (isRight){

                a = ParkingAUTO.Parking.Right;
            }
            else{

                a = ParkingAUTO.Parking.Left;
            }
            telemetry.addData("Parking",a);
            telemetry.update();

        }
        waitForStart(); //wait for play button to be pressed
        // autonomous happens here
        if(a == ParkingAUTO.Parking.Right) {
            // right side here
            //score preloaded
            robotMove(1.5);
            robotRight(1);
            robotMove(0.25);
            robotLeft(1);
            // lift code here
            robotLeft(1);
            robotMove(1.75);
            //lift code: pick up cone
            robotRight(2);
            robotMove(1.75);
            robotLeft(1);

        }
        else {
            // left side code here
            //score preloaded
            robotMove(1.5);
            robotLeft(1);
            robotMove(0.25);
            robotRight(1);
            // lift code here
            robotRight(1);
            robotMove(1.75);
            //lift code: pick up cone
            robotRight(2);
            robotMove(1.75);
            robotLeft(1);

        }


    }
    public void robotRight(double numOfDegrees){
        robot.fLeftWheel.setPower(1);
        robot.bLeftWheel.setPower(1);
        robot.fRightWheel.setPower(-1);
        robot.bRightWheel.setPower(-1);
        sleep((long) (2000*numOfDegrees));
        robot.fLeftWheel.setPower(0);
        robot.bLeftWheel.setPower(0);
        robot.fRightWheel.setPower(0);
        robot.bRightWheel.setPower(0);
    }

    public void robotMove(double numOfSquares){

        robot.fLeftWheel.setPower(1);
        robot.bLeftWheel.setPower(1);
        robot.fRightWheel.setPower(1);
        robot.bRightWheel.setPower(1);
        sleep((long) (2000*numOfSquares));
        robot.fLeftWheel.setPower(0);
        robot.bLeftWheel.setPower(0);
        robot.fRightWheel.setPower(0);
        robot.bRightWheel.setPower(0);

    }
    public void robotLeft(double numOfDegrees){
        robot.fLeftWheel.setPower(-1);
        robot.bLeftWheel.setPower(-1);
        robot.fRightWheel.setPower(1);
        robot.bRightWheel.setPower(1);
        sleep((long) (2000*numOfDegrees));
        robot.fLeftWheel.setPower(0);
        robot.bLeftWheel.setPower(0);
        robot.fRightWheel.setPower(0);
        robot.bRightWheel.setPower(0);
    }
}
