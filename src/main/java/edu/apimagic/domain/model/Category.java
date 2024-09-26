package edu.apimagic.domain.model;

public class Category {

    private Long id;
    private String code;
    private String name;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
