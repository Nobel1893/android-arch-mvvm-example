package com.nobel.baseapp.Repos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import com.nobel.baseapp.DataBase.Dao.ToDoDao;
import com.nobel.baseapp.Model.Todo;
import com.nobel.baseapp.DataBase.TodoDataBase;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class TodoRepository {

    ToDoDao toDoDao;
    LiveData<List<Todo>> Todos;

    public TodoRepository (Application application){
        toDoDao= TodoDataBase.getInstance(application).toDoDao();
    }



    public LiveData<List<Todo>> getAllTodos(){
        Todos=toDoDao.getAllTodo();
        if(Todos.getValue()!=null)
        Log.e("size",Todos.getValue().size()+" ");
        return Todos;

    }

    public void InsertTodo(Todo todo){
        new InsertTodoAssync(toDoDao).execute(todo);
    }


    private  static class InsertTodoAssync extends AsyncTask<Todo,Void,Void>{

        ToDoDao toDoDao;


         InsertTodoAssync(ToDoDao toDoDao) {
            this.toDoDao = toDoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {

            Log.e("adding","final"+todos[0].toString());
            toDoDao.AddTodo(todos[0]);
            return null;
        }

    }


}
