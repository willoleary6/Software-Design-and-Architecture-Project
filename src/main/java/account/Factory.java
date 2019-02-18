package account;

import org.json.JSONObject;

abstract public class Factory {

    public abstract User createUser(JSONObject user);
}
