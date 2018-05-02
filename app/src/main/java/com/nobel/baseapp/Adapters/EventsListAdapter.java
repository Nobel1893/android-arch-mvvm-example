package com.nobel.baseapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.nobel.baseapp.Model.Event;
import com.nobel.baseapp.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.ViewHolder> {

    List items;
    LayoutInflater inflater;

    public EventsListAdapter(Context context){
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

        View view= inflater.inflate(R.layout.card_item_event,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Event item=(Event) items.get(position);
        holder.name.setText(item.getEventName());
    }

    @Override
    public int getItemCount() {
        if (items!=null)
            return items.size();
        return 0;
    }
}
