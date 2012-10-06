package com.ffbit.wordset.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TagTest {

    @Test
    public void itShouldBeEqual() throws Exception {
        Tag tag = new Tag("fox", "NN");

        assertThat(tag, is(new Tag("fox", "NN")));
    }

    @Test
    public void itShouldNotBeEqual() throws Exception {
        Tag tag = new Tag("fox", "NN");

        assertThat(tag, is(not(new Tag("fox", "JJ"))));
        assertThat(tag, is(not(new Tag("red", "NN"))));
        assertThat(tag, is(not(new Tag("red", "JJ"))));
    }

}
