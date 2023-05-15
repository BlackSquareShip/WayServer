package ru.wayproj.wayserver.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.wayproj.wayserver.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}