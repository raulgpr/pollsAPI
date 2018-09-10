package com.qut.polls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import com.qut.polls.entity.Choice;
import com.qut.polls.entity.Poll;
import com.qut.polls.service.PollRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollsApplicationTests {
	
	@Autowired
    private TestEntityManager entityManager;
	
    @Autowired
    private PollRepository pollRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void findInsertedPoll() {
		Choice[] choice = {new Choice("Sushi", 393),
				new Choice("Fideua", 500),
				new Choice("PadThai", 394),
				new Choice("Tuna Sandwich", 1)};
		
		Poll poll = new Poll("Favourite dish?",new Date(),new ArrayList<Choice>(Arrays.asList(choice)));
		
	    // given
	    Poll inserted = entityManager.persist(poll);
	    entityManager.flush();
	 
	    // when
	    Optional<Poll> found = pollRepository.findById(inserted.getId());
	 
	    // then
	    assertThat(found.get().getQuestion()).isEqualTo(poll.getQuestion());
	}
	
}
