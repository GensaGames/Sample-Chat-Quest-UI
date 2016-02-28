package example.genka.fosquest.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.genka.fosquest.R;
import example.genka.fosquest.adapter.FavouriteGridAdapter;
import example.genka.fosquest.utils.StaticData;

/**
 * Created by Genka on 27.10.2015.
 */
public class FavouritesFragment extends Fragment {

    public final static int GRID_COLUMN = 2;
    private View favourites;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        favourites = inflater.inflate(R.layout.favourites_fragment, container, false);
        setRecycleView();

        return favourites;

    }




    private void setRecycleView() {
        RecyclerView mRecyclerView;
        RecyclerView.LayoutManager mLayoutManager;
        FavouriteGridAdapter mAdapter;

        mRecyclerView = (RecyclerView)favourites.findViewById(R.id.recycler_view_favourite);

        mLayoutManager = new GridLayoutManager(getContext(), GRID_COLUMN);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FavouriteGridAdapter(getContext(), StaticData.getListContacts(7, true));
        mRecyclerView.setAdapter(mAdapter);
    }
}
