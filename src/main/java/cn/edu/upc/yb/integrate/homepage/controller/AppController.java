package cn.edu.upc.yb.integrate.homepage.controller;


import cn.edu.upc.yb.integrate.homepage.model.App;
import cn.edu.upc.yb.integrate.homepage.repository.AppRepository;
import cn.edu.upc.yb.integrate.homepage.storage.StorageFileNotFoundException;
import cn.edu.upc.yb.integrate.homepage.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ybdevelop on 2016/10/18.
 */
@RestController
@RequestMapping("/homepage/app")
public class AppController {
    private final StorageService storageService;

    @Autowired
    public AppController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    public AppRepository appRepository;

    @GetMapping("/icon/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> showFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(file);
    }

    @GetMapping("/showall")
    public Iterable<App> showAll(){
        return appRepository.findAll();
    }

    @PostMapping("/create")
    public String create(@RequestParam("icon") MultipartFile icon, String name) {
        storageService.store(icon,name);
        App app = new App(name);
        appRepository.save(app);
        return "添加成功";
    }
    @PostMapping("/update")
    public Object update(Integer id, @RequestParam("file") MultipartFile icon, String name){
        storageService.store(icon,name);
        App app = appRepository.findOne(id);
        app.update(name);
        appRepository.save(app);
        return "更新成功";
    }
    @GetMapping("/update")
    public Object delete(Integer id){
        appRepository.delete(id);
        return "删除成功";
    }
    @GetMapping("/findone")
    public Object find(Integer id){
        return  appRepository.findOne(id);
    }



    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}