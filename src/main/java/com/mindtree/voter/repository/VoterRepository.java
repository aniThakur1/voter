package com.mindtree.voter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.voter.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, String> {

}
