package com.mindtree.voter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.voter.entity.Voter;
import com.mindtree.voter.service.VoterService;

@RestController
@RequestMapping("/api/v1/")
public class VoterController {
	
	@Autowired
	private VoterService voterService;
	
	@CrossOrigin
	@GetMapping("/voter")
	public List<Voter> getAllVoter(){
		return voterService.getAllVoter();
		
	}
	
	@CrossOrigin
	@PostMapping("/voter")
	public Voter createVoter(@RequestBody Voter voter) {
		return voterService.createVoter(voter);
	}
	

}
