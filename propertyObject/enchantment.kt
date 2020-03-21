package rpgbackbone.Enchantment

object NoEnchantment: Template {
  override val code: Code= Code.NONE
  override val target: rpgbackbone.Target = rpgbackbone.Target.NONE
  override val use: rpgbackbone.Use = rpgbackbone.Use.NONE
  override val effects: List<rpgbackbone.Ench.Visitor> = listOf()
}

object PurpleSkyFlame: WeaponHit(Code.PurpleSkyFlame, listOf(rpgbackbone.Ench.FireDamage(48))) {}
