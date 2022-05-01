package pl.kavel.waluta.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.kavel.waluta.BukkitMain;
import pl.kavel.waluta.service.UserService;
import pl.kavel.waluta.user.User;
import pl.kavel.waluta.utilities.ChatUtilities;

public class PlayerJoinHandler implements Listener {

    private final UserService userService = BukkitMain.getInstance().getUserService();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(null);
        Player player = event.getPlayer();

        User user = this.userService.findUserByNickName(player.getName());

        if(user == null){
            user = this.userService.findUserOrCreate(player.getName());
            player.sendTitle(ChatUtilities.colored("&e&lClear&6&lMC&e&l.pl"), ChatUtilities.colored("&eWitamy pierwszy raz na serwerze!"));
            return;
        }
        player.sendMessage(ChatUtilities.colored( "&eWitaj, posiadasz &6&l" + user.getCoins() + " &r&eSkyCoins'ów"));

    }
}
