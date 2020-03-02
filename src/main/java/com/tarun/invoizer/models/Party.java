package com.tarun.invoizer.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "parties")
@Data
public class Party extends BaseDBO{

    @NotBlank
    private String name;

    private String gstno;

    private String address;
}
