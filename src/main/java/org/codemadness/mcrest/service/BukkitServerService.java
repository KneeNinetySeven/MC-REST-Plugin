package org.codemadness.mcrest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.codemadness.mcrest.dto.BukkitServerInfo;
import org.codemadness.mcrest.dto.PlayerDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/server")
public class BukkitServerService {

    @GET
    @Path("/info")
    @Produces(APPLICATION_JSON)
    public String bukkitServerInfo() throws JsonProcessingException {

        String name = Bukkit.getName();
        String motd = Bukkit.getMotd();
        int maxPlayers = Bukkit.getMaxPlayers();
        String bukkitVersion = Bukkit.getBukkitVersion();

        BukkitServerInfo serverInfo = BukkitServerInfo.builder()
                .name(name)
                .motd(motd)
                .version(bukkitVersion)
                .maxPlayers(maxPlayers)
                .build();

        return new ObjectMapper().writeValueAsString(serverInfo);
    }

    @GET
    @Path("/players")
    @Produces(APPLICATION_JSON)
    public String getOnlinePlayers() {
        Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
        List<PlayerDTO> dtoList = players.stream().map(PlayerDTO::new).collect(Collectors.toList());
        try {
            return new ObjectMapper().writeValueAsString(dtoList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Fuck.";
    }

}
