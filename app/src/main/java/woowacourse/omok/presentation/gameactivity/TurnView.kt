package woowacourse.omok.presentation.gameactivity

import android.widget.TextView
import domain.domain.OmokGame
import kotlin.properties.Delegates

class TurnView(private val value: TextView, omokGame: OmokGame) {

    var turn by Delegates.observable(omokGame.turn) { _, _, new ->
        value.text = new.name
    }

    init {
        value.text = turn.name
    }
}
