package brianhoffman.jokarama;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by brianhoffman on 10/30/17.
 */

public class JokeRepo {
    private static JokeRepo sJokeRepo;
    private List<Joke> mJokes;

    public static JokeRepo get(Context context) {
        if (sJokeRepo == null) {
            sJokeRepo = new JokeRepo(context);
        }
        return sJokeRepo;
    }

    private JokeRepo(Context context) {
        mJokes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Joke joke = new Joke();
            joke.setName("Joke " + i);
            joke.setLine1("Knock knock");
            joke.setLine2("Who's there?");
            joke.setLine3("Androidisa");
            joke.setLine4("Androidisa who?");
            joke.setLine5("Androidisa painintheass.");
            mJokes.add(joke);
        }
    }

    public List<Joke> getJokes() {
        return mJokes;
    }

    public Joke getJoke(UUID id) {
        for (Joke joke : mJokes) {
            if (joke.getId().equals(id)) {
                return joke;
            }
        }
        return null;
    }
}
