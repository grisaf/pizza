package org.exercise.pizza.dao;

import org.exercise.pizza.model.Crust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrustRepository extends JpaRepository<Crust, Long> {

}
