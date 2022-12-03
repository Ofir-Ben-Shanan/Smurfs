package org.smurfs.json_streamer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.smurfs.smurf.Smurf;
import org.smurfs.utils.Constants;
import org.smurfs.utils.ErrorMessages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFilesIO implements IOStreamer {
    @Inject

    private static final Logger logger = LogManager.getLogger(JsonFilesIO.class);


    @Override
    public void write(String path, List<Smurf> data) {

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String json = objectWriter.writeValueAsString(data);
            FileWriter file = new FileWriter(Constants.JSON_FILE_PATH);
            file.write(json);
            file.close();
            logger.info(json);
        } catch (IOException e) {
            logger.error(ErrorMessages.FILE_WRITING_ERROR.getError() + path);
        }
    }

    public <T> T read(String path) {
        Gson gson = new Gson();
        try {
            return gson.fromJson(new FileReader(path), new TypeToken<List<Smurf>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            logger.error(ErrorMessages.FILE_WRITING_ERROR.getError() + path);
        }
        return null;

    }
}
