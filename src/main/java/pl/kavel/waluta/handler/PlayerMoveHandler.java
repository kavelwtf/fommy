package pl.kavel.waluta.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.kavel.waluta.BukkitMain;
import pl.kavel.waluta.service.UserService;
import pl.kavel.waluta.user.User;
import pl.kavel.waluta.utilities.ChatUtilities;

public class PlayerMoveHandler implements Listener {

    private final UserService userService = BukkitMain.getInstance().getUserService();


    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerMove(PlayerMoveEvent event){
        if(event.isCancelled())return;
        Player player = event.getPlayer();

        User user = this.userService.findUserByNickName(player.getName());
        if(user == null)return;

        user.addCoins(10);
        player.sendMessage(ChatUtilities.colored("Twój stan konta zwiększyl się o " + user.getCoins() + " monet"));
        event.setCancelled(true);

    }
}
