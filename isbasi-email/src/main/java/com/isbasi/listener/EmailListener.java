package com.isbasi.listener;

import com.isbasi.model.Email;
import com.isbasi.repository.EmailRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isbasi.dto.EmailDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailListener {

	@Autowired
	private EmailRepository emailRepository;

//	@RabbitListener(queues = "isbasi.email")
//	public void emailListener(EmailDto emailDto) {
//		log.info("email address: {}", emailDto.getEmail());
//		// TO DO mail at
//	}
	@RabbitListener(queues = "isbasi.email")
	public EmailDto emailCreate(EmailDto emailDto) {
		return emailRepository.save(emailDto);
	}

}
