/*
 * This file is part of the AnimatedFreeze project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024 1024_byteeeee and contributors
 *
 * AnimatedFreeze is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AnimatedFreeze is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with AnimatedFreeze. If not, see <https://www.gnu.org/licenses/>.
 */

package top.byteeeee.AnimatedFreeze.helpers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Environment(EnvType.CLIENT)
public class EntityRenderBlock {
    private static final List<Predicate<Class<?>>> entityRenderBlockPredicates = new ArrayList<>();

    public static boolean isOf(Class<?> blockEntity) {
        return entityRenderBlockPredicates.stream().anyMatch(predicate -> predicate.test(blockEntity));
    }

    static {
        entityRenderBlockPredicates.add(blockEntity -> blockEntity.equals(ChestBlockEntity.class));
        entityRenderBlockPredicates.add(blockEntity -> blockEntity.equals(TrappedChestBlockEntity.class));
        entityRenderBlockPredicates.add(blockEntity -> blockEntity.equals(EnderChestBlockEntity.class));
    }
}
