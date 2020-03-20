package rpgbackbone.Enchantment

class NoEnchantment(): Template {
  override val code: Code= Code.NONE
  override val target: rpgbackbone.Target = rpgbackbone.Target.NONE
  override val use: rpgbackbone.Use = rpgbackbone.Use.NONE
  override val effects: List<rpgbackbone.Ench.Template> = listOf()
}

class PurpleSkyFlame(): WeaponHit(Code.PurpleSkyFlame, listOf(rpgbackbone.Ench.FireDamage(48))) {}
