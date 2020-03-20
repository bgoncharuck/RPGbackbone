package rpgbackbone.Attribute

interface Template: rpgbackbone.RPGBBObject{
  val code: Code
}

interface Constant: Template {
  val value: Int
}
interface Changeable: Template {
  var value: Int
}

data class DefaultConstant(val _atrCode: Code, val _atrVal: Int) : Constant
{
  override val code: Code= _atrCode
  override val value: Int= _atrVal
}
data class DefaultChangeable(val _atrCode: Code, val _atrVal: Int) : Changeable {
  override val code: Code= _atrCode
  override var value: Int= _atrVal
}
