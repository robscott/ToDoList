package com.example.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.util.Log;

public class ToDoItem {
  String task;
  Date created;
  
  public String getTask() {
    return task;
  }
  
  public Date getCreated() {
    return created;
  }
  
  public ToDoItem(String _task) {
    this(_task, new Date(java.lang.System.currentTimeMillis()));
  }
  
  public ToDoItem(String _task, Date _created) {
    task = _task;
    created = _created;
  }
  
  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    String dateString = sdf.format(created);
    Log.i("foo ==> ", "("+dateString+") "+task);
    return "("+dateString+") "+task;
  }
}
