package com.metacube.metaparkigsystemv2.serviceInterfaces;

import org.springframework.web.multipart.MultipartFile;

/**
 * This is the service layer interface used to perform operations on image.
 * @author Akanksha
 *
 */
public interface IImageService {
	
	/**
	 * This method is used to save image in local folder
	 * @param imageFile is image
	 * @param empId is employee id
	 */
	public void saveImage(MultipartFile imageFile, int empId,String uploadDirectory);
}
