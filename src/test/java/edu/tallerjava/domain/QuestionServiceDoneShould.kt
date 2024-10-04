package edu.tallerjava.domain

import edu.tallerjava.domain.model.Question
import edu.tallerjava.domain.model.QuestionCategory
import edu.tallerjava.domain.model.QuestionCategory.ARTS
import edu.tallerjava.domain.model.QuestionCategory.SPORTS
import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class QuestionServiceDoneShould {

    private val spanish = "ES"
    private val argentina = "AR"
    private val userId = "jk56hk56h56jhkhjk"
    private lateinit var questionService: QuestionService
    private lateinit var questionRepository: QuestionRepository

    @Before
    fun setUp() {
        questionRepository = mock()
        questionService = QuestionServiceImpl(questionRepository)
    }

    @Test
    fun `search by language and country should not return already answered questions`() {
        givenUserAlreadyAnswered(11L)
        givenExistsQuestions(11L, 33L, 44L, 55L)

        val questions = whenGetPendingQuestions(2)

        questions shouldHaveSize 2
        questions.shouldBeSomeOf(33L, 44L, 55L)
    }

    @Test
    fun `search by language, country and category should not return already answered and other category questions`() {
        givenUserAlreadyAnswered(11L)
        givenExistsQuestions(ARTS, 11L, 33L, 44L, 55L)
        givenExistsQuestions(SPORTS, 66L, 77L)

        val questions = whenGetPendingQuestions(2, ARTS)

        questions shouldHaveSize 2
        questions.shouldBeSomeOf(33L, 44L, 55L)
    }

    private fun givenExistsQuestions(vararg ids: Long) {
        whenever(questionRepository.getQuestions(spanish, argentina)) doReturn questionsWith(ids.toList())
    }

    private fun givenUserAlreadyAnswered(vararg ids: Long) {
        whenever(questionRepository.getAlreadyAnsweredQuestionsOf(userId)) doReturn questionsWith(ids.toList())
    }

    private fun givenExistsQuestions(category: QuestionCategory, vararg ids: Long) {
        whenever(questionRepository.getQuestions(spanish, argentina, category)) doReturn questionsWith(ids.toList())
    }

    private fun whenGetPendingQuestions(amount: Int, category: QuestionCategory? = null) =
        questionService.getQuestions(argentina, spanish, category, amount, userId)

    private fun List<Question>.shouldBeSomeOf(vararg ids: Long) {
        ids.asList().shouldContainAll(this.map { it.id })
    }

    private fun questionsWith(ids: List<Long>) =
        ids.map {id ->
            val q = Question()
            q.id = id
            q
        }.toMutableList()
}