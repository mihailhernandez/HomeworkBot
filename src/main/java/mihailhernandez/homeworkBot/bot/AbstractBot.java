package mihailhernandez.homeworkBot.bot;

public abstract class AbstractBot implements Runnable {

    private Thread thread;
    private String threadName = this.getClass().getSimpleName();

    protected Thread getThread() {
        return thread;
    }

    protected void setThread(Thread thread) {
        this.thread = thread;
    }

    protected String getThreadName() {
        return threadName;
    }

    protected void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public void start() {
        System.out.println("Starting thread " + threadName + "...");
        this.thread.start();
    }
}
