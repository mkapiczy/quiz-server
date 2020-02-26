package pl.grapeup.mika.quizserver.repository;

import pl.grapeup.mika.quizserver.model.Quiz;

import java.util.List;

public interface QuizRepository {
    List<Quiz> getAll();

    Quiz save(Quiz quiz);
}
