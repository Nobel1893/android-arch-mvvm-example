package route.com.todoapp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/22/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

@Entity(tableName ="todos")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo()
    public String title;
    @ColumnInfo()
    public String content;


    public Todo(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Ignore
    public Todo( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "id : "+id+" title : "+title+" content: "+content;
    }
}
