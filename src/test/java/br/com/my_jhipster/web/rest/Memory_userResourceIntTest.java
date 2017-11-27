package br.com.my_jhipster.web.rest;

import br.com.my_jhipster.MyJhipsterApp;

import br.com.my_jhipster.domain.Memory_user;
import br.com.my_jhipster.repository.Memory_userRepository;
import br.com.my_jhipster.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static br.com.my_jhipster.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the Memory_userResource REST controller.
 *
 * @see Memory_userResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyJhipsterApp.class)
public class Memory_userResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_SCORE = 0;
    private static final Integer UPDATED_SCORE = 1;

    private static final Integer DEFAULT_NUM_CARDS = 0;
    private static final Integer UPDATED_NUM_CARDS = 1;

    @Autowired
    private Memory_userRepository memory_userRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restMemory_userMockMvc;

    private Memory_user memory_user;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Memory_userResource memory_userResource = new Memory_userResource(memory_userRepository);
        this.restMemory_userMockMvc = MockMvcBuilders.standaloneSetup(memory_userResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Memory_user createEntity(EntityManager em) {
        Memory_user memory_user = new Memory_user()
            .name(DEFAULT_NAME)
            .score(DEFAULT_SCORE)
            .num_cards(DEFAULT_NUM_CARDS);
        return memory_user;
    }

    @Before
    public void initTest() {
        memory_user = createEntity(em);
    }

    @Test
    @Transactional
    public void createMemory_user() throws Exception {
        int databaseSizeBeforeCreate = memory_userRepository.findAll().size();

        // Create the Memory_user
        restMemory_userMockMvc.perform(post("/api/memory-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memory_user)))
            .andExpect(status().isCreated());

        // Validate the Memory_user in the database
        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeCreate + 1);
        Memory_user testMemory_user = memory_userList.get(memory_userList.size() - 1);
        assertThat(testMemory_user.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testMemory_user.getScore()).isEqualTo(DEFAULT_SCORE);
        assertThat(testMemory_user.getNum_cards()).isEqualTo(DEFAULT_NUM_CARDS);
    }

    @Test
    @Transactional
    public void createMemory_userWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = memory_userRepository.findAll().size();

        // Create the Memory_user with an existing ID
        memory_user.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMemory_userMockMvc.perform(post("/api/memory-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memory_user)))
            .andExpect(status().isBadRequest());

        // Validate the Memory_user in the database
        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = memory_userRepository.findAll().size();
        // set the field null
        memory_user.setName(null);

        // Create the Memory_user, which fails.

        restMemory_userMockMvc.perform(post("/api/memory-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memory_user)))
            .andExpect(status().isBadRequest());

        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkScoreIsRequired() throws Exception {
        int databaseSizeBeforeTest = memory_userRepository.findAll().size();
        // set the field null
        memory_user.setScore(null);

        // Create the Memory_user, which fails.

        restMemory_userMockMvc.perform(post("/api/memory-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memory_user)))
            .andExpect(status().isBadRequest());

        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNum_cardsIsRequired() throws Exception {
        int databaseSizeBeforeTest = memory_userRepository.findAll().size();
        // set the field null
        memory_user.setNum_cards(null);

        // Create the Memory_user, which fails.

        restMemory_userMockMvc.perform(post("/api/memory-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memory_user)))
            .andExpect(status().isBadRequest());

        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMemory_users() throws Exception {
        // Initialize the database
        memory_userRepository.saveAndFlush(memory_user);

        // Get all the memory_userList
        restMemory_userMockMvc.perform(get("/api/memory-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(memory_user.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].score").value(hasItem(DEFAULT_SCORE)))
            .andExpect(jsonPath("$.[*].num_cards").value(hasItem(DEFAULT_NUM_CARDS)));
    }

    @Test
    @Transactional
    public void getMemory_user() throws Exception {
        // Initialize the database
        memory_userRepository.saveAndFlush(memory_user);

        // Get the memory_user
        restMemory_userMockMvc.perform(get("/api/memory-users/{id}", memory_user.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(memory_user.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.score").value(DEFAULT_SCORE))
            .andExpect(jsonPath("$.num_cards").value(DEFAULT_NUM_CARDS));
    }

    @Test
    @Transactional
    public void getNonExistingMemory_user() throws Exception {
        // Get the memory_user
        restMemory_userMockMvc.perform(get("/api/memory-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMemory_user() throws Exception {
        // Initialize the database
        memory_userRepository.saveAndFlush(memory_user);
        int databaseSizeBeforeUpdate = memory_userRepository.findAll().size();

        // Update the memory_user
        Memory_user updatedMemory_user = memory_userRepository.findOne(memory_user.getId());
        updatedMemory_user
            .name(UPDATED_NAME)
            .score(UPDATED_SCORE)
            .num_cards(UPDATED_NUM_CARDS);

        restMemory_userMockMvc.perform(put("/api/memory-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedMemory_user)))
            .andExpect(status().isOk());

        // Validate the Memory_user in the database
        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeUpdate);
        Memory_user testMemory_user = memory_userList.get(memory_userList.size() - 1);
        assertThat(testMemory_user.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testMemory_user.getScore()).isEqualTo(UPDATED_SCORE);
        assertThat(testMemory_user.getNum_cards()).isEqualTo(UPDATED_NUM_CARDS);
    }

    @Test
    @Transactional
    public void updateNonExistingMemory_user() throws Exception {
        int databaseSizeBeforeUpdate = memory_userRepository.findAll().size();

        // Create the Memory_user

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restMemory_userMockMvc.perform(put("/api/memory-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(memory_user)))
            .andExpect(status().isCreated());

        // Validate the Memory_user in the database
        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteMemory_user() throws Exception {
        // Initialize the database
        memory_userRepository.saveAndFlush(memory_user);
        int databaseSizeBeforeDelete = memory_userRepository.findAll().size();

        // Get the memory_user
        restMemory_userMockMvc.perform(delete("/api/memory-users/{id}", memory_user.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Memory_user> memory_userList = memory_userRepository.findAll();
        assertThat(memory_userList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Memory_user.class);
        Memory_user memory_user1 = new Memory_user();
        memory_user1.setId(1L);
        Memory_user memory_user2 = new Memory_user();
        memory_user2.setId(memory_user1.getId());
        assertThat(memory_user1).isEqualTo(memory_user2);
        memory_user2.setId(2L);
        assertThat(memory_user1).isNotEqualTo(memory_user2);
        memory_user1.setId(null);
        assertThat(memory_user1).isNotEqualTo(memory_user2);
    }
}
