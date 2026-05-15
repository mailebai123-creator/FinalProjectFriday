package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileService {

    private final String UPLOAD_DIR = "uploads/";
    public String upload(MultipartFile file) throws IOException {
        Path path = Paths.get(UPLOAD_DIR+file.getOriginalFilename());
        Files.createDirectories(path.getParent());
        Files.write(path,file.getBytes());
        return "File uploaded";
    }
    public byte[] download(String filename)throws IOException{
        Path path = Paths.get(UPLOAD_DIR+filename);
        return Files.readAllBytes(path);
    }
}
