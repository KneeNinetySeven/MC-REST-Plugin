package org.codemadness.mcrest.dto;

import lombok.*;
import org.bukkit.ChunkSnapshot;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlRootElement
public class ChunkDTO implements Serializable {

    private int z;
    private int x;

    public ChunkDTO(ChunkSnapshot chunkSnapshot) {
        x = chunkSnapshot.getX();
        z = chunkSnapshot.getZ();
    }
}
