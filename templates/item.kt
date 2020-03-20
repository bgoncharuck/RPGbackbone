package rpgbackbone.Item

interface Template: rpgbackbone.RPGBBObject {
  val code: Code
  val internal: rpgbackbone.RPGBBObject
}
