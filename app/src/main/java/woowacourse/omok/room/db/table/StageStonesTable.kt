package woowacourse.omok.room.db.table

import woowacourse.omok.room.db.SQLColumn
import woowacourse.omok.room.db.SQLType
import woowacourse.omok.room.db.SQLiteTable

object StageStonesTable : SQLiteTable {
    const val STAGE_ID = "stageId"
    const val STONE_ID = "stoneId"

    override val name: String = "stageStones"
    override val scheme: List<SQLColumn> = listOf(
        SQLColumn(STAGE_ID, SQLType.INTEGER),
        SQLColumn(STONE_ID, SQLType.INTEGER),
    )
}
