package br.com.my_jhipster.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.com.my_jhipster.domain.Memory_user;

import br.com.my_jhipster.repository.Memory_userRepository;
import br.com.my_jhipster.web.rest.errors.BadRequestAlertException;
import br.com.my_jhipster.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Memory_user.
 */
@RestController
@RequestMapping("/api")
public class Memory_userResource {

    private final Logger log = LoggerFactory.getLogger(Memory_userResource.class);

    private static final String ENTITY_NAME = "memory_user";

    private final Memory_userRepository memory_userRepository;

    public Memory_userResource(Memory_userRepository memory_userRepository) {
        this.memory_userRepository = memory_userRepository;
    }

    /**
     * POST  /memory-users : Create a new memory_user.
     *
     * @param memory_user the memory_user to create
     * @return the ResponseEntity with status 201 (Created) and with body the new memory_user, or with status 400 (Bad Request) if the memory_user has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/memory-users")
    @Timed
    public ResponseEntity<Memory_user> createMemory_user(@Valid @RequestBody Memory_user memory_user) throws URISyntaxException {
        log.debug("REST request to save Memory_user : {}", memory_user);
        if (memory_user.getId() != null) {
            throw new BadRequestAlertException("A new memory_user cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Memory_user result = memory_userRepository.save(memory_user);
        return ResponseEntity.created(new URI("/api/memory-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /memory-users : Updates an existing memory_user.
     *
     * @param memory_user the memory_user to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated memory_user,
     * or with status 400 (Bad Request) if the memory_user is not valid,
     * or with status 500 (Internal Server Error) if the memory_user couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/memory-users")
    @Timed
    public ResponseEntity<Memory_user> updateMemory_user(@Valid @RequestBody Memory_user memory_user) throws URISyntaxException {
        log.debug("REST request to update Memory_user : {}", memory_user);
        if (memory_user.getId() == null) {
            return createMemory_user(memory_user);
        }
        Memory_user result = memory_userRepository.save(memory_user);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, memory_user.getId().toString()))
            .body(result);
    }

    /**
     * GET  /memory-users : get all the memory_users.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of memory_users in body
     */
    @GetMapping("/memory-users")
    @Timed
    public List<Memory_user> getAllMemory_users() {
        log.debug("REST request to get all Memory_users");
        return memory_userRepository.findAll();
        }

    /**
     * GET  /memory-users/:id : get the "id" memory_user.
     *
     * @param id the id of the memory_user to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the memory_user, or with status 404 (Not Found)
     */
    @GetMapping("/memory-users/{id}")
    @Timed
    public ResponseEntity<Memory_user> getMemory_user(@PathVariable Long id) {
        log.debug("REST request to get Memory_user : {}", id);
        Memory_user memory_user = memory_userRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(memory_user));
    }

    /**
     * DELETE  /memory-users/:id : delete the "id" memory_user.
     *
     * @param id the id of the memory_user to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/memory-users/{id}")
    @Timed
    public ResponseEntity<Void> deleteMemory_user(@PathVariable Long id) {
        log.debug("REST request to delete Memory_user : {}", id);
        memory_userRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
