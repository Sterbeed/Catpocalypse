package net.sterbee.catpocalypse;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.sterbee.catpocalypse.entity.ModdedCats;
import net.sterbee.catpocalypse.entity.client.ModModelLayers;
import net.sterbee.catpocalypse.entity.client.PykeModel;
import net.sterbee.catpocalypse.entity.client.PykeRender;

public class CatpocalypseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModdedCats.PYKE, PykeRender::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PYKE, PykeModel::getTexturedModelData);
    }
}
