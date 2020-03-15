package rpgbackbone.Potion

interface CommandTemplate: rpgbackbone.RPGBBObject {
  val name: String
  val recipe: List<rpgbackbone.Ingredient.Template>
  var executable: Boolean
  fun execute()
}
