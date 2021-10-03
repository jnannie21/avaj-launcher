package avaj;

import java.io.File;
import java.io.PrintStream;

public class Logger {
    private PrintStream output;
    private static Logger logger = null;

    private Logger() throws java.io.IOException {
        File outputFile = new File("simulation.txt");
        outputFile.createNewFile();

        output = new PrintStream(outputFile);
    }

    public static Logger getLogger() {
        if (logger == null) {
            try {
                logger = new Logger();
            } catch (java.io.IOException e) {
                System.out.println(e);
            }
        }
        return logger;
    }

    public void log(String message) {
        System.out.println(message);
        output.println(message);
    }

    public void close() {
        getLogger().output.close();
    }
}
