package mihailhernandez.homeworkBot.main;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MainTests {
    @Test
    public void mainMethodExists() throws NoSuchMethodException {
        assertNotNull(Main.class
                .getDeclaredMethod("main", String[].class));
    }

}
