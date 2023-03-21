package omok.domain.gameState

import omok.domain.OmokBoard
import omok.domain.OmokPoint
import omok.domain.state.BlackStoneState

class BlackWin(
    override val omokBoard: OmokBoard,
) : GameState {
    override val stoneState = BlackStoneState
    override val isRunning: Boolean = false

    override fun play(point: OmokPoint): GameState {
        error(ERROR_GAME_OVER)
    }

    companion object {
        private const val ERROR_GAME_OVER = "승자가 나온 후엔 더이상 플레이 할 수 없습니다"
    }
}
