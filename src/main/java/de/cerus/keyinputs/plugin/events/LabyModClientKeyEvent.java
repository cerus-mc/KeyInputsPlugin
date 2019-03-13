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

package de.cerus.keyinputs.plugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LabyModClientKeyEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private int key;
    private String keyName;
    private Player player;
    private boolean moving;

    public LabyModClientKeyEvent(int key, String keyName, Player player, boolean moving) {
        this.key = key;
        this.keyName = keyName;
        this.player = player;
        this.moving = moving;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isMoving() {
        return moving;
    }

    public int getKey() {
        return key;
    }

    public String getKeyName() {
        return keyName;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
