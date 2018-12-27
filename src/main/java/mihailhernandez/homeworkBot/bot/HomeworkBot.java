package mihailhernandez.homeworkBot.bot;

import com.fasterxml.jackson.databind.ObjectMapper;
import mihailhernandez.homeworkBot.config.Configurations;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class HomeworkBot {

    private static HomeworkBot singleInstance = new HomeworkBot();
    private static Configurations configurations;
    private List<RunnerBot> runnerBots = new ArrayList<>();

    public static HomeworkBot getInstance() {
        return singleInstance;
    }

    public void start(String[] args) {
        String json = getJsonString(args);
        try {
            if (json == null) {
                throw new NullPointerException("Null json file.");
            }
            configurations = parseConfigurations(json);
            cloneRepository();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getJsonString(String[] args) {
        String jsonFile = null;
        Optional<String> optionalJsonFile = Arrays.stream(args)
                .filter(arg -> arg.contains(".json")).findFirst();
        try {
            jsonFile = new String(Files.readAllBytes(Paths.get(optionalJsonFile.get())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonFile;
    }

    private Configurations parseConfigurations(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Configurations.class);
    }

    private void cloneRepository() throws GitAPIException {
        Git.cloneRepository()
                .setURI(configurations.getRepository().getURI())
                .setDirectory(new File(configurations.getRepository().getDirectory()))
                .call();
    }
}
