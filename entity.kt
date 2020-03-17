ppackage rpgbackbone.Entity

interface Template: rpgbackbone.RPGBBObject {
  val health: rpgbackbone.RPGBBObject
  fun makeEssential()
  fun unmakeEssential()
  fun isEssential(): Boolean
  fun __overralDamageResist(): Float
}

// needs no memory
interface Essential: Template {
  override val health: rpgbackbone.Attribute.Constant
  override fun __overralDamageResist(): Float {return 0.0f}
  override fun makeEssential() {}
  override fun unmakeEssential() {}
  override fun isEssential(): Boolean {return true}
}

interface NonEssential: Template {
  override fun accept(visitor: rpgbackbone.Visitor) {
    visitor.visit(this)
  }
  override val health: rpgbackbone.Attribute.Changeable
  object dev {
    var overralDamageResistanceControl: Float= 1.0f
    fun controlOverallDamage(value: Float) {overralDamageResistanceControl= value}
  }
  override fun makeEssential() {dev.controlOverallDamage(0.0f)}
  override fun unmakeEssential() {dev.controlOverallDamage(1.0f)}
  override fun __overralDamageResist(): Float {return dev.overralDamageResistanceControl}
  override fun isEssential(): Boolean {if (dev.overralDamageResistanceControl == 1.0f) return true else return false}
}
