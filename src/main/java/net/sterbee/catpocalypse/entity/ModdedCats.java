package net.sterbee.catpocalypse.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sterbee.catpocalypse.Catpocalypse;
import net.sterbee.catpocalypse.entity.custom.PykeEntity;

public class ModdedCats {
    public static final EntityType<PykeEntity> PYKE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Catpocalypse.MOD_ID, "pyke"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PykeEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1f)).build());
}
