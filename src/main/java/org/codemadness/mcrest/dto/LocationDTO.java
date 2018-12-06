package org.codemadness.mcrest.dto;

import lombok.*;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlRootElement
public class LocationDTO implements Serializable {

    private double x;
    private double y;
    private double z;
    private ChunkDTO chunk;
    private Vector direction;
    private float pitch;

    public LocationDTO(Location location) {
        x = location.getX();
        y = location.getY();
        z = location.getZ();

        chunk = new ChunkDTO(location.getChunk().getChunkSnapshot());

        direction = location.getDirection();
        pitch = location.getPitch();
    }

}
