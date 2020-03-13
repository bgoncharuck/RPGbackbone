package rpgbackbone

interface Visitor {
  fun visit(RPGBBObject rpgbbobject)
}

interface RPGBBObject {
  fun accept(Visitor visitor)
  fun ancsestorAction()
}

abstract class Decorator implements RPGBBObject {
  protected RPGBBObject component

  override accept(Visitor visitor) {
    visitor.visit(this)
  }

  public Decorator(RPGBBObject comp) {
    component= comp
  }

  override fun ancsestorAction() {
    component.ancsestorAction()
  }

  fun action()
}
