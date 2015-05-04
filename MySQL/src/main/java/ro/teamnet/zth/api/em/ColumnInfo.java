package ro.teamnet.zth.api.em;

/**
 * Created by Florin on 28.04.2015.
 */
public class ColumnInfo {
    private String columnName;
    private Class columnType;
    private String dbName;
    private boolean isID;
    private Object value;


    //getter
    public String getColumnName() {
        return columnName;
    }

    public String getDbName() {
        return dbName;
    }

    public boolean isID() {
        return isID;
    }

    public Object getValue() {return value;
    }

    public Class getColumnType() {return columnType;
    }

    //setter

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setIsID(boolean isID) {
        this.isID = isID;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setColumnType(Class columnType) {this.columnType = columnType; }
}
