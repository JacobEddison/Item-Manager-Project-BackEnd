package com.qa.repository;

import com.qa.models.Loadout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadoutRepository extends JpaRepository<Loadout, Long> {
}
