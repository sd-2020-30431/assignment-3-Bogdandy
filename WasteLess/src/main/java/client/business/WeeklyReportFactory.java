package client.business;

import java.util.List;

public class WeeklyReportFactory implements AbstractFactory<WeeklyReport>{

    @Override
    public WeeklyReport create(String type, List<ItemInformation> groceryList) {
        return new WeeklyReport().createReport(groceryList);
    }
}
