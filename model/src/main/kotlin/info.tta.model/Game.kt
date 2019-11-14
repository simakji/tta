package info.tta.model

class Game(private val name: String, private val players: Set<Player>) {

    private val playerPoints = mutableMapOf<Int, MutableList<Player>>()

    fun addPlayerPoints(player: Player, points: Int) {
        check(players.contains(player)) { "Game '$name' does not contain player '${player.name}'" }
        check(points >= 0) { "Player '${player.name}' cannot have negative points '$points'" }

        val players = playerPoints[points]
        if (players == null) {
            playerPoints[points] = mutableListOf(player)
        } else {
            players.add(player)
        }
    }

    fun getStandings(): List<List<Player>> {
        val sortedPlayerPoints = playerPoints.entries.sortedByDescending { it.key }
        val result = mutableListOf<List<Player>>()
        for (playerPoint in sortedPlayerPoints) {
            result.add(playerPoint.value)
        }
        return result
    }

    override fun toString(): String {
        return "Game(name='$name', players=$players, playerPoints=$playerPoints)"
    }

}