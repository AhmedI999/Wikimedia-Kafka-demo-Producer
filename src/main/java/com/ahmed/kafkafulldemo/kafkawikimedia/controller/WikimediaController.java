package com.ahmed.kafkafulldemo.kafkawikimedia.controller;

import com.ahmed.kafkafulldemo.kafkawikimedia.stream.WikimediaStreamConsumer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WikimediaController {
    WikimediaStreamConsumer wikimediaStreamConsumer;

    @GetMapping
    public ResponseEntity<String> startPublish(){
        wikimediaStreamConsumer.consumeStreamAndPublish();
        return ResponseEntity.ok("Service started publishing");
    }

}
