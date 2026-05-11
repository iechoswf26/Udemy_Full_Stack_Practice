package com.tlou2.tlou2.controller;

import com.tlou2.tlou2.entity.Checkpoint;
import com.tlou2.tlou2.service.CheckpointService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checkpoint")
@CrossOrigin("*")
public class CheckpointController {

    private final CheckpointService checkpointService;

    public CheckpointController (CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }

    @GetMapping (value = "/chapter/id/", params = "id")
    @ResponseStatus(HttpStatus.OK)
    public List<Checkpoint> getAllCheckpointsByChapterId(@RequestParam Long id) {
        return checkpointService.getAllCheckpointsByChapterId(id);
    }

}
