package rpgbackbone.Ingredient

interface Template: rpgbackbone.RPGBBObject {
  val name: String
  val properties: List<rpgbackbone.Ench.Visitor>
}
