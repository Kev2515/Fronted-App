package com.example.netjob.Model;

public class Servicios {

    String id;
    String titulo;
    String descripcion;
    String disponibilidad;
    int image;
    int preciohora;
    int preciotraslado;
    int fechacreacion;
    int fechaactualizacion;
    String usuario;


    public Servicios (String titulo, String descripcion, String disponibilidad){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getPreciohora() {
        return preciohora;
    }

    public void setPreciohora(int preciohora) {
        this.preciohora = preciohora;
    }

    public int getPreciotraslado() {
        return preciotraslado;
    }

    public void setPreciotraslado(int preciotraslado) {
        this.preciotraslado = preciotraslado;
    }

    public int getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(int fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(int fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }




}
