package d2r

import external.nuttree.Point

const val gameWindowTitle = "Diablo II: Resurrected"
const val baseScreenW = 3840
const val baseScreenH = 2160

// all base on 3840*2160 res
const val exitGameX = 1920
const val exitGameY = 950

const val hostGameNameInputX = 2800
const val hostGameNameInputY = 336
const val joinGameNameInputX = 2556
const val joinGameNameInputY = 300
const val refreshBtnX = 3412
const val refreshBtnY = 412

enum class CommandMessageType {
    CREATE_GAME,
    UNKNOWN
}

