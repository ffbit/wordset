package com.ffbit.wordset.domain;

import static org.hamcrest.CoreMatchers.is;
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
public class TagJpaTest {

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
    public void itShouldBePersistableWithFeedback() throws Exception {
        Feedback feedback = new Feedback(comment, language);

        for (String noun : "cat dog fox".split(" ")) {
            feedback.addTag(new Tag(noun, "NN"));
        }

        em.persist(feedback);

        Feedback persisted = em.find(Feedback.class, feedback.getId());

        assertThat(persisted.getTags().size(), is(3));
    }

}
