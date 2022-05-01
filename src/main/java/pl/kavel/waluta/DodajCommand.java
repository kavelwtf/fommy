package pl.kavel.waluta;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kavel.waluta.service.UserService;
import pl.kavel.waluta.user.User;

public class DodajCommand implements CommandExecutor {

    private final UserService userService = BukkitMain.getInstance().getUserService();
    User user = this.userService.findUserByNickName(player.getName());
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {

        } else {
            Player p = (Player) sender;
            p.sendMessage("");
        }
        return false;
    }
}
