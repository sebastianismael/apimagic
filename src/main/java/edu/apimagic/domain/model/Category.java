package edu.apimagic.domain.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "findCategoryByCodeAndName",
                query = "from Category c where c.codigo=:code and c.nombre=:name"
        )
})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private String permalink;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermalink() {
        return this.permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}