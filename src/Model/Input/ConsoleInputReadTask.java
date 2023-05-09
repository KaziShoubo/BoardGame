package Model.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class ConsoleInputReadTask implements Callable<String> { // thread
    public String call() throws IOException {
        BufferedReader buffer = new BufferedReader( // bufferedReader lets us know when readLine() can be called without blocking
                new InputStreamReader(System.in));

        String input = null;
        do {

            try {
                // it waits until we have data to complete a readLine() safely, so that the system is not in the blocking state
                while (!buffer.ready()) {
                    Thread.sleep(200);
                }
                input = buffer.readLine();
            } catch (InterruptedException e) {
//                the thread is cancelled if found exception
                return null;
            }
        } while ("".equals(input)); // will not read the ""

//        return the string input if found
        return input;
    }
}