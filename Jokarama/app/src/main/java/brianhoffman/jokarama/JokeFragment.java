package brianhoffman.jokarama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brianhoffman on 10/30/17.
 */

public class JokeFragment extends Fragment {
    private Joke mJoke;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mJoke = new Joke();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);
        return v;
    }
}
