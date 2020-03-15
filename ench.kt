package rpgbackbone.Ench

interface CommandTemplate: rpgbackbone.RPGBBObject {
  val code: Code
  val change: Int
  var executable: Boolean
  fun execute()
}

abstract class Damage(val _type: Code, val healthShrink: Int): CommandTemplate {
  override val code: Code= _type
  override val change: Int= healthShrink
  override var executable: Boolean= false

  protected var healthBar: rpgbackbone.Attribute.Changeable?= null
  override fun execute() {
    if (executable) healthBar!!.value-= change
  }
}

abstract class DamageWithResistanceCheck(val damageType: Code, val _healthShrink: Int) : Damage(damageType, _healthShrink) {

  protected var resistance: Int= 0
  fun prepare(_toDamage: rpgbackbone.Attribute.Changeable, _resistance: rpgbackbone.Attribute.Changeable) {
    healthBar= _toDamage
    resistance= _resistance.value
    executable= true
  }
  override fun execute() {
    if (executable) {
      healthBar!!.value-= change/resistance
    }
  }
}
