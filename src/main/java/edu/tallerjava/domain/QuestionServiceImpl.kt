package edu.tallerjava.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("QuestionService")
class QuestionServiceImpl(@Autowired private var questionRepository: QuestionRepository) : QuestionService {

    override fun getQuestions(
        country: String,
        language: String,
        category: QuestionCategory?,
        quantity: Int,
        userId: String
    ): List<Question> {
        val questions = findQuestionsWith(country, language, category)
        val answeredQuestions = questionRepository.getAlreadyAnsweredQuestionsOf(userId)

        val notAnswered = filterAlreadyAnsered(questions, answeredQuestions)

        checkQuestionsLeft(notAnswered, quantity)
        return shuffleAndTake(notAnswered.toMutableList(), quantity)
    }

    private fun filterAlreadyAnsered(
        questions: MutableList<Question>,
        answeredQuestions: List<Question>
    ) = questions.filterNot { question -> answeredQuestions.map { it.id }.contains(question.id) }

    private fun findQuestionsWith(country: String, language: String, category: QuestionCategory?) =
        category?.let {
            questionRepository.getQuestions(language, country, it)
        } ?: questionRepository.getQuestions(language, country)

    private fun shuffleAndTake(availableIds: MutableList<Question>, quantity: Int) =
        availableIds.shuffled().take(quantity)

    private fun checkQuestionsLeft(availableIds: List<Question>, quantity: Int) {
        when {
            availableIds.size < quantity -> throw RuntimeException("Not enough questions")
        }
    }
}