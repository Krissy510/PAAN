package project_ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class TimeTable {

    private final LinkedList<Table> tableList;

    public TimeTable() {
        this.tableList = new LinkedList<>();
    }

    public boolean isAvailable(int day, String startTime, String endTime,String task){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date startTimeObj = sdf.parse(startTime);
            Date endTimeObj = sdf.parse(endTime);
            for(Table t: tableList){
                if(day == t.getDay()){
                    if (startTimeObj.before(t.getStartTime()) && !startTimeObj.equals(t.getStartTime()) && (endTimeObj.before(t.getStartTime()) || endTimeObj.equals(t.getStartTime()))) {
                        return true;
                    } else {
                        return (startTimeObj.after(t.getEndTime()) || startTimeObj.equals(t.getEndTime())) && !endTimeObj.equals(t.getEndTime()) && endTimeObj.after(t.getEndTime());
                    }
                }
            }
        } catch (ParseException e) {
            System.out.println("isAvailable failed parse");
        }
        return true;
    }

    public void add(int day, String startTime, String endTime, String task){
        this.tableList.add(new Table(day,startTime,endTime,task));
    }

    public void removeTable(int index){
        this.tableList.remove(index);
    }

    public Table getTable(int index){
        return tableList.get(index);
    }

    public LinkedList<Table> getTableList() {
        return tableList;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("TimeTable:\n");
        for (Table e:
             tableList) {
            str.append(e.getDay()).append("\t");
            str.append(e.getStrStartTime()).append("-");
            str.append(e.getStrEndTime()).append("\t\t");
            str.append(e.getTask()).append("\n");
        }
        str.append("\n");
        return str.toString();

    }
}
