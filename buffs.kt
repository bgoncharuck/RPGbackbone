package rpgbackbone.Buffs

interface Effect: rpgbackbone.RPGBBObject {
  val code: Code
  val ench: rpgbackbone.Ench.Template
  val isAlways: Boolean
  val isCurse: Boolean
  val isDisease: Boolean
  var time: Byte
}

interface Template: rpgbackbone.RPGBBObject {
  val effects: List<Effect>
  fun new(effect: Effect)
  fun cleanDisease()
  fun cleanCurse()
}
