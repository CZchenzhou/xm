package com.xm.entity.school;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xm.entity.School;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer subjectId;

    @Column
    private String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private Set<School> schools=new HashSet<>();

    @Column
    private String subjectHref;


    public String getSubjectHref() {
        return subjectHref;
    }

    public void setSubjectHref(String subjectHref) {
        this.subjectHref = subjectHref;
    }

    public Subject() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
