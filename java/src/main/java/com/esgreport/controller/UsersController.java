package com.esgreport.controller;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esgreport.SendingEmailApplication;
import com.esgreport.entity.User;
import com.esgreport.repository.UserRepository;
import com.esgreport.repository.UserRoleRepository;
import com.esgreport.service.UserServices;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/users/")
public class UsersController {
	private List<String> emails;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private SendingEmailApplication sendingEmailApplication;

	@Autowired
	private UserServices userServices;


	@RequestMapping(value = "/image/{imageid}",method= RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable Long imageid) throws IOException {
		
	   return userServices.getUserImg(imageid);
	    }

	@GetMapping(value = "/get-image-with-media-type", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType() throws IOException {
		InputStream in = getClass().getResourceAsStream("/com/baeldung/produceimage/image.jpg");
		return IOUtils.toByteArray(in);
	}

	@GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() throws IOException {

		
				return userRepository.findAll();
	}
	  /**
     * Get user. Allowed only for Admin
     * @param id user id
     * @return user
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return (ResponseEntity) userServices.getUserById(id);
    }

    /**
     * Update user. Allowed only for Admin
     * @param id user id
     * @param userDTO updated user data
     * @return updated user data
     
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
       = userServices.updateUserById(id, userDTO);
        return ok(updatedUser);
    }*/
	@GetMapping("/getAllUsers")
	public List<User> getUSersList() {
		return userRepository.findAll();
	}
//	@GetMapping("/getUserImg")
//	public   int getUserImg() {
//		return userRepository.getUserImg(1L);
//	}

	@PostMapping("/notifyModerators")
	public boolean notifyModerators(String s) {
		System.out.println(userRoleRepository.findModById(2L));
		for (String email : userRoleRepository.findModById(2L)) {
			sendingEmailApplication.sendEmail(email, "ESG Staffil Tool Moderator status update required",
					"Hello Moderator, ESG Data has been submitted, please visit below link to authorize. \n http://localhost:4200/login");
		}
		return true;
	}

	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		System.out.println("@GetMapping@GetMapping@GetMapping@GetMapping");
		return userServices.exportReport(format);
	}
}
