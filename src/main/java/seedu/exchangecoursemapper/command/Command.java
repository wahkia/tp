package seedu.exchangecoursemapper.command;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;

public abstract class Command {
    public static final String FILE_PATH = "/database.json";

    public JsonObject createJsonObject() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(FILE_PATH);
        if (inputStream == null) {
            throw new IOException();
        }
        JsonReader jsonReader = Json.createReader(inputStream);
        return jsonReader.readObject();
    }

    public abstract void execute(String userInput);
}
