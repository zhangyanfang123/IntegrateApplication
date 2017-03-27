package cn.edu.upc.yb.integrate.contact.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.contact.model.ContactJob;
import cn.edu.upc.yb.integrate.contact.model.ContactUnit;
import cn.edu.upc.yb.integrate.contact.repository.ContactJobRepository;
import cn.edu.upc.yb.integrate.contact.repository.ContactUnitRepository;
import org.apache.poi.hssf.record.formula.functions.Request;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张艳芳 on 2017/3/25.
 */



@RestController
@RequestMapping("/contact")
public class ContactOfficalController {

    @Autowired
    private ContactJobRepository contactJobRepository;


    @Autowired
    private ContactUnitRepository contactUnitRepository;

    @RequestMapping(value = "/creatunit",method = RequestMethod.GET)
    public Object creatunit(String name) {
        ContactUnit contactUnit = new ContactUnit(name);
        contactUnitRepository.save(contactUnit);
        return new JsonMes(1, "创建部门成功");
    }

    @RequestMapping(value = "/creatjob",method = RequestMethod.GET)
    public Object creatunit(String name,String number, int  unitid)
    {
        ContactJob contactJob = new ContactJob(name,number,unitid);
        contactJobRepository.save(contactJob);
        return new JsonMes(1,"创建职位成功");
    }

    @RequestMapping(value = "/deleteunit",method= RequestMethod.GET)
    public Object deleteUnit(int unitId)
    {
        contactUnitRepository.delete(unitId);
        return  new JsonMes(1,"删除成功");
    }

    @RequestMapping(value = "/deletejob",method= RequestMethod.GET)
    public Object deleteJob(int jobId)
    {
        contactJobRepository.delete(jobId);
        return  new JsonMes(1,"删除成功");
    }
    @GetMapping("/testone") Object one(){
        return new JsonMes(100,"这是一个测试");
    }
}
