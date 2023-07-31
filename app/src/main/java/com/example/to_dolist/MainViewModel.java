package com.example.to_dolist;

import android.app.Application;
import android.nfc.Tag;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.to_dolist.database.AppDatabase;
import com.example.to_dolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainActivity.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
