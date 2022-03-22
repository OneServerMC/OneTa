package org.oneserver.oneta

class OneTa : AbstractOneTa()
{
    companion object
    {
        lateinit var plugin: OneTa
    }

    override fun onEnable()
    {
        plugin = this
    }
}