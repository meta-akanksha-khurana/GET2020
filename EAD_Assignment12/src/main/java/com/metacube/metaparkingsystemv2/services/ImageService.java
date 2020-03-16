package com.metacube.metaparkingsystemv2.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.metaparkingsystemv2.serviceInterfaces.IImageService;


/**
 * This is the service class which implements IImageService interface
 * @author Akanksha
 *
 */
@Service
public class ImageService implements IImageService{
	
	@Override
	public void saveImage(MultipartFile imageFile, int empId ,String ud) {
		try {
			Path filename = Paths.get(ud,empId+".png");
			Files.write(filename, imageFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
