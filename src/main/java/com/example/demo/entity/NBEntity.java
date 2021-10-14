package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class NBEntity implements Serializable {
    private static final long serialVersionUID = 5927313440723596557L;
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
