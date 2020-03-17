package rpgbackbone.Entity

interface Essential: rpgbackbone.RPGBBObject {
  val health: rpgbackbone.Attribute.Constant
}

interface NonEssential: rpgbackbone.RPGBBObject {
  val health: rpgbackbone.Attribute.Changeable
  object dev {
    var overralDamageResistanceControl: Float= 0.0f
    fun controlOverallDamage(value: Float) {overralDamageResistanceControl= value}
  }
  fun makeEssential() {dev.controlOverallDamage(0.0f)}
  fun unmakeEssential() {dev.controlOverallDamage(1.0f)}
  fun __overralDamageResist(): Float {return dev.overralDamageResistanceControl}
  fun isEssential(): Boolean {if (dev.overralDamageResistanceControl == 1.0f) return true else return false}
}
