package pl.grapeup.mika.quizserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.grapeup.mika.quizserver.model.Quiz;
import pl.grapeup.mika.quizserver.service.QuizService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @CrossOrigin
    @GetMapping
    public List<Quiz> getAll() {
        return quizService.getAllQuizzes();
    }

    @CrossOrigin
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }
}
