package vn.unigap.api.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name")
    private String name;

    @Column(name = "province")
    private Integer province;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private Date created_at = new Date();
    @Column(name = "updated_at")
    private Date updated_at = new Date();

    public Employee() {
    }

    public Employee(long id, String email, String name, Integer province, String description, Date created_at, Date updated_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.province = province;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
