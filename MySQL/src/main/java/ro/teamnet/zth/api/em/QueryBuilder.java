package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florin on 30.04.2015.
 */
public class QueryBuilder {
    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;


    public QueryBuilder addCondition(Condition condition){
        conditions= new ArrayList<>();
        conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName){
       this.tableName=tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns){
      this.queryColumns= new ArrayList<>();
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType){
       this.queryType=queryType;
        return this;

    }

    private String createSelectQuery(){
        StringBuilder str = new StringBuilder();
        str.append("SELECT ");
        int index = queryColumns.size();
        for (ColumnInfo queryColumn : queryColumns) {
            str.append(queryColumn);
            index--;

            if(index>0)
            str.append(",");
        }
        str.append("FROM ");
        str.append(tableName);
        str.append("WHERE ");
        for (Condition condition : conditions) {
           str.append(condition.getColumnName());
            str.append("=");
            str.append(condition.getValue());

        }
        return str.toString();

    }

    private String createDeleteQuery(){
        StringBuilder str = new StringBuilder();
        str.append("DELETE ");
        str.append("FROM ");
        str.append(tableName);

        str.append("WHERE ");
        for (Condition condition : conditions) {
            str.append(condition.getColumnName());
            str.append("=");
            str.append(condition.getValue());

        }

        return str.toString();



    }

    private String createUpdateQuery(){
        StringBuilder str = new StringBuilder();
        str.append("UPDATE ");
        str.append(tableName);
        str.append(" SET ");
        int index=queryColumns.size();
        for (ColumnInfo queryColumn : queryColumns.subList(1,queryColumns.size())) {
            str.append(queryColumn.getColumnName());
            str.append("=");
            str.append(queryColumn.getValue());
            index--;
            if(index>0)
                str.append(",");


        }



        str.append("WHERE");
        for (Condition condition : conditions) {
            str.append(condition.getColumnName());
            str.append("=");
            str.append(condition.getValue());

        }



        return str.toString();
    }

    private String createInsertQuery(){
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO");
        str.append(tableName);
        for (ColumnInfo queryColumn : queryColumns.subList(1,queryColumns.size())) {
            str.append(queryColumn.getColumnName());
        }
        str.append("VALUES");
        for (ColumnInfo queryColumn : queryColumns.subList(1,queryColumns.size())) {
            str.append(queryColumn.getValue());
        }




        return str.toString();
    }

    public String createQuery(){
        if (queryType.equals(QueryType.DELETE))
            return createDeleteQuery();
        if (queryType.equals(QueryType.SELECT))
            return createSelectQuery();
        if (queryType.equals(QueryType.UPDATE))
            return  createUpdateQuery();
        if (queryType.equals(QueryType.INSERT))
            return createInsertQuery();

        return null;
    }



}
