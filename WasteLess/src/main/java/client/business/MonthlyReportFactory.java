package client.business;

import java.util.List;

public class MonthlyReportFactory implements AbstractFactory<MonthlyReport>{

    @Override
    public MonthlyReport create(String type, List<ItemInformation> groceryList) {
        return new MonthlyReport().createReport(groceryList);
    }
}
