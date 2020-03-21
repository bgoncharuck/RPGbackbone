package rpgbackbone.Ingredient

object BeeSting: Template {
  override val name: String= "Bee Sting"
  override val properties: List<rpgbackbone.Ench.Template> = listOf(rpgbackbone.Ench.PoisonDamage(29), rpgbackbone.Ench.Healing(3))
  override val isStrong: Boolean= true
  override val isWide: Boolean= false
}

object BuzzingGrass: Template {
  override val name: String= "Buzzing Grass"
  override val properties: List<rpgbackbone.Ench.Template> = listOf(rpgbackbone.Ench.PoisonDamage(2))
  override val isStrong: Boolean= false
  override val isWide: Boolean= false
}

object TrueLoversKnot: Template {
  override val name: String= "True Lover's Knot"
  override val properties: List<rpgbackbone.Ench.Template> = listOf(rpgbackbone.Ench.PoisonDamage(33), rpgbackbone.Ench.Healing(7))
  override val isStrong: Boolean= true
  override val isWide: Boolean= false
}

object Cowbane: Template {
  override val name: String= "Cowbane"
  override val properties: List<rpgbackbone.Ench.Template> = listOf(rpgbackbone.Ench.PoisonDamage(45))
  override val isStrong: Boolean= true
  override val isWide: Boolean= false
}
