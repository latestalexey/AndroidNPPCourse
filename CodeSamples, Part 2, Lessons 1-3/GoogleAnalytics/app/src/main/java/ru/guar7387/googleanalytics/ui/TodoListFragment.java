package ru.guar7387.googleanalytics.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ru.guar7387.googleanalytics.R;
import ru.guar7387.googleanalytics.data.TodoItem;
import ru.guar7387.googleanalytics.fab.FabGenerator;
import ru.guar7387.googleanalytics.fab.FloatingActionButton;
import ru.guar7387.googleanalytics.utils.SwipeToDismissTouchListener;
import ru.guar7387.googleanalytics.utils.analytics.MyApplication;

public class TodoListFragment extends Fragment {

    public static final String KEY = "items_key";

    private ListView mListView;

    private TodoListAdapter mAdapter;

    private MyApplication application;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.todo_list_fragment, container, false);

        application = (MyApplication) getActivity().getApplication();
        application.sendScreenReport(TodoListFragment.class.getSimpleName());

        ArrayList<TodoItem> items = getArguments().getParcelableArrayList(KEY);
        mAdapter = new TodoListAdapter(getActivity(), 0, items);
        initListView(root);
        initFab(root);
        return root;
    }

    private void initListView(View root) {
        mListView = (ListView) root.findViewById(R.id.todosList);

        mListView.setAdapter(mAdapter);
        mListView.setEmptyView(root.findViewById(android.R.id.empty));
        SwipeToDismissTouchListener swipeTouch = new SwipeToDismissTouchListener(mListView,
                new SwipeToDismissTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(int position) {
                        return true;
                    }

                    @Override
                    public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                        for (int position : reverseSortedPositions) {
                            TodoItem todoItem = mAdapter.getItem(position);
                            ((OnTodoItemRemoved) getActivity()).onTodoItemRemove(todoItem);
                            mAdapter.remove(todoItem);
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                });
        mListView.setOnTouchListener(swipeTouch);
        mListView.setOnScrollListener(swipeTouch.makeScrollListener());
    }

    private void initFab(View root) {
        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        FabGenerator.createFab(getActivity().getApplicationContext(), fab, R.drawable.fab_plus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                application.sendEventReport(TodoListFragment.class.getSimpleName(), "Fab click", "User wants to add new task");
                ((OnCreateTodo) getActivity()).onCreateTodo();

            }
        });
        fab.attachToListView(mListView);
    }
}
