package dz.wta.ooredoo.simswap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.wta.ooredoo.simswap.entity.Reason;

public interface ReasonRepository extends JpaRepository<Reason, Long> {

	Reason findByreason(String reason);

}
