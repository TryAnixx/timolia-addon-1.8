package de.labymod.lennart.autogglistener;

import de.labymod.lennart.TimoliaAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;

public class MessageReceiveSuspiciousListener implements MessageReceiveEvent {
    @Override
    public boolean onReceive(String s, String s1) {

        if (!TimoliaAddon.getINSTANCE().isEnabledAutoGGSuspicious()) return false;

        if (TimoliaAddon.getINSTANCE().isSuspicious()) {
            if (s1.contains("Noch") && s1.contains("bis zum nächsten Rang!")) {
                Minecraft.func_71410_x().field_71439_g.func_71165_d(TimoliaAddon.getINSTANCE().getGameSuspicious());
            }
        } return false;

    }
}