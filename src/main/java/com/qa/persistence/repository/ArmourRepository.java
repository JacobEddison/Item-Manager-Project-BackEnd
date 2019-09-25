package com.qa.persistence.repository;

import com.qa.persistence.models.Armour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmourRepository extends JpaRepository<Armour,Long> {
}
