package com.qut.polls;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.qut.polls.entity.Poll;
import com.qut.polls.service.PollRepository;

@RestController
public class PollsController {
	@Autowired
	private PollRepository pollRepository;

	@RequestMapping(method=RequestMethod.GET, path="questions")
	public List<Poll> getAllQuestions() {
		return pollRepository.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)	
	@RequestMapping(method=RequestMethod.POST, path="/")
	public Poll insertPoll(@Valid @RequestBody Poll poll) {
		pollRepository.save(poll);
		return poll;
	}
}
