package cn.edu.upc.yb.integrate.contact.model;

import javax.persistence.*;

/**
 * Created by 张艳芳 on 2017/3/25.
 */
@Entity
@Table(name = "ContactUnit")
public class ContactUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private String name;

    public ContactUnit(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
