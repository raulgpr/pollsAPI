package com.qut.polls.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Poll")
public class Poll {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="question")
	private String question;
	@Column(name="published_at")
	private Date publishedAt;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Choice> choices;
	
	protected Poll() {
	}
	
	public Poll(String question, Date publishedAt, List<Choice> choices) {
		super();
		this.question = question;
		this.publishedAt = publishedAt;
		this.choices = choices;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	public List<Choice> getChoices() {
		return choices;
	}
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	@Override
	public String toString() {
		return "Poll [id=" + id + ", question=" + question + ", publishedAt=" + publishedAt + ", choices=" + choices
				+ "]";
	}

}
