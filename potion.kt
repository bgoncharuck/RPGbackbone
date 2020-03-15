package rpgbackbone.Potion

interface CommandTemplate: rpgbackbone.RPGBBObject {
  val name: String
  val recipe: List<rpgbackbone.Ingredient.Template>
  var executable: Boolean
  fun execute()
}

abstract class AutonomicPoison(val _name: String, val _recipe: List<rpgbackbone.Ingredient.Template>, val _poisonEffect: Int): CommandTemplate {
  override val name: String= _name
  override val recipe: List<rpgbackbone.Ingredient.Template> = _recipe
  override var executable: Boolean= false

  val poisonEffect= _poisonEffect
  protected var healthBar: rpgbackbone.Attribute.Changeable?= null
  protected var resistance: Int= 0

  fun prepare(_toDamage: rpgbackbone.Attribute.Changeable, _resistance: rpgbackbone.Attribute.Changeable) {
    healthBar= _toDamage
    resistance= _resistance.value
    executable= true
  }

  override fun execute() {
    if (executable) {
      healthBar!!.value-= poisonEffect/resistance
    }
  }
}
