package brianhoffman.jokarama;

import java.util.UUID;

/**
 * Created by brianhoffman on 10/30/17.
 */

public class Joke {
    private UUID mId;
    private String mName;

    public Joke() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
