package fluttersim.actions

import fluttersim.Game

class ExamineAction : GameAction(listOf("examine")) {
    override fun doAction(command: String, paramString: String): String {
        if (paramString.isEmpty()) {
            return "Examine what?"
        }

        val target = Game.getItemFromWorldOrInventory(paramString)

        if (target == null) {
            return "You don't see any ${paramString}."
        }

        return target.getDescription()
    }
}