package info.tta.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `players with distinct points have correct standings`() {
        val playerOne = Player("playerOne")
        val playerTwo = Player("playerTwo")
        val playerThree = Player("playerThree")
        val game = Game("game-1", setOf(playerOne, playerTwo, playerThree));

        game.addPlayerPoints(playerOne, 10)
        game.addPlayerPoints(playerTwo, 50)
        game.addPlayerPoints(playerThree, 5)

        val standings = game.getStandings()

        Assertions.assertThat(standings)
                .containsExactly(listOf(playerTwo), listOf(playerOne), listOf(playerThree))
    }

    @Test
    fun `players with same points have correct standings`() {
        val playerOne = Player("playerOne")
        val playerTwo = Player("playerTwo")
        val playerThree = Player("playerThree")
        val game = Game("game-1", setOf(playerOne, playerTwo, playerThree));

        game.addPlayerPoints(playerOne, 10)
        game.addPlayerPoints(playerTwo, 10)
        game.addPlayerPoints(playerThree, 10)

        val standings = game.getStandings()

        Assertions.assertThat(standings)
                .containsExactly(listOf(playerOne, playerTwo, playerThree))

    }

    @Test
    fun `players with mixed points have correct standings`() {
        val playerOne = Player("playerOne")
        val playerTwo = Player("playerTwo")
        val playerThree = Player("playerThree")
        val game = Game("game-1", setOf(playerOne, playerTwo, playerThree));

        game.addPlayerPoints(playerOne, 10)
        game.addPlayerPoints(playerTwo, 10)
        game.addPlayerPoints(playerThree, 50)

        val standings = game.getStandings()

        Assertions.assertThat(standings)
                .containsExactly(listOf(playerThree), listOf(playerOne, playerTwo))

    }

}