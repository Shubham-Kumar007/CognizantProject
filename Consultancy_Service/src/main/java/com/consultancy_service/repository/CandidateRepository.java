package com.consultancy_service.repository;

import com.consultancy_service.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    List<Candidate> findCandidateByRoleAndTech1AndTech2(String role,String tech1, String tech2);
   List<Candidate> findCandidateByRoleAndTech1(String role,String tech1);
}
