package route.com.todoapp.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import route.com.todoapp.Adapters.EventsListAdapter;
import route.com.todoapp.Model.Event;
import route.com.todoapp.R;
import route.com.todoapp.View.Base.NobelActivity;
import route.com.todoapp.ViewModels.EventListViewModel;

public class EventsListActivity extends NobelActivity {

    RecyclerView recyclerView;
    EventsListAdapter adapter;
    LinearLayoutManager layoutManager;
    EventListViewModel eventListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recyclerview);
        adapter=new EventsListAdapter(this);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        eventListViewModel= ViewModelProviders.of(this).get(EventListViewModel.class);
        SubscribeBaseObservers(eventListViewModel);

        eventListViewModel.getEvents().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                adapter.setItems(events);
            }
        });

        eventListViewModel.FetchEvents();
    }

}
