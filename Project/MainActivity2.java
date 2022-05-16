package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
        implements View.OnClickListener{

    //This will change as time passes
    private ProgressBar progressBar;
    // This measures the number of steps of time taken from 100.
    public int progressStatus = 100;
    // This handler is need to updated the progressbar and text view
    private Handler handler = new Handler();

    ImageView imageView1, imageView2, imageView3;
    Button button2, button3, button4,button5, button6, button7, button8, button9, button10, button11,
            button12, button13, button14, button15, button16, button17;
    TextView textView6;

    //Set the chance be 0 before starting game
    int chance = 0;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Get progress bar and text view from XML
        progressBar = findViewById(R.id.progressBar);
        textView6 = findViewById(R.id.textView6);

        //Run a separate thread, which runs concurrently with the main thread
        new Thread(new Runnable() {
            public void run() {

                //Keep running for 100 steps
                while (progressStatus > 0) {
                    progressStatus--;

                    //Update progress bar and display current value in text view 6.
                    // Note that we have to do this via the handler, otherwise an exception occurs.
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView6.setText(progressStatus + " / " + progressBar.getMax());
                        }
                    });

                    //pause for 400 milliseconds and then resume
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        timeOut();

        initObjects();
    }

    public void timeOut() {

        //if the time is out, it will be game over
        if (progressStatus == 0) {
            Intent intent1 = new Intent(this, MainActivity4.class);
            startActivity(intent1);
        }
    }

    public void initObjects() {

        //Get image view and buttons from XML
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);
        button17 = (Button) findViewById(R.id.button17);

        //Set button to use method below when clicked
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
        button17.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button2:
                wrongButtonClicked();
                break;
            case R.id.button3:
                wrongButtonClicked();
                break;
            case R.id.button4:
                wrongButtonClicked();
                break;
            case R.id.button5:
                wrongButtonClicked();
                break;
            case R.id.button6:
                wrongButtonClicked();
                break;
            case R.id.button7:
                wrongButtonClicked();
                break;
                //Button 8 will be the correct answer only
            case R.id.button8:
                correctButtonClicked();
                break;
            case R.id.button9:
                wrongButtonClicked();
                break;
            case R.id.button10:
                wrongButtonClicked();
                break;
            case R.id.button11:
                wrongButtonClicked();
                break;
            case R.id.button12:
                wrongButtonClicked();
                break;
            case R.id.button13:
                wrongButtonClicked();
                break;
            case R.id.button14:
                wrongButtonClicked();
                break;
            case R.id.button15:
                wrongButtonClicked();
                break;
            case R.id.button16:
                wrongButtonClicked();
                break;
            case R.id.button17:
                wrongButtonClicked();
                break;
        }
    }

    //if clicked the wrong button, the hp value (heart) will be lose.
    //totally, players have 3 times of chances
    //if all chances are missed, it will jump to game over page
    //0,1,2 will be the times of counting the wrongButtonClicked, which part should be run
    public void wrongButtonClicked() {

        if (chance == 0) {
            wrongButtonClickedFirstTime();
        }else if (chance == 1) {
            wrongButtonClickedSecondTime();
        }else if (chance == 2) {
            wrongButtonClickedThirdTime();
            Intent intent = new Intent(this, MainActivity4.class);
            startActivity(intent);
        }
    }

    private void wrongButtonClickedFirstTime() {

        //Heart image will disappear as the ans is wrong
        Animation a = new TranslateAnimation(Animation.ABSOLUTE+0, Animation.ABSOLUTE+0,
        Animation.ABSOLUTE+0, Animation.ABSOLUTE+500);

        //Run for 1.5 second = 1500 milliseconds
        a.setDuration(1500);

        a.setAnimationListener(new Animation.AnimationListener() {
            float tempX, tempY;

            @Override
            public void onAnimationStart(Animation a) {
                tempX = imageView3.getX();
                tempY = imageView3.getY();
            }

            @Override
            public void onAnimationEnd (Animation a) {
                imageView3.setX(tempX);
                imageView3.setY(tempY+500);
            }

            @Override
            public void onAnimationRepeat (Animation a) {
                //Deliberately empty
            }
        });

        //Show above animation in image view 3
        //That mease the heart in right hand side will be lose
        imageView3.startAnimation(a);

        //Chance need to +1, as need to count the chance
        //If you click wrong once, the chance will count 1
        chance++;
    }

    private void wrongButtonClickedSecondTime() {

        //Second heart image will disappear as the ans is wrong
        Animation a = new TranslateAnimation(Animation.ABSOLUTE+0, Animation.ABSOLUTE+0,
                Animation.ABSOLUTE+0, Animation.ABSOLUTE+500);

        //Run for 1.5 second = 1500 milliseconds
        a.setDuration(1500);

        a.setAnimationListener(new Animation.AnimationListener() {
            float tempX, tempY;

            @Override
            public void onAnimationStart(Animation a) {
                tempX = imageView2.getX();
                tempY = imageView2.getY();
            }

            @Override
            public void onAnimationEnd (Animation a) {
                imageView2.setX(tempX);
                imageView2.setY(tempY+500);
            }

            @Override
            public void onAnimationRepeat (Animation a) {
                //Deliberately empty
            }
        });

        //Show above animation in image view 2
        //That mease the heart in middle will be lose
        imageView2.startAnimation(a);

        chance++;
    }

    private void wrongButtonClickedThirdTime() {

        //Third heart image will disappear as the ans is wrong
        Animation a = new TranslateAnimation(Animation.ABSOLUTE+0, Animation.ABSOLUTE+0,
                Animation.ABSOLUTE+0, Animation.ABSOLUTE+500);

        //Run for 1.5 second = 1500 milliseconds
        a.setDuration(1500);

        // Using X Y be the loaction point
        a.setAnimationListener(new Animation.AnimationListener() {
            float tempX, tempY;

            @Override
            //Set the beginning location
            public void onAnimationStart(Animation a) {
                tempX = imageView1.getX();
                tempY = imageView1.getY();
            }

            @Override
            //Set the end location
            public void onAnimationEnd (Animation a) {
                imageView1.setX(tempX);
                imageView1.setY(tempY+500);
            }

            @Override
            //No need to repeat, so empty here
            public void onAnimationRepeat (Animation a) {
                //Deliberately empty
            }
        });

        //Show above animation in image view 1
        //That mease the heart in left hand side will be lose
        imageView1.startAnimation(a);

        //No need to type chance++;, as it alreay lose the game
    }

    public void correctButtonClicked() {

        // Players clicked the correct answer
        // So, game is end and jump to congratulation page
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}