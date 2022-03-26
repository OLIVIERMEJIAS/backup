package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name="MENSAJES")
public class Mensaje {
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
    @ManyToOne
    @JoinColumn(name="ID_PROFESOR")
    private Profesor profesorMensajes;
            
    @ManyToOne
    @JoinColumn(name="ID_ADMINISTRADOR")
    private Administrador administradorMensajes;
            
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensaje mensajes = (Mensaje) o;

        if (idMensaje != mensajes.idMensaje) return false;
        if (fechaMensaje != null ? !fechaMensaje.equals(mensajes.fechaMensaje) : mensajes.fechaMensaje != null)
            return false;
        if (asuntoMensaje != null ? !asuntoMensaje.equals(mensajes.asuntoMensaje) : mensajes.asuntoMensaje != null)
            return false;
        if (respuestaMensaje != null ? !respuestaMensaje.equals(mensajes.respuestaMensaje) : mensajes.respuestaMensaje != null)
            return false;
        return true;
    }


}
