package uncc.edu.inclass08;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Expense {
    String exName;
    String exCategory;
    String exAmt;
    Date exDate;

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getExCategory() {
        return exCategory;
    }

    public void setExCategory(String exCategory) {
        this.exCategory = exCategory;
    }

    public String getExAmt() {
        return exAmt;
    }

    public void setExAmt(String exAmt) {
        this.exAmt = exAmt;
    }

    public String getExDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(exDate);
    }

    public void setExDate() {

        exDate=new Date();

    }

    @Override
    public String toString() {
        return "Expence{" +
                "exName='" + exName + '\'' +
                ", exCategory='" + exCategory + '\'' +
                ", exAmt='" + exAmt + '\'' +
                ", exDate=" + exDate +
                '}';
    }
}

