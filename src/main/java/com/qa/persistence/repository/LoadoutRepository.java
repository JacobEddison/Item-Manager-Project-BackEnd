package com.qa.persistence.repository;

import com.qa.persistence.models.Loadout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadoutRepository extends JpaRepository<Loadout, Long> {
}
