package Exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NegativeSideValuesException extends Exception {
    public NegativeSideValuesException(String message) {
        super(message);
        logExcepcion(this); 
    }

    private void logExcepcion(Exception e) {
        try (FileWriter fileWriter = new FileWriter("src/Exceptions/log.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
                
            printWriter.println("Fecha y hora: " + java.time.LocalDateTime.now());
            printWriter.println("Tipo de excepcion: " + e.getClass().getName());
            printWriter.println("Mensaje de la excepcion: " + e.getMessage());
            e.printStackTrace(printWriter);
            printWriter.println("------------------------------------------------------");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}