class Attribute {

  enum class Code {
    NONE
  }

  interface Constant {
    val code: Code
    val value: Int
  }

  data class DefaultConstant(val _atrCode: Code, val _atrVal: Int) : Constant {

    override val code: Code= _atrCode
    override val value: Int= _atrVal
  }

  interface Changeable {
    val code: Code
    var value: Int
  }

  data class DefaultChangeable(val _atrCode: Code, val _atrVal: Int) : Changeable {

    override val code: Code= _atrCode
    override var value: Int= _atrVal
  }
}

class Enchantment {

  interface Single {
    val name: String
    val chant: Attribute.Constant
  }

  data class DefaultSingle (val _enchName: String, val _enchChant: Attribute.Constant): Single {

    override val name: String= _enchName
    override val chant: Attribute.Constant= _enchChant
  }

  interface Multiple {
    val name: String
    val chant: List<Attribute.Constant>
  }

  data class DefaultMultiple (val _enchName: String, val _enchChant: List<Attribute.Constant>): Multiple {

    override val name: String= _enchName
    override val chant: List<Attribute.Constant> = _enchChant
  }
}

class Alchemy {

  enum class Code {
    NONE
  }

  interface Ingredient {
    val code: Code
    val effects: Array<Attribute.Constant>
  }

  data class DefaultIngredient(val _ingrCode: Code, val _ingrEffects: Array<Attribute.Constant>): Ingredient {
    override val code: Code= _ingrCode
    override val effects: Array<Attribute.Constant> = _ingrEffects
  }

  enum class PotionQuality {
    NONE
  }

  interface Potion {
    val code: Code
    val recipe: List<Ingredient>
    val quality: PotionQuality
  }

  data class DefaultPotion(val _potionCode: Code, val _potionRecipe: List<Ingredient>, val _potionQuality: PotionQuality): Potion {
    override val code: Code= _potionCode
    override val recipe: List<Ingredient> = _potionRecipe
    override val quality: PotionQuality= _potionQuality
  }

  enum class FoodSatiety {
    NONE
  }

  interface Food {
    val code: Code
    val satiety: FoodSatiety
  }

  data class DefaultFood(val _fdCode: Code, val _fdSatiety: FoodSatiety): Food {
    override val code: Code= _fdCode
    override val satiety: FoodSatiety= _fdSatiety
  }

  interface RareFood {
    val code: Code
    val food: Food
    val sideEffect: Potion
  }

  data class DefaultRareFood(val _fdCode: Code, val _fdCommon: Food, val _fdSideEffect: Potion): RareFood {
    override val code: Code= _fdCode
    override val food: Food= _fdCommon
    override val sideEffect: Potion= _fdSideEffect
  }

  enum class DrinkThirst {
    NONE
  }

  enum class DrinkAlcohol {
    NONE
  }

  interface Drink {
    val code: Code
    val thirst: DrinkThirst
    val alcohol: DrinkAlcohol
  }

  data class DefaultDrink(val _drnkCode: Code, val _drnkThirst: DrinkThirst, val _drnkAlcohol: DrinkAlcohol): Drink {
    override val code: Code= _drnkCode
    override val thirst: DrinkThirst= _drnkThirst
    override val alcohol: DrinkAlcohol= _drnkAlcohol
  }

  interface RareDrink {
    val code: Code
    val drink: Drink
    val sideEffect: Potion
  }

  data class DefaultRareDrink(val _drnkCode: Code, val _drnkCommon: Drink, val _drnkSideEffect: Potion): RareDrink {
    override val code: Code= _drnkCode
    override val drink: Drink= _drnkCommon
    override val sideEffect: Potion= _drnkSideEffect
  }

}

class Equipable {

  enum class Placeholder {
    NONE,
    RING,
    ROBE,
    HELM
  }

  interface Item {
    val placeholder: Placeholder
  }
}

class Jewelry {

  enum class Code {
    NONE
  }

  interface Ring: Equipable.Item {
    val code: Code
  }

  class DefaultRing(val _ringCode: Code): Ring {
    override val placeholder: Equipable.Placeholder= Equipable.Placeholder.RING
    override val code: Code= _ringCode
  }

}

class Clothing {

  enum class Code {
    NONE
  }

  interface Robe: Equipable.Item {
    val code: Code
  }

  class DefaultRobe(val _robeCode: Code): Robe {
    override val placeholder: Equipable.Placeholder= Equipable.Placeholder.ROBE
    override val code: Code= _robeCode
  }

}

class Armor {

  enum class Code {
    NONE
  }

  interface Helm: Equipable.Item {
    val code: Code
  }

  class DefaultHelm(val _helmCode: Code): Helm {
    override val placeholder: Equipable.Placeholder= Equipable.Placeholder.HELM
    override val code: Code= _helmCode
  }

}

fun main() {
  val test: Alchemy.RareDrink= Alchemy.DefaultRareDrink(
    Alchemy.Code.NONE, Alchemy.DefaultDrink(
      Alchemy.Code.NONE, Alchemy.DrinkThirst.NONE, Alchemy.DrinkAlcohol.NONE), Alchemy.DefaultPotion(
        Alchemy.Code.NONE, listOf(
          Alchemy.DefaultIngredient(
            Alchemy.Code.NONE, arrayOf(
              Attribute.DefaultConstant(Attribute.Code.NONE, 42),
              Attribute.DefaultConstant(Attribute.Code.NONE, 42),
              Attribute.DefaultConstant(Attribute.Code.NONE, 42),
              Attribute.DefaultConstant(Attribute.Code.NONE, 42)
            )
          ), Alchemy.DefaultIngredient(
            Alchemy.Code.NONE, arrayOf(
              Attribute.DefaultConstant(Attribute.Code.NONE, 42),
              Attribute.DefaultConstant(Attribute.Code.NONE, 42),
              Attribute.DefaultConstant(Attribute.Code.NONE, 42),
              Attribute.DefaultConstant(Attribute.Code.NONE, 42)
            )
          )
        ),
      Alchemy.PotionQuality.NONE)
    )

    println(test.sideEffect.recipe.get(0).effects[1].value)
}
