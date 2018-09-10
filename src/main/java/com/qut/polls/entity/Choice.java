package com.qut.polls.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Choice")
public class Choice {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="choice")
	private String choice;
	@Column(name="votes")
	private int votes;
	@ManyToMany(mappedBy="choices")
	private List<Poll> polls;
	
	protected Choice() {
	}
	
	public Choice(String choice, int votes) {
		super();
		this.choice = choice;
		this.votes = votes;
	}
	
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Choice [choice=" + choice + ", votes=" + votes + "]";
	}

}
