package rpgbackbone.Ingredient

class BeeSting: Template {
  val name: String= "Bee Sting"
  val properties: listOf(rpgbackbone.Ench.PoisonDamage(29))
  val isStrong: Boolean= true
  val isWide: Boolean= false
}

class BuzzingGrass: Template {
  val name: String= "Buzzing Grass"
  val properties: listOf(rpgbackbone.Ench.PoisonDamage(2))
  val isStrong: Boolean= false
  val isWide: Boolean= false
}

class TrueLoversKnot: Template {
  val name: String= "True Lover's Knot"
  val properties: listOf(rpgbackbone.Ench.PoisonDamage(33))
  val isStrong: Boolean= true
  val isWide: Boolean= false
}

class Cowbane: Template {
  val name: String= "Cowbane"
  val properties: listOf(rpgbackbone.Ench.PoisonDamage(45))
  val isStrong: Boolean= true
  val isWide: Boolean= false
}
