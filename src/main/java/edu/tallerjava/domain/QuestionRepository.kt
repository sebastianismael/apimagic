package edu.tallerjava.domain

import edu.tallerjava.domain.model.Question
import edu.tallerjava.domain.model.QuestionCategory

interface QuestionRepository {
    fun getQuestions(language: String, country: String, category: QuestionCategory? = null): MutableList<Question>
    fun getAlreadyAnsweredQuestionsOf(userId: String): List<Question>
}