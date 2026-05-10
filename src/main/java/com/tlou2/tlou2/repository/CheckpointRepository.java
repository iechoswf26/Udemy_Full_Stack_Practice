package com.tlou2.tlou2.repository;

import com.tlou2.tlou2.entity.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {
    List<Checkpoint> getAllByChapterId(Long chapter_id);
    List<Checkpoint> id(Long id);
}

