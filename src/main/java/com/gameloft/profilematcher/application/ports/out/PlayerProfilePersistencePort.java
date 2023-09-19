package com.gameloft.profilematcher.application.ports.out;

import com.gameloft.profilematcher.application.domain.entity.PlayerProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfilePersistencePort extends JpaRepository<PlayerProfileEntity, String> {
}
