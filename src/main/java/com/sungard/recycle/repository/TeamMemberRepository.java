package com.sungard.recycle.repository;

import com.sungard.recycle.dto.TeamMember;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by Rakesh.Sharma on 6/10/2016.
 */
public interface TeamMemberRepository extends CrudRepository<TeamMember, Long>{

    TeamMember findByEmpName(String name);
}
