package untref.tesis.gio.presentation.domain;


import android.util.Log;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

public class BodyParser {

    private JSONObject bodyJson;

    public BodyParser(ResponseBody body) {
        try {
            bodyJson = new JSONObject(body.string());
        } catch (JSONException e) {
            Log.i("parser", e.getMessage(), e);
        } catch (IOException e) {
            Log.i("parser", e.getMessage(), e);
        }
    }

    public String getMessage() {
        try {
            return bodyJson.getString("message");
        } catch (JSONException e) {
            return StringUtils.EMPTY;
        }
    }

}
