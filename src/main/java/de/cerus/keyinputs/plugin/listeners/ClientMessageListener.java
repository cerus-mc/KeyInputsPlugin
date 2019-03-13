/*
 *  Copyright (c) 2018 Cerus
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Cerus
 *
 */

package de.cerus.keyinputs.plugin.listeners;

import com.google.gson.JsonObject;
import de.cerus.ceruslib.listenerframework.CerusListener;
import de.cerus.keyinputs.plugin.events.LabyModClientKeyEvent;
import net.labymod.serverapi.bukkit.event.MessageReceiveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class ClientMessageListener extends CerusListener {
    public ClientMessageListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onMessage(MessageReceiveEvent event) {
        if(!event.getMessageKey().equals("KeyInputsAddon")) return;
        JsonObject jsonObject = event.getJsonElement().getAsJsonObject();
        if (!jsonObject.has("KeyInputsMessage")) return;
        jsonObject = jsonObject.get("KeyInputsMessage").getAsJsonObject();
        if (!jsonObject.has("key")) return;
        int key = jsonObject.get("key").getAsInt();
        if(!jsonObject.has("moving")) return;
        boolean moving = jsonObject.get("moving").getAsBoolean();
        if(!jsonObject.has("name")) return;
        String keyName = jsonObject.get("name").getAsString();
        getPlugin().getServer().getPluginManager().callEvent(new LabyModClientKeyEvent(key, keyName, event.getPlayer(), moving));
    }
}
