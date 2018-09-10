package com.qut.polls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.qut.polls.entity.Choice;
import com.qut.polls.entity.Poll;
import com.qut.polls.service.PollRepository;

@Component
public class PollRepositoryCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private PollRepository pollRepository;

	@Override
	public void run(String... args) throws Exception {		
		String[] listQuestions = getMockUpQuestions();
		List<Choice[]> listChoices = getMockUpChoices();
		
		for (int i = 0; i < listQuestions.length; i++) {
			Poll p = new Poll(listQuestions[i],new Date(),new ArrayList<Choice>(Arrays.asList(listChoices.get(i))));
			pollRepository.save(p);
		}
		
	}
	
	private String[] getMockUpQuestions() {
		String[] questions = {
				"Favorite programming language?",
				"Hot beverage?",
				"Favorite colour?"};
		return questions;
	}
	
	private List<Choice[]> getMockUpChoices() {
		List<Choice[]> choiceList = new ArrayList<Choice[]>();
		
		Choice[] choice1 = {new Choice("Swift", 2048),
				new Choice("Python", 1024),
				new Choice("Objective-C", 512),
				new Choice("Ruby", 256)};
		
		Choice[] choice2 = {new Choice("Coffee", 23),
				new Choice("Tea", 100),
				new Choice("Milk", 45)};
		
		Choice[] choice3 = {new Choice("Red", 12),
				new Choice("Yellow", 33),
				new Choice("Blue", 50),
				new Choice("Black", 1),
				new Choice("White", 9),
				new Choice("Green", 21)};

		choiceList.add(choice1);
		choiceList.add(choice2);
		choiceList.add(choice3);
		
		return choiceList;
	}

}
