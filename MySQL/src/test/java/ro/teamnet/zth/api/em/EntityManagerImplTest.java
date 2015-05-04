package ro.teamnet.zth.api.em;


import java.util.List;
import ro.teamnet.zth.appl.domain.Departament;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * Created by Florin on 02.05.2015.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntityManagerImplTest {
    EntityManagerImpl entityManager = new EntityManagerImpl();
    static Departament dep = new Departament();

    @Test
    public void aTestInsert() {
        dep.setDepartmentName("test unitar");
        dep = entityManager.insert(dep);

        assertEquals(entityManager.findById(Departament.class, dep.getId()), dep);
    }

    @Test
    public void bTestUpdate() {
        dep.setDepartmentName("test unitar2");
        dep = entityManager.update(dep);

        assertEquals(entityManager.findById(Departament.class, dep.getId()), dep);
    }

    @Test
    public void cTestDelete() {
        entityManager.delete(dep);
        Departament depById = entityManager.findById(Departament.class, dep.getId());

        assertNull(depById);
    }

    @Test
    public void dFindAll() {
        List<Departament> oldDeps = entityManager.findAll(Departament.class);
        //add new dep
        dep.setDepartmentName("test unitar");
        dep = entityManager.insert(dep);
        List<Departament> newDeps = entityManager.findAll(Departament.class);

        assertEquals(oldDeps.size(), newDeps.size() - 1);
    }

}
