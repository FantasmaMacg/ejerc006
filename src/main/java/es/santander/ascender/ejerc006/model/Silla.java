package es.santander.ascender.ejerc006.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SILLA")
public class Silla {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "altura", nullable = false)
    private Double altura;

    @Column(name = "mesa_id", nullable = false)
    private Long mesaId;

    public Silla() {
    }

    public Silla(Long id, String color, Double altura, Long mesaId) {
        this.id = id;
        this.color = color;
        this.altura = altura;
        this.mesaId = mesaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }
}