package client.business;

import java.io.FileWriter;

public final class ReportDecorator implements ReportResultType{
    protected ReportResultType decoratedReport;

    public ReportDecorator(ReportResultType decoratedReport){
      this.decoratedReport = decoratedReport;
   }
    
    @Override
    public void writeToReport(FileWriter myWriter) {
        decoratedReport.writeToReport(myWriter);
    }
    
    
}
