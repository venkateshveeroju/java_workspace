package com.esgreport.repository;

public interface SendingMailService {
	 boolean sendMail(String email,String subject,String message);
}
