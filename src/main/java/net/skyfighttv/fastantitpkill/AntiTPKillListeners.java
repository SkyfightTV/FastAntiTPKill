package net.skyfighttv.fastantitpkill;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public final class AntiTPKillListeners implements Listener {
    @EventHandler
    private void onTp(PlayerTeleportEvent event) {
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.COMMAND
                || event.getCause() == PlayerTeleportEvent.TeleportCause.PLUGIN)
            AntiTPKill.tpTime.put(event.getPlayer(), System.currentTimeMillis()/1000);
    }

    @EventHandler
    private void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player)
            AntiTPKill.tpTime.remove((Player) event.getDamager());
        if (event.getEntity() instanceof Player
                && AntiTPKill.tpTime.containsKey((Player) event.getEntity())) {
            event.setCancelled(true);
        }
    }
}
