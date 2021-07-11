package com.supermarket.supermarket.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;

import com.supermarket.supermarket.config.FileStorageProperties;
import com.supermarket.supermarket.exception.FileStorageException;
import com.supermarket.supermarket.service.IFileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

//import com.talk2amar.projects.employeeservice.exception.//;
//import com.talk2amar.projects.employeeservice.exception.MyFileNotFoundException;

@Service
@Component
@RequiredArgsConstructor

public class FileStorageService implements IFileStorageService {

    public static final String TEMP_DIR = ".\\src\\main\\resources\\static\\images\\";


    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("FILE_STORAGE_EXCEPTION_PATH_NOT_FOUND", ex);
        }
    }


    @Override
    public String storeFile(MultipartFile file) throws IOException {

        if (!(file.getOriginalFilename().endsWith(".png") || file.getOriginalFilename().endsWith(".jpeg") || file.getOriginalFilename().endsWith(".jpg")))
            throw new FileStorageException("INVALID_FILE_FORMAT");
        File f = new File(FileStorageService.TEMP_DIR + file.getOriginalFilename());
        f.createNewFile();
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(file.getBytes());
        fout.close();
        BufferedImage image = ImageIO.read(f);
        int height = image.getHeight();
        int width = image.getWidth();
        if (width > 500 || height > 500) {
            if (f.exists())
                f.delete();
			   throw new FileStorageException("INVALID_FILE_DIMENSIONS");
        }

        if (f.exists())
            f.delete();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                // This is a security check

                throw new FileStorageException("INVALID_FILE_PATH_NAME" + fileName);
            }
            String newFileName = System.currentTimeMillis() + "_" + fileName;
            Path targetLocation = this.fileStorageLocation.resolve(newFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return newFileName;
        } catch (IOException ex) {
            throw new IOException(String.format("Could not store file %s !! Please try again!;", fileName), ex);
        }

    }

}