package com.idm.brian.repositories;

import com.idm.brian.model.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleModel, Long> {
}
