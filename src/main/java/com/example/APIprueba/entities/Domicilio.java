package com.example.APIprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "domicilio")
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio extends Base{
    @Column
    private String calle;
    @Column
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
