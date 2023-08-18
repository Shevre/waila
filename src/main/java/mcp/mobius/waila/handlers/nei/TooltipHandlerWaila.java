package mcp.mobius.waila.handlers.nei;

import java.util.List;

import mcp.mobius.waila.utils.Constants;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import codechicken.nei.guihook.IContainerTooltipHandler;
import mcp.mobius.waila.utils.ModIdentification;

public class TooltipHandlerWaila implements IContainerTooltipHandler {

    @Override
    public List<String> handleItemDisplayName(GuiContainer arg0, ItemStack itemstack, List<String> currenttip) {
        return currenttip;
    }

    @Override
    public List<String> handleItemTooltip(GuiContainer arg0, ItemStack itemstack, int arg2, int arg3,
            List<String> currenttip) {
        String canonicalName = ModIdentification.nameFromStack(itemstack);
        if (canonicalName != null && !canonicalName.equals("")) currenttip.add(Constants.modnameStyle + canonicalName);
        return currenttip;
    }

    @Override
    public List<String> handleTooltip(GuiContainer arg0, int arg1, int arg2, List<String> currenttip) {
        return currenttip;
    }

}
