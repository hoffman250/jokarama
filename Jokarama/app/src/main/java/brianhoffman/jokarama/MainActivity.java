package brianhoffman.jokarama;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    private static final String EXTRA_JOKE_ID = "brianhoffman.jokarama.joke_id";

    public static Intent newIntent(Context packageContext, UUID jokeId) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(EXTRA_JOKE_ID, jokeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID jokeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_JOKE_ID);
        return JokeFragment.newInstance(jokeId);
    }
}
