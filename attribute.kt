package rpgbackbone.Attribute

interface Constant: rpgbackbone.RPGBBObject {
  val code: Code
  val value: Int
}

data class DefaultConstant(val _atrCode: Code, val _atrVal: Int) : Constant
{
  override val code: Code= _atrCode
  override val value: Int= _atrVal
}

interface Changeable: rpgbackbone.RPGBBObject {
  val code: Code
  var value: Int
}

data class DefaultChangeable(val _atrCode: Code, val _atrVal: Int) : Changeable {
  override val code: Code= _atrCode
  override var value: Int= _atrVal
}
