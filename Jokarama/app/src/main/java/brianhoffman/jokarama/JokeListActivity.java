package brianhoffman.jokarama;

import android.support.v4.app.Fragment;

/**
 * Created by brianhoffman on 10/30/17.
 */

public class JokeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JokeListFragment();
    }
}
