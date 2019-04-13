package com.sample.entity;

import com.sample.enums.TitleEnum;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(schema = "sample", name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    @OrderBy
    private Name name;

    @Column(name = "title", nullable = false)
    @Enumerated(EnumType.STRING)
    private TitleEnum titleEnum;

    @Column(name = "scheduled_date", nullable = false)
    private Date scheduledDate;

    @Column(name = "notes")
    private String notes;

    @Embedded
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TitleEnum getTitleEnum() {
        return titleEnum;
    }

    public void setTitleEnum(TitleEnum titleEnum) {
        this.titleEnum = titleEnum;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
