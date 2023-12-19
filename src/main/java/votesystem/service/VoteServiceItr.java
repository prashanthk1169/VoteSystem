package votesystem.service;
import java.util.*;
public interface VoteServiceItr {
	   String enterCandidate(String name);
	    int castVote(String name);
	    int countVote(String name);
	    Map<String, Integer> listVotes();
	    String getWinner();

}
