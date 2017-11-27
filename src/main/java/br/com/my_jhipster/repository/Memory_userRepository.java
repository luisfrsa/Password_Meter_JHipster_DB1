package br.com.my_jhipster.repository;

import br.com.my_jhipster.domain.Memory_user;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Memory_user entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Memory_userRepository extends JpaRepository<Memory_user, Long> {

}
