package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;

import ro.teamnet.zth.appl.domain.Departament;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Florin on 28.04.2015.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        Departament department = new Departament();
        String tableName = EntityUtils.getTableName(Departament.class);

        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumnsMethod() {
        List<ColumnInfo> columns = EntityUtils.getColumns(Departament.class);

        assertEquals(3, columns.size());
    }

    @Test
    public void testGetFieldsByAnnotations() throws NoSuchFieldException {
        List<Field> fields = new ArrayList<>();
        Class aClass = Departament.class;
        Field field = aClass.getDeclaredField("departmentName");
        Field field1 = aClass.getDeclaredField("location");
        fields.add(field);
        fields.add(field1);

        assertEquals(fields.size(), EntityUtils.getFieldsByAnnotations(Departament.class, Column.class).size());
    }



}
