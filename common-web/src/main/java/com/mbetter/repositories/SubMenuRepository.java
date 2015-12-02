package com.mbetter.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbetter.domain.SubMenuMaster;

@Repository
public interface SubMenuRepository extends
		JpaRepository<SubMenuMaster, Serializable> {

}
