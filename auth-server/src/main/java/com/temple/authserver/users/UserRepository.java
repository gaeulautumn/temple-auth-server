package com.temple.authserver.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TestUser, Long> {
    TestUser findByUsername(String username);
}
