package edu.tallerjava.domain

import edu.tallerjava.domain.model.Question
import edu.tallerjava.domain.model.QuestionCategory

interface QuestionService {

    fun getQuestions(
        country: String,
        language: String,
        category: QuestionCategory?,
        quantity: Int,
        userId: String
    ): List<Question>
}
