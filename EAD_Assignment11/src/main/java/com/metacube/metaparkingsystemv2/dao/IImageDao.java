package com.metacube.metaparkingsystemv2.dao;

import org.springframework.web.multipart.MultipartFile;

/**
 * This is the interface used to save image in local folder 
 * @author Akanksha
 *
 */
public interface IImageDao {
	/**
	 * This method is used to save image in local folder
	 * @param imageFile is image
	 * @param empId is employee id of employee to which image belongs.
	 */
	public void saveImage(MultipartFile imageFile, int empId,String ud);
}
