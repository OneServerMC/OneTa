package org.oneserver.oneta.listeners

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.event.ServerKickEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler
import org.oneserver.oneta.OneTa

class ServerKick : Listener
{
    @EventHandler
    fun onServerKick(e: ServerKickEvent)
    {
        if (e.kickedFrom.name == "lobby") return

        val player: ProxiedPlayer = e.player

        player.sendMessage(TextComponent("${ChatColor.RED}理由: ${ChatColor.WHITE}${e.kickReasonComponent[0].toLegacyText()}"))
        e.cancelServer = OneTa.plugin.proxy.getServerInfo("lobby") ?: return
        e.isCancelled = true
    }
}