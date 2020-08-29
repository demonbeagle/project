package com.uabc.project.project.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="cigarros")
public class Cigarros implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cigarros_id")
    private long cigarrosId;
    @Column(name="cigarros_marca")
    private String cigarrosMarca;
    @Column(name = "cigarros_nombre")
    private String cigarrosNombre;
    @Column(name="cigarros_contenido")
    private long cigarrosContenido;

}
