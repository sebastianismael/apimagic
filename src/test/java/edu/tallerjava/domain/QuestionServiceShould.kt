package edu.tallerjava.domain

import edu.tallerjava.domain.model.QuestionCategory.*
import edu.tallerjava.domain.model.Question
import org.amshove.kluent.shouldContainAll
import org.amshove.kluent.shouldHaveSize
import org.junit.Test
import org.junit.Before
import org.mockito.kotlin.*

private const val ES = "ES"
private const val AR = "AR"

class QuestionServiceShould {

    private lateinit var questionService: QuestionService
    private lateinit var questionRepository: QuestionRepository

    @Before
    fun setUp() {
        questionRepository = mock()
        questionService = QuestionServiceImpl(questionRepository)
    }

    @Test
    fun `get Questions`() {//koko
        whenever(questionRepository.getAlreadyAnsweredQuestionsOf("565757")) doReturn questionsWith(11L)
        whenever(questionRepository.getQuestions(ES, AR)) doReturn questionsWith(11L, 33L, 44L, 55L)

        val result = questionService.getQuestions(AR, ES, null, 2, "565757")

        result shouldHaveSize 2
        result.shouldBeSomeOf(33L, 44L, 55L)
    }

    @Test
    fun `get Questions by category`() {
        whenever(questionRepository.getAlreadyAnsweredQuestionsOf("565757")) doReturn questionsWith(11L)
        whenever(questionRepository.getQuestions(ES, AR, ARTS)) doReturn questionsWith(11L, 33L, 44L, 55L)
        whenever(questionRepository.getQuestions(ES, AR, SPORTS)) doReturn questionsWith(66L, 77L)

        val result = questionService.getQuestions(AR, ES, ARTS, 2, "565757")

        result shouldHaveSize 2
        result.shouldBeSomeOf(33L, 44L, 55L)
    }

    private fun List<Question>.shouldBeSomeOf(vararg ids: Long) {
        ids.asList().shouldContainAll(this.map { it.id })
    }

    private fun questionsWith(vararg ids: Long) =
        ids.map {id ->
            val q = Question()
            q.id = id
            q
        }.toMutableList()
}