package es.santander.ascender.ejerc006.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MESA_AULA")
public class MesaAula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "tamaño", nullable = false)
    private String tamaño;

    @Column(name = "aula_id", nullable = false)
    private Long aulaId;

    public MesaAula() {
    }

    public MesaAula(Long id, String material, String tamaño, Long aulaId) {
        this.id = id;
        this.material = material;
        this.tamaño = tamaño;
        this.aulaId = aulaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }
}