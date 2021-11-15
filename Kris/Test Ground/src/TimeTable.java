import java.util.LinkedList;

public class TimeTable {

    private LinkedList<Table> tableList;

    public TimeTable() {
        this.tableList = new LinkedList<>();
    }

    public void add(int day, String startTime, String endTime, String task){
        this.tableList.add(new Table(day,startTime,endTime,task));
    }

    public boolean addTable(){
        return false;
    }

    public void removeTable(int index){
        this.tableList.remove(index);
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

    public LinkedList<Table> getTableList() {
        return tableList;
    }

    //    public boolean isAvailable(int day, String startTime, String endTime){
//        try {
//            Date startTimeObj = sdf.parse(startTime);
//            Date endTimeObj = sdf.parse(endTime);
//            for(Table t: tableList){
//                if(t.getStartTime().equals(startTimeObj) || t.getEndTime().equals(startTimeObj)) // if
//                    return false;
//                else if(t.getEndTime().equals(endTimeObj) || t.getStartTime().equals(endTimeObj))
//                    return false;
//                else if(t.getStartTime().)
//            }
//        } catch (ParseException e) {
//            System.out.println("isAvailable failed parse");
//        }
//        return false;
//    }
}
