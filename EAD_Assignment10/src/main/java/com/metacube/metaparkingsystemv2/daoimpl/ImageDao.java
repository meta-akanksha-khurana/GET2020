package com.metacube.metaparkingsystemv2.daoimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.metaparkingsystemv2.dao.IImageDao;


/**
 * This is the dao class used to perform image operations.
 * It implements interface IImageDao
 * @author Akanksha
 *
 */
@Repository
public class ImageDao implements IImageDao {
	
	
	/**
	 * This method overrides saveImage of IImageDao interface
	 * This method is used to save image in local folder
	 * @param imageFile is image
	 * @param empId is employee id of employee to which image belongs.
	 */
	@Override
	public void saveImage(MultipartFile imageFile, int empId ,String ud) {
//		String folder = "C:\\Users\\Akanksha\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\MetaParkingSystemV3\\src\\main\\resources\\static\\images\\";
//		byte[] bytes;
		try {
			Path filename = Paths.get(ud,empId+".png");
			Files.write(filename, imageFile.getBytes());
//			bytes = imageFile.getBytes();
//			Path path = Paths.get(folder + empId + ".png");
//			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
