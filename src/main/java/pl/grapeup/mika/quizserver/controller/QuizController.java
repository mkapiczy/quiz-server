package pl.grapeup.mika.quizserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grapeup.mika.quizserver.model.Quiz;
import pl.grapeup.mika.quizserver.service.QuizService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public List<Quiz> getAll() {
        return quizService.getAllQuizzes();
    }
}
