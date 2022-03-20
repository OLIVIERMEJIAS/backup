/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
@Table(name="ROLES")
public class Rol {
    @Id
    @Column(name = "ID_ROL")
    private byte IdRol;
    @Column(name="NOMBRE_ROL")
    private String nombreRol;
    
}
