package route.com.todoapp.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import route.com.todoapp.DataBase.Dao.ToDoDao;
import route.com.todoapp.Model.Todo;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/22/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

@Database(entities = {Todo.class},version = 1)
public abstract class TodoDataBase extends RoomDatabase{

    private static String DBNAME="Todo-DataBase";
    public abstract ToDoDao toDoDao();

    private static  TodoDataBase dataBase;

    public  static TodoDataBase getInstance(Context context){

        if (dataBase==null)
            dataBase= Room.databaseBuilder(context.getApplicationContext(),TodoDataBase.class,DBNAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        return dataBase;
    }

}
