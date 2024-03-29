package fluttersim.gameobjects

import kotlin.random.Random

open class Pony(
    name: String,
    description: String,
    gender: Gender,
    aliases: List<String> = listOf(),
    tags: List<ObjectTag> = listOf(),
    seeMessage: String? = null,
    pickUpMessage: String? = null
) : GameObject(name, description, gender, aliases, (tags + listOf(ObjectTag.CanPickUp)).distinct(), seeMessage, pickUpMessage) {

    override fun getEatMessage(): String = "$name raises ${gender.possesive} eyebrows at you."

    override fun getArticledName() = name

    override fun getDropMessage(): String {
        return "You put $name back on the ground."
    }

    fun getFrownMessage(): String = when(Random.nextInt(7)) {
        0 -> "$name frowns at you."
        1 -> "$name raises ${gender.possesive} eyebrows at you."
        2 -> "$name tilts ${gender.possesive} head at you."
        3 -> "$name looks at you funny."
        4 -> "$name looks at you with questioning eyes."
        5 -> "$name seems to question you."
        6 -> "$name seems slightly uncomfortable with that."
        // This should never happen, but just in case.
        else -> "$name looks at you nervously."
    }

    fun getLikesSlightlyMessage(): String = when(Random.nextInt(3)) {
        0 -> "$name seems to be okay with that."
        1 -> "$name seems to like that."
        2 -> "$name smiles at you."
        // This should never happen, but just in case.
        else -> "$name smiles nervously."
    }

    fun getBlushMessage(): String = when(Random.nextInt(3)) {
        0 -> "$name blushes slightly."
        1 -> "$name turns a little red."
        2 -> "$name blushes."
        // This should never happen, but just in case.
        else -> "$name blushes nervously."
    }
}