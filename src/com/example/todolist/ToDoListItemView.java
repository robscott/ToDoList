package com.example.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class ToDoListItemView extends TextView {
  
  public ToDoListItemView(Context context, AttributeSet ats, int ds) {
    super(context, ats, ds);
    init();
  }

  public ToDoListItemView(Context context) {
    super(context);
    init();
  }

  public ToDoListItemView(Context context, AttributeSet ats) {
    super(context, ats);
    init();
  }
  
  
  private Paint marginPaint;
  private Paint linePaint;
  private int paperColor;
  private float margin;
  
  private void init() {
    // Get a reference to our resources table
    Resources myResources = getResources();
    
    // Create the paint brushes we will use in the onDraw method
    marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
    linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    linePaint.setColor(myResources.getColor(R.color.notepad_lines));
    
    // Get the proper background color and the margin width
    paperColor = myResources.getColor(R.color.notepad_paper);
    margin = myResources.getDimension(R.dimen.notepad_margin);
  }
  
  @Override
  public void onDraw(Canvas canvas) {
    
    // Color as paper
    canvas.drawColor(paperColor);
    
    // Draw ruled lines
    canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
    canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);
    
    // Draw margin
    canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);
    
    // Move the text across from the margin
    canvas.save();
    canvas.translate(margin, 0);

    // Use the base TextView to render the text
    super.onDraw(canvas);
    canvas.restore();
  }
}
