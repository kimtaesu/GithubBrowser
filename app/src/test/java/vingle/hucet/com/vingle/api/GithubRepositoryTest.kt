package vingle.hucet.com.vingle.api

import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Flowable
import org.amshove.kluent.any
import org.amshove.kluent.mock
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.Assert.*
import vingle.hucet.com.vingle.fixture.GithubFixture
import vingle.hucet.com.vingle.repository.GithubRepository

/**
 * Created by taesu on 2017-12-04.
 */
class GithubRepositoryTest : SubjectSpek<GithubRepository>({

    val githubDataSource by memoized {
        mock<GithubDataSource>()
    }
    given("GithubRepository")
    {
        subject {
            GithubRepository(githubDataSource)
        }
        on("Subscriber 상태 체크")
        {
            whenever(githubDataSource.getRepos(any())).thenReturn(Flowable.just(listOf()))
            whenever(githubDataSource.getUser(any())).thenReturn(Flowable.just(GithubFixture.userInfo()))
            val testSub = subject.getUserDesc("kimtaesu").test()

            it("Complete 되어야 함 ")
            {
                testSub.assertComplete()
                testSub.assertNoErrors()
            }
        }
    }
})