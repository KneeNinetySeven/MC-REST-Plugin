package org.codemadness.mcrest.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement
public class BukkitServerInfo implements Serializable {

    private String motd;

    private String name;

    private String version;

    private Integer maxPlayers;

}
