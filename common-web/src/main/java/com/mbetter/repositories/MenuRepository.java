package com.mbetter.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbetter.domain.MenuMaster;

@Repository
public interface MenuRepository extends JpaRepository<MenuMaster, Serializable> {
	List<MenuMaster> getAllActiveMenu();
}
