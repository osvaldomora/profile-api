package mx.santander.fiduciarioplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.fiduciarioplus.dto.getprofile.DataProfileResDto;
import mx.santander.fiduciarioplus.service.IProfileService;



@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST}, allowedHeaders = "*")
@RequestMapping("/api/profiles/v1")
public class ProfileController {

	@Autowired
	IProfileService iProfileService;
	
	@GetMapping(value = "/profiles/{buc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ListProfiles(@PathVariable String buc) {
		
		iProfileService.saveData();//it won't use in the future
		DataProfileResDto data =iProfileService.convert(buc);

  
      return ResponseEntity.status(HttpStatus.OK).body(data);
		
	}
	

}
