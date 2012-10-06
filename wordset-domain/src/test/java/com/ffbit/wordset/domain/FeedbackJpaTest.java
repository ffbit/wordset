package com.ffbit.wordset.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class FeedbackJpaTest {

    @PersistenceContext
    private EntityManager em;

    private String comment;
    private HumanLanguage language;

    @Before
    public void setUp() throws Exception {
        comment = "The quick brown fox jumps over the lazy dog";
        language = HumanLanguage.EN;
    }

    @Test
    public void itShouldBePersistable() throws Exception {
        Feedback feedback = new Feedback(comment, language);

        em.persist(feedback);

        Feedback persisted = em.find(Feedback.class, feedback.getId());

        assertNotNull(persisted);
        assertThat(persisted.getComment(), is(comment));
        assertThat(persisted.getLanguage(), is(language));
    }

}
