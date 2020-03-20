package rpgbackbone.Potion

interface Template: rpgbackbone.RPGBBObject {
  val name: String
  val isPoison: Boolean
  val effects: List<rpgbackbone.Ench.Template>
}

class Default(val _name: String, val _isPoison: Boolean, _effects: List<rpgbackbone.Ench.Template>): Template {
  override val name: String= _name
  override val isPoison: Boolean= _isPoison
  override val effects: List<rpgbackbone.Ench.Template> = _effects
}

interface PlayersMadeFactoryEffectsCalculationStrategy: rpgbackbone.RPGBBObject {
  fun calculate(ingridient: List<rpgbackbone.Ingredient.Template>): List<rpgbackbone.Ench.Template>
}

interface PlayersMadeFactory: rpgbackbone.RPGBBObject {
  var name: String
  val recipe: MutableList<rpgbackbone.Ingredient.Template>
  var isPoison: Boolean
  var strategy: PlayersMadeFactoryEffectsCalculationStrategy
  fun create(): Template {
    return Default(name, isPoison, strategy.calculate(recipe))
  }
}

abstract class PotionByRecipe (val _name: String, val _isPoison: Boolean, val _recipe: List<rpgbackbone.Ingredient.Template>): Template {
  override val name: String= _name
  override val isPoison: Boolean= _isPoison
  val recipe: List<rpgbackbone.Ingredient.Template> = _recipe
  override abstract val effects: List<rpgbackbone.Ench.Template>
}
