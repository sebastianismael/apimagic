package edu.tallerjava.domain

interface QuestionRepository {
    fun getQuestions(language: String, country: String, category: QuestionCategory? = null): MutableList<Question>
    fun getAlreadyAnsweredQuestionsOf(userId: String): List<Question>
}