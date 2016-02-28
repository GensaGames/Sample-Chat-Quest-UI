package example.genka.fosquest.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import example.genka.fosquest.MainActivity;
import example.genka.fosquest.R;
import example.genka.fosquest.adapter.FavouriteGridAdapter;
import example.genka.fosquest.adapter.MessageListAdapter;
import example.genka.fosquest.model.Message;
import example.genka.fosquest.utils.StaticData;
/**
 * Created by Genka on 27.10.2015.
 */
public class MessagesFragment extends Fragment {

    public final static long SIMULATE_PROGRESS = 5000;

    private View messages;
    private RecyclerView mRecyclerView;
    private MessageListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        messages = inflater.inflate(R.layout.messages_fragment, container, false);

        setRecycleView();
        addNewMessage();

        updateMessageTime();
        loadMessages();

        return messages;

    }

    private void addNewMessage() {
        final EditText editMessage = (EditText) messages.findViewById(R.id.message_edit_text);
        ImageView imageSend = (ImageView) messages.findViewById(R.id.message_image_send);

        imageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message(MainActivity.getMyContact(),
                        editMessage.getText().toString(), "Just now", true);
                mAdapter.addMessage(message);
                editMessage.setText("");
                mLayoutManager.scrollToPosition(mAdapter.getItemCount() - 1);
            }
        });

    }


    private void setRecycleView() {

        mRecyclerView = (RecyclerView) messages.findViewById(R.id.recycler_view_messages);

        mLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MessageListAdapter(getContext(), StaticData.getListMessages(12));
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager.scrollToPosition(mAdapter.getItemCount() - 1);
        mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    public void updateMessageTime () {

        /** Use function to update and calculate
         *  time difference
         *  TODO: Calculate time difference
         *  */
    }

    public void loadMessages() {

        /** Add new portion to messages list
         *  using SwipeToRefresh
         *  TODO: Realize SwipeToRefresh
         *  */

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout)
                messages.findViewById(R.id.activity_main_swipe_refresh_layout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}
