package org.codemadness.mcrest.dto;

import lombok.*;
import org.bukkit.entity.Player;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlRootElement
public class PlayerDTO implements Serializable {

    private String name;
    private String uniqueId;
    private String displayName;
    private long firstPlayed;
    private GameModeDTO gameMode;
    private int level;
    private LocationDTO location;

    public PlayerDTO(Player onlinePlayer) {
        name = onlinePlayer.getName();
        displayName = onlinePlayer.getDisplayName();
        gameMode = new GameModeDTO(onlinePlayer.getGameMode());
        level = onlinePlayer.getLevel();
        uniqueId = onlinePlayer.getUniqueId().toString();
        firstPlayed = onlinePlayer.getFirstPlayed();
        location = new LocationDTO(onlinePlayer.getLocation());
    }
}
