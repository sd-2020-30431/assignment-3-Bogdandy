package client.business;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoodConsumption implements ReportResultType{

    @Override
    public void writeToReport(FileWriter myWriter) {
        try {
            myWriter.write("Good Calorie Intake.\n");
        }catch (IOException ex) {
            Logger.getLogger(BadConsumption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
