package com.store.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private Integer idCliente;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;
    private String correo;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

}
