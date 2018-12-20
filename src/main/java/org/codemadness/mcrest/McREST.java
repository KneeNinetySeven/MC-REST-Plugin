package org.codemadness.mcrest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.codemadness.mcrest.providers.CORSProvider;
import org.codemadness.mcrest.service.BukkitServerService;
import org.codemadness.mcrest.service.HalloWeltService;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public final class McREST extends JavaPlugin {

    private HttpServer httpServer;

    @Override
    public void onEnable() {
        String serverIp = Bukkit.getServer().getIp();
        serverIp = serverIp.equals("") ? "localhost" : serverIp;
        int port = Bukkit.getServer().getPort() + 1;
        URI serverUri = URI.create(String.format("http://%s:%s/", serverIp, String.valueOf(port)));
        System.out.println("Starting Server at: " + serverUri.toString());

        final ResourceConfig rc = new ResourceConfig()
                .register(HalloWeltService.class)
                .register(BukkitServerService.class)
                .register(CORSProvider.class);

        httpServer = GrizzlyHttpServerFactory.createHttpServer(serverUri, rc);

        Runtime.getRuntime().addShutdownHook(new Thread(httpServer::shutdownNow));

    }

    @Override
    public void onDisable() {
        httpServer.shutdownNow();
    }
}
