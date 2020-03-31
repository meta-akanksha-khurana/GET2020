package Ques1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents Directory and operations on the directory
 * @author Akanksha
 *
 */
public class Directory {
	private Directory parentDirectory;
	private String name;
	private Date createdDate;
	private ArrayList<Directory> subDirectories;
	
	public Directory(Directory parentDirectory, String name, Date createdDate) {
		this.parentDirectory = parentDirectory;
		this.name = name;
		this.createdDate = createdDate;
		this.subDirectories = new ArrayList<Directory>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public ArrayList<Directory> getSubDirectories() {
		return subDirectories;
	}
	public void setSubDirectories(ArrayList<Directory> subDirs) {
		this.subDirectories = subDirs;
	}
	
	/**
	 * This method is used to find if the directories has sub directories or not.
	 * @return True if directory has sub directories otherwise false
	 */
	public boolean hasSubDir() {
		if(subDirectories.size() > 0)
			return true;
		return false;
	}

	/**
	 * This method is used to check if particular sub directory is present or not.
	 * @param name is Directory Name
	 * @return true if sub directory is found else false
	 */
	public boolean isSubDirPresent(String name) {
		if(hasSubDir()) {
			for(Directory subDir : subDirectories) {
				if(name.equals(subDir.getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method is used to get subdirectory
	 * @param name is name of directory
	 * @return if Same name directory is present as subdirectory then return 
	 * that directory else return null
	 */
	public Directory getSubDir(String name) {
		if(hasSubDir()) {
		for(Directory subDir: subDirectories) {
			if(name.equalsIgnoreCase(subDir.name)) {
				return subDir;
			}
		}
		}
		return null;
	}
	
	/**
	 * This method is used to change directory
	 * @param name is Directory name
	 * @return change Directory with given name
	 */
	public Directory cd(String name) {
		if(isSubDirPresent(name)){
			return getSubDir(name);
		} else {
			System.out.println("Directory Not Present.");
			return this;
		}
	}
	
	/**
	 * This method is used to make a Directory in current directory with given name
	 * @param name is directory name
	 * 
	 */
	public void mkDir(String name) {
		if(isSubDirPresent(name)){
			System.out.println("Name Already Exist.");
		}
		subDirectories.add(new Directory(this,name, new Date()));
	}
	
	/**
	 * This method is used to find all paths
	 * @param currentDirectory is the current directory
	 * @param name is Name to be search
	 * @param path is path of current directory
	 * @param paths will contain all the paths which matches with name
	 * @return paths
	 */
	public ArrayList<String> findAllPaths(Directory currentDirectory , String name , String path, ArrayList<String> paths) {
			for(Directory subDir: currentDirectory.getSubDirectories()) {
				if(subDir.getName().contains(name)) {
					paths.add(path +"\\"+subDir.getName());
				}
				findAllPaths(subDir , name , path+"\\"+subDir.getName(),paths);
			}
		return paths;
	}

	
	/**
	 * This method is used to find the directory
	 * @param name is Name to be search
	 * @param path is Current path 
	 * @return List of path which matches the name
	 */
	public void find(String name , String path) {
		List<String> paths = findAllPaths(this, name, path,
				new ArrayList<String>());
		for(String filePath : paths) {
			System.out.println(filePath);
		}
	}
	
	/**
	 * This method is used to move to parent directory
	 * @return parent directory
	 */
	public Directory back() {
		if(this.parentDirectory != null) 
			return this.parentDirectory;
		System.out.println("you are at root dir.");
		return this;
	}
	
	
	/**
	 * This method is used to show SubDirectories of Current Directory
	 */
	public void list() {
		for(Directory subDir : this.subDirectories) {
			System.out.println(subDir.getCreatedDate() + " " +subDir.getName());
		}
		System.out.println("Total Folder : "+this.subDirectories.size());
	}
	
	/**
	 * This method is used to display Tree structure
	 */
	public void tree(String path) {
		path = path + "-------";
		for(Directory subDir: this.subDirectories) {
			System.out.println(path+" "+subDir.getName());
			subDir.tree(path);
		}
		
	}

}
