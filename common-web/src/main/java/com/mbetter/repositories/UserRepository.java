package com.mbetter.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mbetter.domain.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Serializable> {

	public UserData getUser(@Param("id") int id);

	public UserData findUserByEmail(@Param("email") String email);

	public List<UserData> findUsersByEmail(@Param("email") String email);
}
