package pl.grapeup.mika.quizserver.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import pl.grapeup.mika.quizserver.model.Quiz;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class QuizInMemoryRepository implements QuizRepository {
    private Set<Quiz> quizzes = ConcurrentHashMap.newKeySet();

    @PostConstruct
    private void init() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Quiz>> typeReference = new TypeReference<>() {
        };
        try {
            InputStream inputStream = new FileInputStream(ResourceUtils.getFile("classpath:json/quizzes.json"));
            quizzes.addAll(mapper.readValue(inputStream, typeReference));
        } catch (IOException e) {
            log.error("Error reading quizzes", e);
        }
    }

    @Override
    public List<Quiz> getAll() {
        return new ArrayList<>(this.quizzes);
    }

    @Override
    public Quiz save(Quiz quiz) {
        this.quizzes.add(quiz);
        return quiz;
    }
}
