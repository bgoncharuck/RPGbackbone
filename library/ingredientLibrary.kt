package rpgbackbone.Ingredient

class BeeSting(): Template {
  override val name: String= "Bee Sting"
  override val properties: List<rpgbackbone.Ench.CommandTemplate> = listOf(rpgbackbone.Ench.PoisonDamage(29))
  override val isStrong: Boolean= true
  override val isWide: Boolean= false
}

class BuzzingGrass(): Template {
  override val name: String= "Buzzing Grass"
  override val properties: List<rpgbackbone.Ench.CommandTemplate> = listOf(rpgbackbone.Ench.PoisonDamage(2))
  override val isStrong: Boolean= false
  override val isWide: Boolean= false
}

class TrueLoversKnot(): Template {
  override val name: String= "True Lover's Knot"
  override val properties: List<rpgbackbone.Ench.CommandTemplate> = listOf(rpgbackbone.Ench.PoisonDamage(33))
  override val isStrong: Boolean= true
  override val isWide: Boolean= false
}

class Cowbane(): Template {
  override val name: String= "Cowbane"
  override val properties: List<rpgbackbone.Ench.CommandTemplate> = listOf(rpgbackbone.Ench.PoisonDamage(45))
  override val isStrong: Boolean= true
  override val isWide: Boolean= false
}
