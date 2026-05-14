package com.tlou2.tlou2.service;

import com.tlou2.tlou2.entity.Checkpoint;
import com.tlou2.tlou2.repository.CheckpointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckpointService {

    private final CheckpointRepository checkpointRepository;

    public CheckpointService (CheckpointRepository checkpointRepository) {
        this.checkpointRepository = checkpointRepository;
    }

    public List<Checkpoint> getAllCheckpointsByChapterId(Long chapterId) {
        return checkpointRepository.getAllByChapterId(chapterId);
    }

    public Checkpoint findById(Long checkpointId){

        Optional<Checkpoint> checkpoint = checkpointRepository.findById(checkpointId);
        if (checkpoint.isPresent()){
            return checkpoint.get();
        }
        return null;
    }

}
