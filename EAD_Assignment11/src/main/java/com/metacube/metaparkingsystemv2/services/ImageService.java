


package com.metacube.metaparkingsystemv2.services;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.metaparkigsystemv2.serviceInterfaces.IImageService;
import com.metacube.metaparkingsystemv2.daoimpl.ImageDao;



/**
 * This is the service class which implements IImageService interface
 * @author Akanksha
 *
 */
@Service
public class ImageService implements IImageService {
	
	@Autowired
	private ImageDao ImageDao;
	
	/**
	 * This method overrides saveImage method of IImageService interface
	 * This method is used to save image in local folder
	 * @param imageFile is image
	 * @param empId is employee id
	 */
	@Override 
	public void saveImage(MultipartFile imageFile, int empId, String pathname) {
		ImageDao.saveImage(imageFile, empId, pathname);
	}
	
}
