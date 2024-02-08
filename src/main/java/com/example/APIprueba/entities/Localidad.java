package com.example.APIprueba.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "localidad")
@AllArgsConstructor
@NoArgsConstructor
public class Localidad extends Base {
    @Column
    private String denominacion;
}
