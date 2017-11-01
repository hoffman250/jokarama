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
    private TextView mLine1Field;
    private TextView mLine2Field;
    private TextView mLine3Field;
    private TextView mLine4Field;
    private TextView mLine5Field;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);

        mNameField = (TextView)v.findViewById(R.id.joke_name);
        mNameField.setText(mJoke.getName());

        mLine1Field = (TextView)v.findViewById(R.id.joke_line_1);
        mLine1Field.setText(mJoke.getLine1());

        mLine2Field = (TextView)v.findViewById(R.id.joke_line_2);
        mLine2Field.setText(mJoke.getLine2());

        mLine3Field = (TextView)v.findViewById(R.id.joke_line_3);
        mLine3Field.setText(mJoke.getLine3());

        mLine4Field = (TextView)v.findViewById(R.id.joke_line_4);
        mLine4Field.setText(mJoke.getLine4());

        mLine5Field = (TextView)v.findViewById(R.id.joke_line_5);
        mLine5Field.setText(mJoke.getLine5());


        return v;
    }
}
