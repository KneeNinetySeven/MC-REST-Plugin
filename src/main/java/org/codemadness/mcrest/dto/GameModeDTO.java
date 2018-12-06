package org.codemadness.mcrest.dto;

import lombok.*;
import org.bukkit.GameMode;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlRootElement
public class GameModeDTO implements Serializable {

    private String name;
    private int identifier;

    public GameModeDTO(GameMode mode) {
        name = mode.name();
        identifier = mode.getValue();
    }
}
