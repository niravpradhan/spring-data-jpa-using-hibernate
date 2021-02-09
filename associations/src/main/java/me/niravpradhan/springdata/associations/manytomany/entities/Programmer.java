package me.niravpradhan.springdata.associations.manytomany.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"projects"})
@ToString(exclude = {"projects"})
public class Programmer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "programmers_projects",
        joinColumns = {@JoinColumn(name = "programmer_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")}
    )
    private Set<Project> projects;

    public void addProject(Project project) {
        if (project != null) {
            if (projects == null) {
                projects = new HashSet<>();
            }
            projects.add(project);
        }
    }
}
