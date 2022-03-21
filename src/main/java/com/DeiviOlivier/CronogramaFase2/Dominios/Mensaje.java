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
    private int idMensaje;
    @Basic
    @Column(name = "FECHA_MENSAJE")
    private Date fechaMensaje;
    @Basic
    @Column(name = "ASUNTO_MENSAJE")
    private String asuntoMensaje;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMensaje;
        result = 31 * result + (fechaMensaje != null ? fechaMensaje.hashCode() : 0);
        result = 31 * result + (asuntoMensaje != null ? asuntoMensaje.hashCode() : 0);
        return result;
    }
}
