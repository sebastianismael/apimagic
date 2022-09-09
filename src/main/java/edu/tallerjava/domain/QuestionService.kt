package edu.tallerjava.domain

interface QuestionService {

    fun getQuestions(
        country: String,
        language: String,
        category: QuestionCategory?,
        quantity: Int,
        userId: String
    ): List<Question>
}
