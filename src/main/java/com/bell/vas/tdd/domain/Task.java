package com.bell.vas.tdd.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Boualem on 2017-07-12.
 */
@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "TASK_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "STATUS")
    private String status;

    @NotNull
    @Column(name = "OWNER")
    private String owner;

    @NotNull
    @Column(name = "PROJECT_NAME")
    private String project_name;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", owner='" + owner + '\'' +
                ", project_name='" + project_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (status != null ? !status.equals(task.status) : task.status != null) return false;
        if (owner != null ? !owner.equals(task.owner) : task.owner != null) return false;
        return project_name != null ? project_name.equals(task.project_name) : task.project_name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (project_name != null ? project_name.hashCode() : 0);
        return result;
    }
}
