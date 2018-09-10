package com.qut.polls.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qut.polls.entity.Poll;

public interface PollRepository extends JpaRepository<Poll, Integer>{
	
}
