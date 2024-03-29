package fluttersim.actions

import fluttersim.Game

class TakeAction : GameAction(listOf("take", "pickup")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "Take what?"
        }

        val target = Game.currentPlace.gameObjects.firstOrNull { it.name.lowercase() == paramString }

        if (target == null) {
            return "You don't see any ${paramString}."
        }
        if (target.canPickUp()) {
            target.isInOriginalPlace = false
            Game.inventory.addItem(target)
            Game.currentPlace.remove(target)
            return target.getPickUpMessage()
        } else {
            return target.getPickUpMessage()
        }
    }
}