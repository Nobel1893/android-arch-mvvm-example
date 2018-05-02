package com.nobel.baseapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.nobel.baseapp.DataBase.Dao.ToDoDao;
import com.nobel.baseapp.DataBase.TodoDataBase;
import com.nobel.baseapp.Model.Todo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/26/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

@RunWith(AndroidJUnit4.class)
public class TodoDaoUnitTest {

    ToDoDao toDoDao;
    TodoDataBase dataBase;

    @Before
    public void CreateDb(){
        Context context= InstrumentationRegistry.getContext();
        dataBase= Room.inMemoryDatabaseBuilder(context,TodoDataBase.class).build();
        toDoDao=dataBase.toDoDao();
    }

    @After
    public void CloseDb(){
        dataBase.close();
    }

    @Test
    public void InsertIsCorrect(){
        Todo todo=new Todo("title1","content1");
        toDoDao.AddTodo(todo);
        List<Todo>result=toDoDao.getTodo(todo.getTitle());
        assertThat(result.get(0).getTitle(),equalTo(todo.getTitle()));

    }

    @Test
    public void DeleteIsCorrect(){
        Todo todo=new Todo("title1","content1");
        toDoDao.AddTodo(todo);
        List<Todo>result=toDoDao.getTodo(todo.getTitle());
        toDoDao.DeleteTodoItem(result.get(0));
        result=toDoDao.getTodo(todo.getTitle());
        assertThat(result.size(),equalTo(0));
    }
}
