package route.com.todoapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import route.com.todoapp.Model.Todo;
import route.com.todoapp.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {

    List items;
    LayoutInflater inflater;

    public TodoListAdapter(Context context){
        inflater=LayoutInflater.from(context);

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name;

        ViewHolder(View view){
            super(view);
        name =view.findViewById(R.id.name);
        }
    }

    public void setItems(List items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= inflater.inflate(R.layout.card_item_todo_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Todo item=(Todo)items.get(position);
        holder.name.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        if (items!=null)
            return items.size();
        return 0;
    }
}