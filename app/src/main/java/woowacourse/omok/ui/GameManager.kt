package woowacourse.omok.ui

import android.content.Context
import woowacourse.omok.data.repository.Repository
import woowacourse.omok.data.repository.RepositoryImpl
import woowacourse.omok.model.Board
import woowacourse.omok.model.Coordinate
import woowacourse.omok.model.state.GameState

class GameManager(
    private val gamePlayHandler: GamePlayHandler,
    context: Context,
    private val repository: Repository =
        RepositoryImpl(
            context,
        ),
) {
    private var gameState: GameState = GameState.Playing.Start(Board())

    fun playTurn(coordinate: Coordinate) {
        gameState = gameState.placeStone(coordinate)
        gamePlayHandler.onUpdate(gameState)
        saveCoordinate(coordinate)
    }

    fun loadGame() =
        runCatching {
            gameState = GameState.Playing.Start(Board())
            repository.findAll().forEach {
                gameState = gameState.placeStone(it)
            }
            gamePlayHandler.onUpdate(gameState)
        }.onFailure {
            gamePlayHandler.onError(it)
        }

    fun replay() {
        gameState = GameState.Playing.Start(Board())
        gamePlayHandler.onUpdate(gameState)
    }

    private fun saveCoordinate(coordinate: Coordinate) =
        runCatching {
            repository.save(coordinate)
        }.onFailure {
            gamePlayHandler.onError(it)
        }
}
