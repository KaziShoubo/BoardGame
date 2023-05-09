package Model.Input;

import java.util.concurrent.*;

public class ConsoleInput {
    private final int tries;
    private final int timeout;
    private final TimeUnit unit;

    public ConsoleInput(int t, int timeout, TimeUnit unit) {
        this.tries = t;
        this.timeout = timeout;
        this.unit = unit;
    }

    public String readLine() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // executors, to get back the input in the calling thread
        String input = null;
        try {
            // start working
            for (int i = 0; i < tries; i++) {

                Future<String> asyncResult = executor.submit( // asynchronous task result
                        new ConsoleInputReadTask());
                try {
                    input = asyncResult.get(timeout, unit);
                    break;
                } catch (ExecutionException e) {
                    e.getCause().printStackTrace();
                } catch (TimeoutException e) {
                    asyncResult.cancel(true);
                }
            }
        } finally {
            executor.shutdownNow();
        }
        return input;
    }
}
