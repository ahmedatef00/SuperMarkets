package com.supermarket.supermarket.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public interface IFileStorageService {

    public String storeFile(MultipartFile file) throws IOException;

}
