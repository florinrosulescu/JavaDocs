package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Florin on 28.04.2015.
 */
public class EntityUtils {

    private EntityUtils() {
        throw new  UnsupportedOperationException();
    }

    public static String getTableName(Class entity){
        Table t = (Table) entity.getAnnotation(Table.class);
        return t.name();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity){
    ArrayList<ColumnInfo> list = new ArrayList<>();


        Field[] listOfFields=entity.getDeclaredFields();
        for(Field camp:listOfFields){
            ColumnInfo cInfo= new ColumnInfo();
            Id id = camp.getAnnotation(Id.class);
            Column column = camp.getAnnotation(Column.class);
            if(id!=null){
                cInfo.setColumnName(camp.getName());
                cInfo.setDbName(id.name());
                cInfo.setIsID(true);
                list.add(cInfo);
            }else{
                cInfo.setColumnName(camp.getName());
                cInfo.setDbName(column.name());
                cInfo.setIsID(false);
                list.add(cInfo);
            }


        }
        return list;


    }



    public static Object castFromSqlType(Object value, Class wantedType){
        if(value instanceof BigDecimal){
            BigDecimal bigDecimal= (BigDecimal)value;
            if (wantedType.equals(Integer.class)){
                return bigDecimal.intValue();

            }
        }
        return null;
    }


    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        ArrayList<Field> list = new ArrayList<>();
        Field[] listOfFields=clazz.getDeclaredFields();
        for(Field camp:listOfFields){
            Annotation annotation1 = camp.getAnnotation(annotation);
            if (annotation1!= null)
                list.add(camp);

        }
        return list;

    }


    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if(object == null) {
            return null;
        }
        if(object.getClass().getAnnotation(Table.class) != null) {
            Field idField = getFieldsByAnnotations(object.getClass(), Id.class).get(0);
            idField.setAccessible(true);
            return idField.get(object);
        } else {
            return object;
        }
    }


}
