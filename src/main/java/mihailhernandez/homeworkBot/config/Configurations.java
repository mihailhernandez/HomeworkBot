package mihailhernandez.homeworkBot.config;

import mihailhernandez.homeworkBot.model.Repository;
import mihailhernandez.homeworkBot.model.User;

//@JsonDeserialize(using = ConfigurationDeserializer.class, as = Configurations.class)
public class Configurations {

    private User user;
    private Repository repository;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
