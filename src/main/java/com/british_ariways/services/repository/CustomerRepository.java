package com.british_ariways.services.repository;

import com.british_ariways.services.model.BritishAirwaysTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<BritishAirwaysTb, Integer> {

  @Query(value="SELECT s FROM BritishAirwaysTb s WHERE passengerName=:name and bookReference=:refNo")
  public BritishAirwaysTb fetchUsingPassengerNameAndBookReference(@Param("name") String name , @Param("refNo") String ref);

}
