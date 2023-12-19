package votesystem.controller;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import votesystem.service.VoteService;

@RestController

public class VoteCotroller {
	private final VoteService voteService;
    
	public VoteCotroller(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/entercandidate")
    public String enterCandidate(@RequestParam String  name) {
        return voteService.enterCandidate(name);
      
    }

    @GetMapping("/castvote")
    public int castVote(@RequestParam String name) {
        return voteService.castVote(name);
    }

    @GetMapping("/countvote")
    public int countVote(@RequestParam String name) {
        return voteService.countVote(name);
    }

    @GetMapping("/listvote")
    public Map<String, Integer> listVotes() {
        return voteService.listVotes();
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        return voteService.getWinner();
    }
    
    @GetMapping("/")
    public int add(@RequestParam Integer a)
    {
    	return a;
    	
    }

}
