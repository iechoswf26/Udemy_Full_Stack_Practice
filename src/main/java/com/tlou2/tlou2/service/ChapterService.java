/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.service;

import com.tlou2.tlou2.entity.Chapter;
import com.tlou2.tlou2.repository.ChapterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // @Service: Make ChapterService available for dependency injection elsewhere.
public class ChapterService {

    private final ChapterRepository chapterRepository; // Declares that ChapterService depends on ChapterRepository.

    public ChapterService (ChapterRepository chapterRepository) {
        /* Spring performs dependency injection.
    (1) Spring creates ChapterRepository bean.
    (2) Spring creates ChapterService bean.
    (3) Spring passes repository into constructor.
    Summary: ChapterService receives repository.
     */
        this.chapterRepository = chapterRepository;
    };

    public Chapter findChapterById (Long id) {
        return chapterRepository.findById(id).orElseThrow();
    }

}
