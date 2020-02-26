package pl.grapeup.mika.quizserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private Long id;
    private String title;
    private List<Question> questions;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Question {
        private Long id;
        private String value;
        private Long correctAnswerId;
        private List<Answer> answers;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Answer {
            private Long id;
            private String value;
        }

    }
}

