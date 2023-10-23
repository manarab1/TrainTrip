package com.example.TrainTrip.Repository;
import com.example.TrainTrip.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
