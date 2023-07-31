package com.example.to_dolist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.to_dolist.database.AppDatabase;
import com.example.to_dolist.database.TaskEntry;

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int mTaskId) {
        task = database.taskDao().loadTaskById(mTaskId);
    }

    public LiveData<TaskEntry> getTask(){
        return task;
    }
}
