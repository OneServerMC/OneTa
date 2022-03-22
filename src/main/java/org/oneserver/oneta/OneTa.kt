package org.oneserver.oneta

import org.oneserver.oneta.listeners.PlayerConnection
import org.oneserver.oneta.listeners.ServerKick

class OneTa : AbstractOneTa()
{
    companion object
    {
        lateinit var plugin: OneTa
    }

    override fun onEnable()
    {
        plugin = this

        registerListeners(
            PlayerConnection(),
            ServerKick()
        )
    }
}