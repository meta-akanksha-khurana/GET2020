package com.metacube.metaparkingsystemv2.services;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.metaparkingsystemv2.daoimpl.ImageDao;
import com.metacube.metaparkingsystemv2.serviceInterfaces.IImageService;


/**
 * This is the service class which implements IImageService interface
 * @author Akanksha
 *
 */
@Service
public class ImageService implements IImageService {

	/*
	 * @Override public void saveImage(MultipartFile imageFile, int empId) { String
	 * folder =
	 * "C:\\Users\\Akanksha\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\MetaParkingSystemV3\\src\\main\\resources\\static\\images";
	 * byte[] bytes; try { bytes = imageFile.getBytes(); Path path =
	 * Paths.get(folder + empId + ".png"); Files.write(path, bytes); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */
	
	@Autowired
	private ImageDao ImageDao;
	
	/**
	 * This method overrides saveImage method of IImageService interface
	 * This method is used to save image in local folder
	 * @param imageFile is image
	 * @param empId is employee id
	 */
	@Override public void saveImage(MultipartFile imageFile, int empId, String pathname) {
		ImageDao.saveImage(imageFile, empId, pathname);
	}
	
}
