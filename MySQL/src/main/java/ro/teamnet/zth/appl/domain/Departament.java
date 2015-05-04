package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Florin on 28.04.2015.
 */
@Table(name = "departments")
public class Departament {

    @Id(name = "DEPARTMENT_ID")
    private Integer id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "LOCATION_ID")
    private Integer location;

//getter
    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Integer getLocation() {
        return location;
    }


    //setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }


    //override

    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", location=" + location +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departament that = (Departament) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        return !(location != null ? !location.equals(that.location) : that.location != null);

    }




}


