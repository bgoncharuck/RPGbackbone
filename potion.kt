package rpgbackbone.Potion

interface CommandTemplate: rpgbackbone.RPGBBObject {
  val name: String
  val isPoison: Boolean
  var executable: Boolean
  fun execute()
}

class Default(val _name: String, val _isPoison: Boolean, _effects: List<rpgbackbone.Ench.CommandTemplate>): CommandTemplate {
  override val name: String= _name
  override val isPoison: Boolean= _isPoison
  override var executable: Boolean= false
  val effects= _effects
  fun prepare() {
    executable= effects.all {e -> e.executable == true}
  }
  override fun execute() {
    if (executable) {
      effects.forEach {e -> e.execute()}
    }
  }
}

interface PlayersMadeFactoryEffectsCalculationStrategy: rpgbackbone.RPGBBObject {
  fun calculate(ingridient: List<rpgbackbone.Ingredient.Template>): List<rpgbackbone.Ench.CommandTemplate>
}

interface PlayersMadeFactory: rpgbackbone.RPGBBObject {
  var name: String
  val recipe: List<rpgbackbone.Ingredient.Template>
  var isPoison: Boolean
  var strategy: PlayersMadeFactoryEffectsCalculationStrategy
  fun create(): CommandTemplate {
    return Default(name, isPoison, strategy.calculate(recipe))
  }
}

abstract class AutonomicPoison(val _name: String, val _recipe: List<rpgbackbone.Ingredient.Template>, val _poisonEffect: Int): CommandTemplate {
  override val name: String= _name
  override val isPoison: Boolean= true
  override var executable: Boolean= false

  val recipe: List<rpgbackbone.Ingredient.Template> = _recipe
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
