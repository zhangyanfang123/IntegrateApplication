package cn.edu.upc.yb.integrate.contact.controller;
/**
 * Created by 张艳芳 on 2017/3/25.
 */

import cn.edu.upc.yb.integrate.contact.repository.ContactJobRepository;
import cn.edu.upc.yb.integrate.contact.repository.ContactUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    ContactJobRepository contactJobRepository;

    @Autowired
    ContactUnitRepository contactUnitRepository;

    @RequestMapping(value = "/showunit",method = RequestMethod.GET)
    public Object showUnit()
    {
        return contactUnitRepository.findAll();
    }

    @RequestMapping(value = "/showjob",method = RequestMethod.GET)
    public Object showJob(int unitid)
    {
        return contactJobRepository.findByUnitid(unitid);
    }

    @RequestMapping(value = "/findjob",method = RequestMethod.GET)
    public Object findJob(String name)
    {
        return contactJobRepository.findByName(name);
    }
}
