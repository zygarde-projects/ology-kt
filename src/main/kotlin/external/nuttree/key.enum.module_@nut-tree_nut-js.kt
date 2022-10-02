package external.nuttree

typealias KeyBtn = Int

object Key {
  const val Space: KeyBtn = 0
  const val Escape: KeyBtn = 1
  const val Tab: KeyBtn = 2
  const val LeftAlt: KeyBtn = 3
  const val LeftControl: KeyBtn = 4
  const val RightAlt: KeyBtn = 5
  const val RightControl: KeyBtn = 6
  const val LeftShift: KeyBtn = 7
  const val LeftSuper: KeyBtn = 8
  const val RightShift: KeyBtn = 9
  const val RightSuper: KeyBtn = 10
  const val F1: KeyBtn = 11
  const val F2: KeyBtn = 12
  const val F3: KeyBtn = 13
  const val F4: KeyBtn = 14
  const val F5: KeyBtn = 15
  const val F6: KeyBtn = 16
  const val F7: KeyBtn = 17
  const val F8: KeyBtn = 18
  const val F9: KeyBtn = 19
  const val F10: KeyBtn = 20
  const val F11: KeyBtn = 21
  const val F12: KeyBtn = 22
  const val F13: KeyBtn = 23
  const val F14: KeyBtn = 24
  const val F15: KeyBtn = 25
  const val F16: KeyBtn = 26
  const val F17: KeyBtn = 27
  const val F18: KeyBtn = 28
  const val F19: KeyBtn = 29
  const val F20: KeyBtn = 30
  const val F21: KeyBtn = 31
  const val F22: KeyBtn = 32
  const val F23: KeyBtn = 33
  const val F24: KeyBtn = 34
  const val Num0: KeyBtn = 35
  const val Num1: KeyBtn = 36
  const val Num2: KeyBtn = 37
  const val Num3: KeyBtn = 38
  const val Num4: KeyBtn = 39
  const val Num5: KeyBtn = 40
  const val Num6: KeyBtn = 41
  const val Num7: KeyBtn = 42
  const val Num8: KeyBtn = 43
  const val Num9: KeyBtn = 44
  const val A: KeyBtn = 45
  const val B: KeyBtn = 46
  const val C: KeyBtn = 47
  const val D: KeyBtn = 48
  const val E: KeyBtn = 49
  const val F: KeyBtn = 50
  const val G: KeyBtn = 51
  const val H: KeyBtn = 52
  const val I: KeyBtn = 53
  const val J: KeyBtn = 54
  const val K: KeyBtn = 55
  const val L: KeyBtn = 56
  const val M: KeyBtn = 57
  const val N: KeyBtn = 58
  const val O: KeyBtn = 59
  const val P: KeyBtn = 60
  const val Q: KeyBtn = 61
  const val R: KeyBtn = 62
  const val S: KeyBtn = 63
  const val T: KeyBtn = 64
  const val U: KeyBtn = 65
  const val V: KeyBtn = 66
  const val W: KeyBtn = 67
  const val X: KeyBtn = 68
  const val Y: KeyBtn = 69
  const val Z: KeyBtn = 70
  const val Grave: KeyBtn = 71
  const val Minus: KeyBtn = 72
  const val Equal: KeyBtn = 73
  const val Backspace: KeyBtn = 74
  const val LeftBracket: KeyBtn = 75
  const val RightBracket: KeyBtn = 76
  const val Backslash: KeyBtn = 77
  const val Semicolon: KeyBtn = 78
  const val Quote: KeyBtn = 79
  const val Return: KeyBtn = 80
  const val Comma: KeyBtn = 81
  const val Period: KeyBtn = 82
  const val Slash: KeyBtn = 83
  const val Left: KeyBtn = 84
  const val Up: KeyBtn = 85
  const val Right: KeyBtn = 86
  const val Down: KeyBtn = 87
  const val Print: KeyBtn = 88
  const val Pause: KeyBtn = 89
  const val Insert: KeyBtn = 90
  const val Delete: KeyBtn = 91
  const val Home: KeyBtn = 92
  const val End: KeyBtn = 93
  const val PageUp: KeyBtn = 94
  const val PageDown: KeyBtn = 95
  const val Add: KeyBtn = 96
  const val Subtract: KeyBtn = 97
  const val Multiply: KeyBtn = 98
  const val Divide: KeyBtn = 99
  const val Decimal: KeyBtn = 100
  const val Enter: KeyBtn = 101
  const val NumPad0: KeyBtn = 102
  const val NumPad1: KeyBtn = 103
  const val NumPad2: KeyBtn = 104
  const val NumPad3: KeyBtn = 105
  const val NumPad4: KeyBtn = 106
  const val NumPad5: KeyBtn = 107
  const val NumPad6: KeyBtn = 108
  const val NumPad7: KeyBtn = 109
  const val NumPad8: KeyBtn = 110
  const val NumPad9: KeyBtn = 111
  const val CapsLock: KeyBtn = 112
  const val ScrollLock: KeyBtn = 113
  const val NumLock: KeyBtn = 114
  const val AudioMute: KeyBtn = 115
  const val AudioVolDown: KeyBtn = 116
  const val AudioVolUp: KeyBtn = 117
  const val AudioPlay: KeyBtn = 118
  const val AudioStop: KeyBtn = 119
  const val AudioPause: KeyBtn = 120
  const val AudioPrev: KeyBtn = 121
  const val AudioNext: KeyBtn = 122
  const val AudioRewind: KeyBtn = 123
  const val AudioForward: KeyBtn = 124
  const val AudioRepeat: KeyBtn = 125
  const val AudioRandom: KeyBtn = 126
}

private val keyMap = mapOf(
  "Space" to Key.Space,
  "Escape" to Key.Escape,
  "Tab" to Key.Tab,
  "LeftAlt" to Key.LeftAlt,
  "LeftControl" to Key.LeftControl,
  "RightAlt" to Key.RightAlt,
  "RightControl" to Key.RightControl,
  "LeftShift" to Key.LeftShift,
  "LeftSuper" to Key.LeftSuper,
  "RightShift" to Key.RightShift,
  "RightSuper" to Key.RightSuper,
  "F1" to Key.F1,
  "F2" to Key.F2,
  "F3" to Key.F3,
  "F4" to Key.F4,
  "F5" to Key.F5,
  "F6" to Key.F6,
  "F7" to Key.F7,
  "F8" to Key.F8,
  "F9" to Key.F9,
  "F10" to Key.F10,
  "F11" to Key.F11,
  "F12" to Key.F12,
  "F13" to Key.F13,
  "F14" to Key.F14,
  "F15" to Key.F15,
  "F16" to Key.F16,
  "F17" to Key.F17,
  "F18" to Key.F18,
  "F19" to Key.F19,
  "F20" to Key.F20,
  "F21" to Key.F21,
  "F22" to Key.F22,
  "F23" to Key.F23,
  "F24" to Key.F24,
  "Num0" to Key.Num0,
  "Num1" to Key.Num1,
  "Num2" to Key.Num2,
  "Num3" to Key.Num3,
  "Num4" to Key.Num4,
  "Num5" to Key.Num5,
  "Num6" to Key.Num6,
  "Num7" to Key.Num7,
  "Num8" to Key.Num8,
  "Num9" to Key.Num9,
  "A" to Key.A,
  "B" to Key.B,
  "C" to Key.C,
  "D" to Key.D,
  "E" to Key.E,
  "F" to Key.F,
  "G" to Key.G,
  "H" to Key.H,
  "I" to Key.I,
  "J" to Key.J,
  "K" to Key.K,
  "L" to Key.L,
  "M" to Key.M,
  "N" to Key.N,
  "O" to Key.O,
  "P" to Key.P,
  "Q" to Key.Q,
  "R" to Key.R,
  "S" to Key.S,
  "T" to Key.T,
  "U" to Key.U,
  "V" to Key.V,
  "W" to Key.W,
  "X" to Key.X,
  "Y" to Key.Y,
  "Z" to Key.Z,
  "Grave" to Key.Grave,
  "Minus" to Key.Minus,
  "Equal" to Key.Equal,
  "Backspace" to Key.Backspace,
  "LeftBracket" to Key.LeftBracket,
  "RightBracket" to Key.RightBracket,
  "Backslash" to Key.Backslash,
  "Semicolon" to Key.Semicolon,
  "Quote" to Key.Quote,
  "Return" to Key.Return,
  "Comma" to Key.Comma,
  "Period" to Key.Period,
  "Slash" to Key.Slash,
  "Left" to Key.Left,
  "Up" to Key.Up,
  "Right" to Key.Right,
  "Down" to Key.Down,
  "Print" to Key.Print,
  "Pause" to Key.Pause,
  "Insert" to Key.Insert,
  "Delete" to Key.Delete,
  "Home" to Key.Home,
  "End" to Key.End,
  "PageUp" to Key.PageUp,
  "PageDown" to Key.PageDown,
  "Add" to Key.Add,
  "Subtract" to Key.Subtract,
  "Multiply" to Key.Multiply,
  "Divide" to Key.Divide,
  "Decimal" to Key.Decimal,
  "Enter" to Key.Enter,
  "NumPad0" to Key.NumPad0,
  "NumPad1" to Key.NumPad1,
  "NumPad2" to Key.NumPad2,
  "NumPad3" to Key.NumPad3,
  "NumPad4" to Key.NumPad4,
  "NumPad5" to Key.NumPad5,
  "NumPad6" to Key.NumPad6,
  "NumPad7" to Key.NumPad7,
  "NumPad8" to Key.NumPad8,
  "NumPad9" to Key.NumPad9,
  "CapsLock" to Key.CapsLock,
  "ScrollLock" to Key.ScrollLock,
  "NumLock" to Key.NumLock,
  "AudioMute" to Key.AudioMute,
  "AudioVolDown" to Key.AudioVolDown,
  "AudioVolUp" to Key.AudioVolUp,
  "AudioPlay" to Key.AudioPlay,
  "AudioStop" to Key.AudioStop,
  "AudioPause" to Key.AudioPause,
  "AudioPrev" to Key.AudioPrev,
  "AudioNext" to Key.AudioNext,
  "AudioRewind" to Key.AudioRewind,
  "AudioForward" to Key.AudioForward,
  "AudioRepeat" to Key.AudioRepeat,
  "AudioRandom" to Key.AudioRandom,
)

fun getKey(str: String): KeyBtn {
  return keyMap[str] ?: throw IllegalArgumentException("key not found for $str")
}
