package com.mbetter.repositories.dropdown;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mbetter.domain.dropdown.DropDown;

public interface DropDownRepository extends JpaRepository<DropDown, Serializable>{

	public List<DropDown> getAllDropDownValues(@Param("dropDownType") String dropDownType);
}
