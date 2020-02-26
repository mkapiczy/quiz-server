package pl.grapeup.mika.quizserver.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import pl.grapeup.mika.quizserver.model.Quiz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizService {

    public List<Quiz> getAllQuizzes() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Quiz>> typeReference = new TypeReference<>() {
        };
        try {
            InputStream inputStream = new FileInputStream(ResourceUtils.getFile("classpath:json/quizzes.json"));
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            log.error("Error reading quizzes", e);
            return Collections.emptyList();
        }
    }
}
