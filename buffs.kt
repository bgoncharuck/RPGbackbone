package rpgbackbone.Buffs

interface Effect: rpgbackbone.RPGBBObject {
  val code: Code
  val ench: rpgbackbone.Ench.Template
  val isAlways: Boolean
  val isCurse: Boolean
  val isDisease: Boolean
}

interface Template: rpgbackbone.RPGBBObject {
  val effects: MutableList<Effect>
  fun new(effect: Effect)
  fun cleanDisease()
  fun cleanCurse()
}

class Default(): Template {
  override val effects: MutableList<Effect> = mutableListOf()
  override fun new(effect: Effect) { effects.add(effect) }
  override fun cleanDisease() { effects.removeAll { it.isDisease == true } }
  override fun cleanCurse() { effects.removeAll { it.isCurse == true } }
}
