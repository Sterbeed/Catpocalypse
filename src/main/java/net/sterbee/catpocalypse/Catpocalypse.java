package net.sterbee.catpocalypse;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.sterbee.catpocalypse.entity.ModdedCats;
import net.sterbee.catpocalypse.entity.custom.PykeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catpocalypse implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "catpocalypse";
    public static final Logger LOGGER = LoggerFactory.getLogger("catpocalypse");

	@Override
	public void onInitialize() {
		LOGGER.info("he is so portuguese!");



		FabricDefaultAttributeRegistry.register(ModdedCats.PYKE, PykeEntity.createPykeAttributes());
	}
}