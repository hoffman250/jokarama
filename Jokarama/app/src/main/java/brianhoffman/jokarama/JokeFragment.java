package brianhoffman.jokarama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by brianhoffman on 10/30/17.
 */

public class JokeFragment extends Fragment {

    private static final String ARG_JOKE_ID = "joke_id";

    private Joke mJoke;
    private TextView mNameField;

    public static JokeFragment newInstance(UUID jokeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_JOKE_ID, jokeId);

        JokeFragment fragment = new JokeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID jokeId = (UUID) getArguments().getSerializable(ARG_JOKE_ID);
        mJoke = JokeRepo.get(getActivity()).getJoke(jokeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);

        mNameField = (TextView)v.findViewById(R.id.joke_name);
//        mNameField.setText(mJoke.getName());

        return v;
    }
}
