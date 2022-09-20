package com.mindtree.voter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.voter.entity.Voter;
import com.mindtree.voter.repository.VoterRepository;

@Service
public class VoterService {
	
	@Autowired
	private VoterRepository voterRepository;

	public List<Voter> getAllVoter() {
		return voterRepository.findAll();
	}

	public Voter createVoter(Voter voter) {
		return voterRepository.save(voter);
	}

}
