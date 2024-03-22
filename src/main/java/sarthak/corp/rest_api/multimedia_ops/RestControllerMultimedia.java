package sarthak.corp.rest_api.multimedia_ops;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.util.ContentTypeUtil;
import sarthak.corp.rest_api.exception.handling.InvalidAgeExeption;

@RestController
@RequestMapping(value = "/multimedia")

public class RestControllerMultimedia {
	@Autowired
	private ServiceMultimedia service;

	@PostMapping(value = "/save")
	public ResponseEntity<Boolean> saveFile(@RequestBody MultipartFile file) throws IOException {
		FileInformation fileBinding = new FileInformation();
		fileBinding.setFileName(file.getOriginalFilename());
		fileBinding.setFileData(file.getBytes());
		fileBinding.setFileType(file.getContentType());

		return ResponseEntity.status(HttpStatus.OK).body(service.saveFile(fileBinding));
	}

	// Getting saved file form database
	@GetMapping(value = "read/{id}",produces = "text/plain")
	public ResponseEntity<byte[]> readFile(@PathVariable Integer id) {
		if (id < 0) {
			throw new InvalidAgeExeption();
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.readFile(id));
//		we can add like 
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(service.readFile(id));
	}

//	Now its time to saving the Video format data

	@PostMapping(value = "/saveVideo")
	public ResponseEntity<Boolean> saveVideo(@RequestBody MultipartFile file) throws IOException {
		FileInformation fileBinding = new FileInformation();
		fileBinding.setFileName(file.getOriginalFilename());
		fileBinding.setFileData(file.getBytes());
		fileBinding.setFileType(file.getContentType());
//		this.saveFile(video);
		return ResponseEntity.status(HttpStatus.OK).body(service.saveFile(fileBinding));
	}

	@GetMapping(value = "/readVideo/{vId}")
	public ResponseEntity<byte[]> readVideo(@PathVariable Integer vId) {
		if (vId < 0) {
			throw new InvalidAgeExeption();
		}
		FileInformation video= service.readVideo(vId);
		return (video!=null)?ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(video.getFileType())).body(service.readFile(vId)):null;
	}
}
