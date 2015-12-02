package com.mbetter.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbetter.domain.MenuMaster;

@Repository
public interface MenuRepository extends JpaRepository<MenuMaster, Serializable> {

}
