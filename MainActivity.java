/**
 * MazeDemo1
 * @author Mr. Minich
 */

package com.minich.mazedemo1;

// original default imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// imports added for this demo
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private GameBoardView maze1; // custom view for this program's Activity
                                // not using the default R.layout.activity_main

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);  // bring in any saved property values from a previous execution of this app

        // setContentView(R.layout.activity_main);  // not using the default activity_main XML resource

        maze1 = new GameBoardView(this);
        setContentView(maze1);
    }

    // private "inner" class to provide
    private class GameBoardView extends View
    {

        // "other" constructor
        public GameBoardView(Context context)
        {
            super(context);         // calling the "other" constructor of the parent View class
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);

            int screenWidth = getWidth();      // width of the View object (i.e. canvas width)
            int screenHeight = getHeight();    // canvas height (TODO: figure out how to account for height of action bar)

            // creating Paint objects to serve as reusable brushes (fill) and pens (stroke)

            Paint paint = new Paint();              // general, miscellaneous paint tasks

            // paint the background of the View's canvas
            paint.setColor(Color.BLACK);
            canvas.drawPaint(paint);


            Paint redBrush = new Paint();           // red, filled paintbrush
            redBrush.setColor(Color.RED);
            redBrush.setStyle(Paint.Style.FILL);

            Paint greenPen = new Paint();           // green "pen" that does not fill
            greenPen.setColor(Color.GREEN);
            greenPen.setStyle(Paint.Style.STROKE);  // creating a "pen" that does not fill in regions
            greenPen.setStrokeWidth(10);            // width of the pen's stroke
            greenPen.setAntiAlias(true);            // smooth edges

            int leftEndpointX = 0;
            int leftEndpointY = 0;
            int rightEndpointX = screenWidth;
            int rightEndpointY = screenHeight;

            canvas.drawLine(leftEndpointX, leftEndpointY, rightEndpointX, rightEndpointY, greenPen);
        }

    }// end of GameBoardView class

}// end of MainActivity class

/*
Questions to be able to answer.

Do we (here at Wyo, acc to Mr Minich)  start with Empty rather than Blank Activity)?

What is an activity?

What is a view?

What is R.layout.activity_main?

How is the keyword super used?

How is a private, inner class used?

How is the keyword extends used?

What is a Paint object?

What is the canvas parameter?

What is Color.GREEN?

What is Paint.Style.STROKE?

How is drawLine used (describe its parameters and give an example)?

 */