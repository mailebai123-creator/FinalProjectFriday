package com.example.demo.controller;

import com.example.demo.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class BeksultanFilesController {
    private final FileService fileService;
    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file)throws Exception{
        return fileService.upload(file);
    }
    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable String filename) throws  Exception{
        byte[] data = fileService.download(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+filename).body(data);
    }
}
