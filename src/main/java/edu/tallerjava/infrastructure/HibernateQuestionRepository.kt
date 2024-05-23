package edu.tallerjava.infrastructure

import edu.tallerjava.domain.model.Question
import edu.tallerjava.domain.model.QuestionCategory
import edu.tallerjava.domain.QuestionRepository
import org.springframework.stereotype.Repository

@Repository
open class HibernateQuestionRepository: QuestionRepository {
    override fun getQuestions(
        language: String,
        country: String,
        category: QuestionCategory?
    ): MutableList<Question> {
        TODO("Not yet implemented")
    }

    override fun getAlreadyAnsweredQuestionsOf(userId: String): List<Question> {
        TODO("Not yet implemented")
    }
}