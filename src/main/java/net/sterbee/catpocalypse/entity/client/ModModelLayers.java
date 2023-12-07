package net.sterbee.catpocalypse.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.sterbee.catpocalypse.Catpocalypse;

public class ModModelLayers {
    public static final EntityModelLayer PYKE =
            new EntityModelLayer(new Identifier(Catpocalypse.MOD_ID, "pyke"), "main");
}
