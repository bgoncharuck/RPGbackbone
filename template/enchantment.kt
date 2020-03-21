package rpgbackbone.Enchantment

interface Template: rpgbackbone.RPGBBObject {
  val code: Code
  val target: rpgbackbone.Target
  val use: rpgbackbone.Use
  val effects: List<rpgbackbone.Ench.Visitor>
}

abstract class Artifact(val _code: Code, val _effects: List<rpgbackbone.Ench.Visitor>): Template {
  override val code: Code= _code
  override val target: rpgbackbone.Target = rpgbackbone.Target.SELF
  override val use: rpgbackbone.Use = rpgbackbone.Use.ALWAYS
  override val effects: List<rpgbackbone.Ench.Visitor> = _effects
}

abstract class Charm(val _code: Code, val _effects: List<rpgbackbone.Ench.Visitor>): Template {
  override val code: Code= _code
  override val target: rpgbackbone.Target = rpgbackbone.Target.SELF
  override val use: rpgbackbone.Use = rpgbackbone.Use.DEMAND
  override val effects: List<rpgbackbone.Ench.Visitor> = _effects
}

abstract class Guardian(val _code: Code, val _effects: List<rpgbackbone.Ench.Visitor>): Template {
  override val code: Code= _code
  override val target: rpgbackbone.Target = rpgbackbone.Target.SELECTED
  override val use: rpgbackbone.Use = rpgbackbone.Use.DEMAND
  override val effects: List<rpgbackbone.Ench.Visitor> = _effects
}

abstract class MagicHit(val _code: Code, val _effects: List<rpgbackbone.Ench.Visitor>): Template {
  override val code: Code= _code
  override val target: rpgbackbone.Target = rpgbackbone.Target.SELECTED
  override val use: rpgbackbone.Use = rpgbackbone.Use.HIT
  override val effects: List<rpgbackbone.Ench.Visitor> = _effects
}

abstract class WeaponHit(val _code: Code, val _effects: List<rpgbackbone.Ench.Visitor>): Template {
  override val code: Code= _code
  override val target: rpgbackbone.Target = rpgbackbone.Target.HIT
  override val use: rpgbackbone.Use = rpgbackbone.Use.HIT
  override val effects: List<rpgbackbone.Ench.Visitor> = _effects
}
