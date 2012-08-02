package com.example.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class ToDoListActivity extends Activity implements NewItemFragment.OnNewItemAddedListener {
  
  private ToDoItemAdapter aa;
  private ArrayList<ToDoItem> todoItems;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Inflate your view
    setContentView(R.layout.main);
      
    // Get references to the Fragments
    FragmentManager fm = getFragmentManager();
    ToDoListFragment todoListFragment = 
      (ToDoListFragment)fm.findFragmentById(R.id.ToDoListFragment);

    // Create the array list of to do items
    todoItems = new ArrayList<ToDoItem>();
     
    // Create the array adapter to bind the array to the listview
    int resId = R.layout.todolist_item;
    aa = new ToDoItemAdapter(this, resId, todoItems);
     
    // Bind the array adapter to the listview.
    todoListFragment.setListAdapter(aa);
  }
  
  public void onNewItemAdded(String newItem) {
    ToDoItem newToDoItem = new ToDoItem(newItem);
    todoItems.add(newToDoItem);
    aa.notifyDataSetChanged();
  }

}