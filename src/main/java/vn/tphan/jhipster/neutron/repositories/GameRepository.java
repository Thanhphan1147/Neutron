package vn.tphan.jhipster.neutron.repositories;

import org.springframework.stereotype.Repository;
import vn.tphan.jhipster.core.CustomJpaRepository;
import vn.tphan.jhipster.neutron.models.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CustomJpaRepository<Game, Long> {
    Game findFirstByName(String name);
    List<Game> findAll();
    Game findByNameIgnoreCase(String name);
    Optional<Game> findByName(String name);
}

