package dz.wta.ooredoo.simswap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.wta.ooredoo.simswap.entity.SwapEsnEntry;

public interface SwapEsnRepository extends JpaRepository<SwapEsnEntry, Long> {

	SwapEsnEntry findBymsisdn(String msisdnStorm);
}
