package com.viniciuszanetti.docker_manager.controllers;

import com.github.dockerjava.api.model.Container;
import com.viniciuszanetti.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class DockerContainerController {

    private final DockerService dockerService;

    public DockerContainerController(DockerService service){
        this.dockerService = service;
    }

    @GetMapping()
    public List<Container> listContainer(@RequestParam(required = false, defaultValue = "true") boolean all){
        return dockerService.listContainers(all);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable String id){
        dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable String id){
        dockerService.stopContainer(id);
    }

    @PostMapping("/{id}/delete")
    public void deleteContainer(@PathVariable String id){
        dockerService.deleteContainer(id);
    }

    @PostMapping("/create")
    public void createContainer(@PathVariable String imageName){
        dockerService.createContainer(imageName);
    }
}
