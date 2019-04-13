package com.sample.dto;

import com.sample.entity.Address;
import com.sample.entity.Name;
import com.sample.enums.TitleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@ApiModel(description = "Task")
public class TaskDto {
    @ApiModelProperty(name = "id")
    private Long id;
    @ApiModelProperty(required = true)
    private Name name;

    @ApiModelProperty(required = true)
    private Address address;

    @ApiModelProperty(required = true, example = "[Mr, Mrs, Miss]")
    private TitleEnum titleEnum;

    @ApiModelProperty(required = true)
    private Date scheduledDate;

    private String notes;

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
