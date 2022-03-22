package org.oneserver.oneta.listeners

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.event.PlayerDisconnectEvent
import net.md_5.bungee.api.event.PostLoginEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler
import org.oneserver.oneta.OneTa

class PlayerConnection : Listener
{
    @EventHandler
    fun onPostLogin(e: PostLoginEvent)
    {
        OneTa.plugin.proxy.broadcast(TextComponent(
            "${ChatColor.DARK_GRAY}[${ChatColor.AQUA}+${ChatColor.DARK_GRAY}] ${ChatColor.WHITE}${e.player.name}"
        ))
    }

    @EventHandler
    fun onPostLogout(e: PlayerDisconnectEvent)
    {
        OneTa.plugin.proxy.broadcast(TextComponent(
            "${ChatColor.DARK_GRAY}[${ChatColor.YELLOW}-${ChatColor.DARK_GRAY}] ${ChatColor.WHITE}${e.player.name}"
        ))
    }
}