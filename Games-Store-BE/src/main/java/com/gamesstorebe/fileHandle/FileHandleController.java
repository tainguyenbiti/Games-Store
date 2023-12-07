package com.gamesstorebe.fileHandle;

import com.gamesstorebe.customHandleError.system.Result;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileHandleController {
    private final FileHandleService fileHandleService;

    public FileHandleController(FileHandleService showImageService) {
        this.fileHandleService = showImageService;
    }

    @GetMapping("/image/{fileName}")
    public ResponseEntity<Resource> showImage(@PathVariable (name = "fileName") String fileName) throws IOException {
        return fileHandleService.showImage(fileName);
    }

    @GetMapping("/upload")
    public Result uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return fileHandleService.uploadImage(file);
    }
}
