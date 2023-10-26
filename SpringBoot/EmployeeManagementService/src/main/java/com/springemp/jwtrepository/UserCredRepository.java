package com.springemp.jwtrepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springemp.jwtentity.UserCred;

@Repository
public interface UserCredRepository extends  JpaRepository<UserCred, Integer> {
	
	Optional<UserCred> findByName(String username);

}
