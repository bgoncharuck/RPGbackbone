class Attribute {
  enum class Code() {
    NONE
  }

  interface Constant {
    val code: Code
    val value: Int
  }

  data class DefaultConstant(val _atrCode: Code, val _atrVal: Int) : Constant {

    override val code: Code= _atrCode
    override val value: Int= _atrVal
  }

  interface Changeable {
    val code: Code
    var value: Int
  }

  data class DefaultChangeable(val _atrCode: Code, val _atrVal: Int) : Changeable {

    override val code: Code= _atrCode
    override var value: Int= _atrVal
  }
}

class Enchantment {

  interface Single {
    val name: String
    val chant: Attribute.Constant
  }

  data class DefaultSingle (val _enchName: String, val _enchChant: Attribute.Constant): Single {

    override val name: String= _enchName
    override val chant: Attribute.Constant= _enchChant
  }

  interface Multiple {
    val name: String
    val chant: List<Attribute.Constant>
  }

  data class DefaultMultiple (val _enchName: String, val _enchChant: List<Attribute.Constant>): Multiple {

    override val name: String= _enchName
    override val chant: List<Attribute.Constant> = _enchChant
  }
}

class Alchemy {

}

class Item {

}

fun main() {

}
