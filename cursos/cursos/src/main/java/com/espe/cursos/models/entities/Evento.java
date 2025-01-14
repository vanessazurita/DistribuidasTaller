package com.espe.cursos.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres.")
    private String nombre;

    @Column(name = "descripcion")
    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres.")
    private String descripcion;

    @Column(name = "duracion_horas", nullable = false)
    @Min(value = 1, message = "La duración debe ser al menos de 1 hora.")
    @Max(value = 48, message = "La duración no puede superar las 48 horas.")
    private int duracionHoras;

    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de inicio es obligatoria.")
    @FutureOrPresent(message = "La fecha de inicio debe ser hoy o en el futuro.")
    private Date fechaInicio;

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
