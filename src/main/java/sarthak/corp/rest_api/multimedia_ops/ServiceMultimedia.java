package sarthak.corp.rest_api.multimedia_ops;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMultimedia {
	@Autowired
	private PersistentMultimedia persistent;
	
	public boolean saveFile(FileInformation info) {
//		if(info!=null) {
//			persistent.save(info);
//		}
//		return false;
		return (persistent.save(info)!=null?true:false);
	}
	
	public byte[] readFile(Integer id) {
		
		Optional<FileInformation> optional =persistent.findById(id);
		return (optional.isPresent()?optional.get().getFileData():null);
	}
	
	public FileInformation readVideo(Integer id) {
			
			Optional<FileInformation> optional =persistent.findById(id);
			return (optional.isPresent()?optional.get():null);
		}
	
}
