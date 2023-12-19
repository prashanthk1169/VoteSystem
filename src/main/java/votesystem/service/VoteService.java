package votesystem.service;
import java.util.*;

import org.springframework.stereotype.Service;

import votesystem.model.Candidate;

@Service
public class VoteService implements VoteServiceItr {
	
	 private final Map<String, Candidate> candidateVotes = new HashMap<>();

	    @Override
	    public String enterCandidate(String name) {
	        Candidate candidate = new Candidate();
	        candidate.setName(name);
	        candidate.setVoteCount(0);
	        candidateVotes.put(name, candidate);
	        
	        return name+" is successfully added";
	       
	    }

	    @Override
	    public int castVote(String name) {
	        validateCandidate(name);
	        Candidate candidate = candidateVotes.get(name);
	        candidate.setVoteCount(candidate.getVoteCount() + 1);
	        return candidate.getVoteCount();
	    }

	    @Override
	    public int countVote(String name) {
	        validateCandidate(name);
	        return candidateVotes.get(name).getVoteCount();
	    }

	    @Override
	    public Map<String, Integer> listVotes() {
	        Map<String, Integer> result = new HashMap<>();
	        candidateVotes.forEach((name, candidate) -> result.put(name, candidate.getVoteCount()));
	        return result;
	    }

	    @Override
	    public String getWinner() {
	        Candidate winner = candidateVotes.values().stream().max((c1, c2) -> Integer.compare(c1.getVoteCount(), c2.getVoteCount())).orElse(null);
	        return (winner != null) ? winner.getName() : null;
	    }

	    private void validateCandidate(String name) {
	        if (!candidateVotes.containsKey(name)) {
	            throw new IllegalArgumentException("Invalid candidate name");
	        }
	    }

}
