package pro.sky.coursework2.service;

import pro.sky.coursework2.object.Question;
import pro.sky.coursework2.exception.NotEnoughQuestionException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService underTest = new JavaQuestionService();
    private Question question = new Question("one", "four");

    @Test
    void shouldAddQuestionToSetAndReturnQuestion() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());
        assertTrue(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void shouldRemoveQuestionOfSetAndReturnQuestion() {
        underTest.add(question);
        Question result = underTest.remove(question);
        assertFalse(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void shouldReturnAllQuestionCollection() {
        Question question1 = new Question("q1", "a1");
        underTest.add(question);
        underTest.add(question1);
        Collection<Question> result = underTest.getAll();
        assertEquals(Set.of(question, question1), result);
    }

    @Test
    void shouldThrowExceptionWhenCollectionIsEmptyInGetRandomQuestion() {
        assertThrows(NotEnoughQuestionException.class,
                () ->underTest.getRandomQuestion());
    }

    @Test
    void shouldReturnQuestionWhenCollectionIsNotEmptyInGetRandomQuestion() {
        underTest.add(question);
        Question result = underTest.getRandomQuestion();
        assertEquals(question, result);
    }
}
