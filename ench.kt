package rpgbackbone.Ench

interface Template {
  val code: Code
  val change: Int
  fun execute()
}

abstract class Damage(val type: Code, val healthShrink: Int): Template {
  protected var healthBar: rpgbackbone.Attribute.Changeable?= null
  protected var prepared: Boolean= false
  override fun execute() {
    if (prepared) healthBar!!.value-= healthShrink
  }
}

abstract class DamageWithResistanceCheck(val _type: Code, val _healthShrink: Int) : Damage(_type, _healthShrink) {
  protected var resistance: Int= 0

  fun prepare(_toDamage: rpgbackbone.Attribute.Changeable, _resistance: rpgbackbone.Attribute.Changeable) {
    healthBar= _toDamage
    resistance= _resistance.value
    prepared= true
  }
  override fun execute() {
    if (prepared) {
      healthBar!!.value-= if (healthShrink/resistance == 0) 1 else healthShrink/resistance
    }
  }
}
