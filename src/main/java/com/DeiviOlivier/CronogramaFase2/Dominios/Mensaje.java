package com.DeiviOlivier.CronogramaFase2.Dominios;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Mensaje {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MENSAJE")
    private int idMensaje;
    @Basic
    @Column(name = "ID_PROFESOR")
    private int idProfesor;
    @Basic
    @Column(name = "ID_ADMINISTRADOR")
    private int idAdministrador;
    @Basic
    @Column(name = "FECHA_MENSAJE")
    private Date fechaMensaje;
    @Basic
    @Column(name = "ASUNTO_MENSAJE")
    private String asuntoMensaje;

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Date getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Date fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getAsuntoMensaje() {
        return asuntoMensaje;
    }

    public void setAsuntoMensaje(String asuntoMensaje) {
        this.asuntoMensaje = asuntoMensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensaje mensajes = (Mensaje) o;

        if (idMensaje != mensajes.idMensaje) return false;
        if (idProfesor != mensajes.idProfesor) return false;
        if (idAdministrador != mensajes.idAdministrador) return false;
        if (fechaMensaje != null ? !fechaMensaje.equals(mensajes.fechaMensaje) : mensajes.fechaMensaje != null)
            return false;
        if (asuntoMensaje != null ? !asuntoMensaje.equals(mensajes.asuntoMensaje) : mensajes.asuntoMensaje != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMensaje;
        result = 31 * result + idProfesor;
        result = 31 * result + idAdministrador;
        result = 31 * result + (fechaMensaje != null ? fechaMensaje.hashCode() : 0);
        result = 31 * result + (asuntoMensaje != null ? asuntoMensaje.hashCode() : 0);
        return result;
    }
}
