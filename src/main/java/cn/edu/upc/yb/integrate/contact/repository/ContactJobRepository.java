package cn.edu.upc.yb.integrate.contact.repository;

import cn.edu.upc.yb.integrate.contact.model.ContactJob;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by 张艳芳 on 2017/3/25.
 */
public interface ContactJobRepository extends CrudRepository<ContactJob,Integer> {
    Iterator <ContactJob> findByUnitid(int id);
    Iterator <ContactJob> findByName(String name);
}
