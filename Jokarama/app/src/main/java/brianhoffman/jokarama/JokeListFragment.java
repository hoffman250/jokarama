package brianhoffman.jokarama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by brianhoffman on 10/30/17.
 */

public class JokeListFragment extends Fragment {

    private RecyclerView mJokeRecyclerView;
    private JokeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_list, container, false);

        mJokeRecyclerView = (RecyclerView) view.findViewById(R.id.joke_recycler_view);
        mJokeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        JokeRepo jokeRepo = JokeRepo.get(getActivity());
        List<Joke> jokes = jokeRepo.getJokes();

        mAdapter = new JokeAdapter(jokes);
        mJokeRecyclerView.setAdapter(mAdapter);
    }

    private class JokeHolder extends RecyclerView.ViewHolder {
        public JokeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_joke, parent, false));
        }
    }

    private class JokeAdapter extends RecyclerView.Adapter<JokeHolder> {
        private List<Joke> mJokes;

        public JokeAdapter(List<Joke> jokes) {
            mJokes = jokes;
        }

        @Override
        public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new JokeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mJokes.size();
        }
    }
}
