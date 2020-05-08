package client.business;

import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class MonthlyReport {
    private List<ItemInformation> groceryList;
    private List<Date> checkDates;
    private final List<ReportDataStructure> reportItems = new ArrayList<>();
        
    public MonthlyReport createReport(List groceryItems){
	ZoneId defaultZoneId = ZoneId.systemDefault();
        groceryList = groceryItems;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Date date = new Date();
        
        String Path = System.getProperty("user.home") + "\\Desktop\\" + "Monthly Report "+dateFormat.format(date)+".txt";
        File file = new File(Path);
        
        try{
            if(file.createNewFile()) {
                FileWriter myWriter = new FileWriter(Path);
                myWriter.write("Report ");
                
                for (ItemInformation groceryItem: groceryList){
                    boolean check = true;
                    boolean check2 = true;
                    int year = -1;
                    int month = -1;
                    int intermediate = 0;
                    checkDates = new ParseDates().parseDates(Date.from(groceryItem.getPurchaseDate().atStartOfDay(defaultZoneId).toInstant()),
                            Date.from(groceryItem.getConsumptionDate().atStartOfDay(defaultZoneId).toInstant()));
                    int days = checkDates.size();
                    for (Iterator<Date> it = checkDates.iterator(); it.hasNext();){
                        Date intermediaryDate = it.next();
                        Calendar cal1 = Calendar.getInstance();
                        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                        cal1.setTime(intermediaryDate);
                        int yearDate = cal1.get(Calendar.YEAR);
                        int monthDate = cal1.get(Calendar.MONTH)+1;
                        
                        if(check){
                            year = yearDate;
                            month = monthDate;
                            check = false;
                        }
                        
                        if(year == yearDate){
                            if(month != monthDate){
                                if(check2){
                                    intermediate = checkDates.indexOf(intermediaryDate);
                                    check2 = false;
                                }else{
                                    intermediate = checkDates.indexOf(intermediaryDate) - intermediate + 1;
                                }
                                int calories = ((groceryItem.getCaloricValue() * groceryItem.getQuantity() * intermediate)/days);
                                reportItems.add(new ReportDataStructure(groceryItem.getItemName(), groceryItem.getTableIndex(), groceryItem.getQuantity(), calories, month, year));
                                month = monthDate;
                                year = yearDate;
                            }else{
                                if(!it.hasNext()){
                                    intermediate = checkDates.indexOf(intermediaryDate) - intermediate + 1;
                                    int calories = ((groceryItem.getCaloricValue() * groceryItem.getQuantity() * intermediate)/days);
                                    reportItems.add(new ReportDataStructure(groceryItem.getItemName(), groceryItem.getTableIndex(), groceryItem.getQuantity(), calories, month, year));
                                }
                            }
                        }else{
                            intermediate = checkDates.indexOf(intermediaryDate) - intermediate + 1;
                            int calories = ((groceryItem.getCaloricValue() * groceryItem.getQuantity() * intermediate)/days);
                            reportItems.add(new ReportDataStructure(groceryItem.getItemName(), groceryItem.getTableIndex(), groceryItem.getQuantity(), calories, month, year));
                            month = monthDate;
                            year = yearDate;
                        }
                    } 
                }
                Collections.sort(reportItems, (Object o1, Object o2) -> {
                    Integer x1 = ((ReportDataStructure) o1).getCriteria();
                    Integer x2 = ((ReportDataStructure) o2).getCriteria();
                    Integer sComp = x1.compareTo(x2);

                    if (sComp != 0) {
                        return sComp;
                    }
                    
                    Integer x3 = ((ReportDataStructure) o1).getYear();
                    Integer x4 = ((ReportDataStructure) o2).getYear();
                    return x3.compareTo(x4);
                });
                
                ReportResultType reportResultType;
                for(int i = 1; i <= 5; i ++){
                    myWriter.write("\n\nGroceryList " + i + ":");
                    boolean check = true;
                    int yearDate = -1;
                    int monthDate = -1;
                    int calories = 0;
                    for (Iterator<ReportDataStructure> it = reportItems.iterator(); it.hasNext();){
                        ReportDataStructure reportItem = it.next();
                        if(reportItem.getTableIndex() == i){
                            if(check){
                                yearDate = reportItem.getYear();
                                monthDate = reportItem.getCriteria();
                                check = false;
                                myWriter.write("\nMonth " + monthDate + " Year " + yearDate);
                            }
                            
                            if(yearDate == reportItem.getYear()){
                                if(monthDate == reportItem.getCriteria()){
                                    calories += reportItem.getCalories();
                                    myWriter.write("\n" + reportItem.getItemName() + " " + reportItem.getQuantity() + " " + reportItem.getCalories());
                                }else{
                                    myWriter.write("\nTotal Calories: " + calories +"\n");
                                    
                                    YearMonth yearMonthObject = YearMonth.of(yearDate, monthDate);
                                    int daysInMonth = yearMonthObject.lengthOfMonth();
                                    if(1000 * daysInMonth> calories || calories > 2800* daysInMonth){
                                        reportResultType = new ReportDecorator(new BadConsumption());
                                        reportResultType.writeToReport(myWriter);
                                    }else{
                                        reportResultType = new ReportDecorator(new GoodConsumption());
                                        reportResultType.writeToReport(myWriter);
                                    }
                                    
                                    calories = reportItem.getCalories();
                                    yearDate = reportItem.getYear();
                                    monthDate = reportItem.getCriteria();
                                    
                                    myWriter.write("\nMonth " + monthDate + " Year " + yearDate);
                                    myWriter.write("\n" + reportItem.getItemName() + " " + reportItem.getQuantity() + " " + reportItem.getCalories());
                                }
                            }
                            if(!it.hasNext()){
                                myWriter.write("\nTotal Calories: " + calories + "\n");
                                YearMonth yearMonthObject = YearMonth.of(yearDate, monthDate);
                                int daysInMonth = yearMonthObject.lengthOfMonth();
                                if(1000 * daysInMonth> calories || calories > 2800* daysInMonth){
                                    reportResultType = new ReportDecorator(new BadConsumption());
                                    reportResultType.writeToReport(myWriter);
                                }else{
                                    reportResultType = new ReportDecorator(new GoodConsumption());
                                    reportResultType.writeToReport(myWriter);
                                }
                            }
                        }
                    } 
                }
                myWriter.close();
            }
        }catch(IOException e){
            return null;
        }
        return null;
    }
}
