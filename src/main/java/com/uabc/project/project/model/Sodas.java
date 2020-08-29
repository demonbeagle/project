package com.uabc.project.project.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sodas")
public class Sodas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sodas_id")
    private long sodasId;
    @Column(name="sodas_marca")
    private String sodasMarca;
    @Column(name = "sodas_nombre")
    private String sodasNombre;
    @Column(name="sodas_contenido")
    private long sodasContenido;


}
