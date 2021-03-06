package mezz.jei.plugins.vanilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraft.client.gui.recipebook.RecipeBookGui;
import net.minecraft.client.gui.recipebook.RecipeTabToggleWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.Rectangle2d;

import mezz.jei.api.gui.handlers.IGuiContainerHandler;

class RecipeBookGuiHandler<T extends ContainerScreen & IRecipeShownListener> implements IGuiContainerHandler<T> {
	/**
	 * Modeled after {@link RecipeBookGui#func_230430_a_(com.mojang.blaze3d.matrix.MatrixStack, int, int, float)}
	 */
	@Override
	public List<Rectangle2d> getGuiExtraAreas(T containerScreen) {
		RecipeBookGui guiRecipeBook = containerScreen.getRecipeGui();
		if (guiRecipeBook.isVisible()) {
			List<Rectangle2d> areas = new ArrayList<>();
			int i = (guiRecipeBook.width - 147) / 2 - guiRecipeBook.xOffset;
			int j = (guiRecipeBook.height - 166) / 2;
			areas.add(new Rectangle2d(i, j, 147, 166));
			for (RecipeTabToggleWidget tab : guiRecipeBook.recipeTabs) {
				if (tab.field_230694_p_) {
					areas.add(new Rectangle2d(tab.field_230690_l_, tab.field_230691_m_, tab.func_230998_h_(), tab.getHeight()));
				}
			}
			return areas;
		}
		return Collections.emptyList();
	}
}
