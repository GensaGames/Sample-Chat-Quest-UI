package example.genka.fosquest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.genka.fosquest.R;
import example.genka.fosquest.adapter.ContactListAdapter;
import example.genka.fosquest.adapter.FavouriteGridAdapter;
import example.genka.fosquest.utils.ContactSort;
import example.genka.fosquest.utils.StaticData;

/**
 * Created by Genka on 27.10.2015.
 */
public class ContactsFragment extends Fragment {

    private View contacts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contacts = inflater.inflate(R.layout.contacts_fragment, container, false);

        setRecycleView();
        return contacts;

    }

    private void setRecycleView() {
        RecyclerView mRecyclerView;
        RecyclerView.LayoutManager mLayoutManager;
        ContactListAdapter mAdapter;

        mRecyclerView = (RecyclerView)contacts.findViewById(R.id.recycler_view_contacts);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ContactListAdapter( getContext(),
                ContactSort.sortAlphabetically(StaticData.getListContacts(15, false)));
        mRecyclerView.setAdapter(mAdapter);
    }
}
