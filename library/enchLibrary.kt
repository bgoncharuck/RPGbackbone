package rpgbackbone.Ench

class PoisonDamage(val amount: Int): Default(Code.Poison, amount) {}
class Healing(val amount: Int): Default(Code.Heal, amount) {}
