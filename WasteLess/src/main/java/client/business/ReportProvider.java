package client.business;

public class ReportProvider {
    public static AbstractFactory getFactory(String choice){
         
        if("Weekly".equalsIgnoreCase(choice)){
            return new WeeklyReportFactory();
        }
        else if("Monthly".equalsIgnoreCase(choice)){
            return new MonthlyReportFactory();
        }
         
        return null;
    }
}
