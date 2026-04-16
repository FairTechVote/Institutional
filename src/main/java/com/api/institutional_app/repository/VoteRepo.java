package com.api.institutional_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.institutional_app.entity.Vote;

@Repository
public interface VoteRepo extends JpaRepository<Vote, Long> {

}
