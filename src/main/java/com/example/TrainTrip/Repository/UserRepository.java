package com.example.TrainTrip.Repository;
import com.example.TrainTrip.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
