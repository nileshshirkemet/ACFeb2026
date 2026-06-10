package app.services.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface CommunicationLayer {
    void communicate(BufferedReader input, PrintWriter output) throws IOException;
}
