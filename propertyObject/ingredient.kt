package rpgbackbone.Ingredient

object BeeSting: Template {
  override val name: String= "Bee Sting"
  override val properties: List<rpgbackbone.Ench.Visitor> = listOf(rpgbackbone.Ench.PoisonDamage(29), rpgbackbone.Ench.Healing(3))
}

object BuzzingGrass: Template {
  override val name: String= "Buzzing Grass"
  override val properties: List<rpgbackbone.Ench.Visitor> = listOf(rpgbackbone.Ench.PoisonDamage(2))
}

object TrueLoversKnot: Template {
  override val name: String= "True Lover's Knot"
  override val properties: List<rpgbackbone.Ench.Visitor> = listOf(rpgbackbone.Ench.PoisonDamage(33), rpgbackbone.Ench.Healing(7))
}

object Cowbane: Template {
  override val name: String= "Cowbane"
  override val properties: List<rpgbackbone.Ench.Visitor> = listOf(rpgbackbone.Ench.PoisonDamage(45))
}
