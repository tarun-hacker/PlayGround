package com.tarun.invoizer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
@Data
public class Product extends BaseDBO {

    @NotBlank
    String name;

    @Size(max = 100)
    String category;

    @Column(columnDefinition = "TEXT")
    String description;

}
