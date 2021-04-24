package de.labymod.lennart.autogglistener;

import de.labymod.lennart.TimoliaAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;

public class MessageReceive4renaListener implements MessageReceiveEvent {
    @Override
    public boolean onReceive(String s, String s1) {

        if (!TimoliaAddon.getINSTANCE().isArena()) return false;
        if (Minecraft.getMinecraft().thePlayer.inventory.hasItem(Item.getItemById(345))) return false;
        if (!TimoliaAddon.getINSTANCE().isEnabledAutoGG4rena()) return false;

        if (s1.contains("4rena") && s1.contains("»")) {
            if (s1.contains("Team") && s1.contains("gewinnt diese Runde")) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage("@" + TimoliaAddon.getINSTANCE().getMatch4rena());
            }
            else if (s1.contains("gewinnt diese Runde")) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(TimoliaAddon.getINSTANCE().getMatch4rena());
            }
        }

        if (TimoliaAddon.getINSTANCE().isArena()) {
            if (s1.contains("Noch") && s1.contains("bis zum nächsten Rang!")) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(TimoliaAddon.getINSTANCE().getGame4rena());
            }
        } return false;
        
    }
}