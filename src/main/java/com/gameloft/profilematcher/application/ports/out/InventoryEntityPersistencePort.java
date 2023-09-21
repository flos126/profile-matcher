package com.gameloft.profilematcher.application.ports.out;

import com.gameloft.profilematcher.application.domain.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryEntityPersistencePort extends JpaRepository<InventoryEntity, Long> {
}
