package com.DeiviOlivier.CronogramaFase2.Dominios;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name="MENSAJES")
public class Mensaje implements Serializable {
    private static final long serialVersionUID=1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MENSAJE")
    private Long idMensaje;
    @Basic
    @Column(name = "FECHA_MENSAJE")
    private Date fechaMensaje;
    @Basic
    @Column(name = "ASUNTO_MENSAJE")
    private String asuntoMensaje;
    @Column(name = "RESPUESTA_MENSAJE")
    private String respuestaMensaje;
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="ID_PROFESOR")
    private Profesor profesorMensajes;
            
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="ID_ADMINISTRADOR")
    private Administrador administradorMensajes;
           
}
