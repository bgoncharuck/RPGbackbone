package rpgbackbone.Ench

interface Template {
  val code: Code
  val change: rpgbackbone.Attribute.Constant
  fun execute()
}
