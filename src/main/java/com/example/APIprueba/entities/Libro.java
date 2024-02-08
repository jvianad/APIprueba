package com.example.APIprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "libro")
@AllArgsConstructor
@NoArgsConstructor
public class Libro extends Base{
    @Column
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column
    private String genero;
    @Column
    private int paginas;
    @Column
    private String titulo;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}
