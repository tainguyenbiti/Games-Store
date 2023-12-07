package com.gamesstorebe.fileHandle;

import com.gamesstorebe.customHandleError.system.Result;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileHandleService {

    public ResponseEntity<Resource> showImage(String fileName) throws IOException {
        String imagePath = FileUtil.PATH_FILE_UPLOAD + "/image/" + fileName;

        Path path = Paths.get(imagePath);
        Resource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + fileName)
                .body(resource);
    }
    public Result uploadImage(MultipartFile file)
            throws IOException {
        StringBuilder fileName = new StringBuilder();
        String imagePath = FileUtil.PATH_FILE_UPLOAD + "/image/" ;
        Path fileNameAndPath = Paths.get(imagePath, file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        return new Result(true, HttpStatus.OK, "Upload successfully", null);
    }
}
