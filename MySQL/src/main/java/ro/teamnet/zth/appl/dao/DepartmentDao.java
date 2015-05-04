package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Departament;

import java.util.List;

/**
 * Created by Florin on 02.05.2015.
 */
public class DepartmentDao {


    EntityManager entityManager = new EntityManagerImpl();

    /**
     *
     * @param department
     * @return department object
     */
    public Departament insertDepartment(Departament department) {
        return (Departament) entityManager.insert(department);
    }

    /**
     *
     * @param department
     * @return department object
     */
    public Departament updateDepartment(Departament department) {
        return entityManager.update(department);
    }

    /**
     *
     * @param department
     */
    public void deleteDepartment(Departament department) {
        entityManager.delete(department);
    }

    /**
     *
     * @return a list of departments
     */
    public List<Departament> getAllDepartments() {
        return entityManager.findAll(Departament.class);
    }

    /**
     *
     * @param id
     * @return department object
     */
    public Departament getDepartmentById(Integer id) {
        return entityManager.findById(Departament.class, id);
    }


}
