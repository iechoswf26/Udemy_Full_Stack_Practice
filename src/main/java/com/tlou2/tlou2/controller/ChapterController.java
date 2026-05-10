/* Package name is required and is explicitly declared at the top of the Java file.
Uses reverse domain name: com.yourcompany.project.module. */
package com.tlou2.tlou2.controller;

import com.tlou2.tlou2.entity.Chapter;
import com.tlou2.tlou2.service.ChapterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController// @RestController: Processes incoming HTTP requests and returns data objects (rather than views).
@RequestMapping("/api/v1/chapter")
/* @RequestMapping:
- Map HTTP requests.
- Routes client requests to appropriate business logic.
- Works with GET, POST, PUT, DELETE. */

public class ChapterController {

    private final ChapterService chapterService; // Declares that ChapterController depends on ChapterService.

    public ChapterController(ChapterService chapterService) { // Create constructor indicating that ChapterController receives ChapterService.
        this.chapterService = chapterService;
    }

    @GetMapping("/{id}") // @GetMapping: Maps HTTP GET requests to this method (used to retrieve data).
    public ResponseEntity<Chapter> findChapterById(@PathVariable Long id) { // PathVariable extraction: Spring auto pulls 1 from the URL, converts it to Long, passes it into method.
        try {
            Chapter chapter = chapterService.findChapterById(id); // Controller calls service to fetch data.
            return ResponseEntity.ok(chapter); // Success path (chapter found): (1) HTTP Status: 200 OK. (2) Response Body: Controller converts chapter -> JSON.
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // If the Service throws an exception, (1) HTTP Status: 404 Not Found. (2) Response Body: empty.
        }
    }
}
