package com.viniciuszanetti.docker_manager.controllers;

import com.github.dockerjava.api.model.Image;
import com.viniciuszanetti.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class DockerImagesController {

    private final DockerService dockerService;

    public DockerImagesController(DockerService service){
        this.dockerService = service;
    }

    @GetMapping
    public List<Image> listImages(){
        return dockerService.listImages();
    }

    @GetMapping("/filter")
    public List<Image> listImage(@RequestParam(required = true) String imageName){
        return dockerService.listImage(imageName);
    }
}
