package route.com.todoapp.DataBase.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import route.com.todoapp.Model.Todo;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/22/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

@Dao
public interface ToDoDao {

    @Query("Select * from todos ")
    LiveData<List<Todo>> getAllTodo();

    @Insert
    void AddTodo(Todo item);

    @Delete
    void DeleteTodoItem(Todo item);

}
