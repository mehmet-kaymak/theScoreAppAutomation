package utilities;

import java.nio.file.Path;
import java.nio.file.Paths;


public class GeneralUtilities {

	public String getFilePath(String fileRelativePath)
	{ 
		String currentDirectory=System.getProperty("user.dir");
		Path path= Paths.get(fileRelativePath);
		return currentDirectory.concat(path.toString());
	}

}
