package dz.wta.ooredoo.simswap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.wta.ooredoo.simswap.entity.SwapEntry;

public interface Repository extends JpaRepository<SwapEntry, Long> {

}
