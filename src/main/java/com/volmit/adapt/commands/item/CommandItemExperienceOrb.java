/*------------------------------------------------------------------------------
 -   Adapt is a Skill/Integration plugin  for Minecraft Bukkit Servers
 -   Copyright (c) 2022 Arcane Arts (Volmit Software)
 -
 -   This program is free software: you can redistribute it and/or modify
 -   it under the terms of the GNU General Public License as published by
 -   the Free Software Foundation, either version 3 of the License, or
 -   (at your option) any later version.
 -
 -   This program is distributed in the hope that it will be useful,
 -   but WITHOUT ANY WARRANTY; without even the implied warranty of
 -   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 -   GNU General Public License for more details.
 -
 -   You should have received a copy of the GNU General Public License
 -   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 -----------------------------------------------------------------------------*/

package com.volmit.adapt.commands.item;

import com.volmit.adapt.content.item.ExperienceOrb;
import com.volmit.adapt.util.MortarCommand;
import com.volmit.adapt.util.MortarSender;
import org.bukkit.Bukkit;

import java.util.List;

public class CommandItemExperienceOrb extends MortarCommand {
    public CommandItemExperienceOrb() {
        super("experience", "xp", "x");
    }

    @Override
    public boolean handle(MortarSender sender, String[] args) {
        if (args.toList().size() > 2) {
            if (Bukkit.getPlayer(args[2]) != null && Bukkit.getPlayer(args[2]).getPlayer() != null) {
                Bukkit.getPlayer(args[2]).getPlayer().getInventory().addItem(ExperienceOrb.with(args[0], Integer.parseInt(args[1])));
            }
        } else if (args.toList().size() == 2) {
            sender.player().getInventory().addItem(ExperienceOrb.with(args[0], Integer.parseInt(args[1])));
        }
        return true;
    }

    @Override
    public void addTabOptions(MortarSender sender, String[] args, List<String> list) {

    }

    @Override
    protected String getArgsUsage() {
        return "<skill> <xp>";
    }
}