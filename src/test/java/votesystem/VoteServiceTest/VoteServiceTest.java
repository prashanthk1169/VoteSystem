package votesystem.VoteServiceTest;


	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

import votesystem.service.VoteService;

import static org.junit.jupiter.api.Assertions.*;

	public class VoteServiceTest {

	    private VoteService voteService;

	    @BeforeEach
	    void setUp() {
	        voteService = new VoteService();
	        voteService.enterCandidate("John Doe");
	        voteService.enterCandidate("Jane Smith");
	    }

	    @Test
	    void castVote_validCandidate() {
	        int result = voteService.castVote("John Doe");
	        assertEquals(1, result);
	    }

	    @Test
	    void castVote_invalidCandidate() {
	        assertThrows(IllegalArgumentException.class, () -> voteService.castVote("Invalid Candidate"));
	    }

	    @Test
	    void countVote() {
	        int result = voteService.countVote("John Doe");
	        assertEquals(0, result);

	        voteService.castVote("John Doe");
	        result = voteService.countVote("John Doe");
	        assertEquals(1, result);
	    }

	    @Test
	    void listVotes() {
	        voteService.castVote("John Doe");
	        voteService.castVote("Jane Smith");

	        assertEquals(2, voteService.listVotes().size());
	        assertEquals(1, voteService.listVotes().get("John Doe"));
	        assertEquals(1, voteService.listVotes().get("Jane Smith"));
	    }

	    @Test
	    void getWinner() {
	        voteService.castVote("John Doe");
	        voteService.castVote("Jane Smith");
	        assertEquals("John Doe", voteService.getWinner());

	        voteService.castVote("John Doe");
	        assertEquals("John Doe", voteService.getWinner());

	        voteService.castVote("Jane Smith");
	        assertEquals("Jane Smith", voteService.getWinner());
	    }
	}




