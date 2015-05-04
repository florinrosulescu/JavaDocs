package ro.teamnet.zth.api.em;

/**
 * Created by Florin on 28.04.2015.
 */
public class Condition {
    private String columnName;
    private Object value;

    public Condition(String columnName, Object value) {
        this.columnName = columnName;
        this.value = value;
    }
    //getter

    public String getColumnName() {
        return columnName;
    }

    public Object getValue() {
        return value;
    }


    //setter

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
