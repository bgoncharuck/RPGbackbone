package rpgbackbone.Potion

object LovelyMaidKiss: PotionByRecipe("Lovely Maid Kiss", true, listOf(rpgbackbone.Ingredient.TrueLoversKnot,rpgbackbone.Ingredient.BeeSting,rpgbackbone.Ingredient.Cowbane,rpgbackbone.Ingredient.BuzzingGrass)) {
  override val effects: List<rpgbackbone.Ench.Template> = listOf(rpgbackbone.Ench.PoisonDamage(361))
}
