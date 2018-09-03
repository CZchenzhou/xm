package com.xm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xm.entity.school.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "school_subject",joinColumns = @JoinColumn(name="school_id"),
    inverseJoinColumns = @JoinColumn(name="subject_id"))
    private Set<Subject> subjects=new HashSet<>();

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }


    public School() {
    }

}
