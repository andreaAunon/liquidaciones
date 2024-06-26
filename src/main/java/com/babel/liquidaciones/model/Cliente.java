package com.babel.liquidaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    private String nif;

    private String nombre;
    private String password;
    private String direction;
    private String contacto;

    @OneToOne
    private Poliza poliza;

}
