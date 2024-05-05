package net.anatomyworld2.woodland;

//import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.anatomyworld2.woodland.block.ModBlocks;
import net.anatomyworld2.woodland.block.entity.ModBlockEntities;
import net.anatomyworld2.woodland.entity.ModBoats;
import net.anatomyworld2.woodland.util.ModWoodTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class WoodLandClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KING_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KING_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KING_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KING_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KING_SAPLING_CROP, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.KING, TexturedRenderLayers.getSignTextureId(ModWoodTypes.KING));

        TerraformBoatClientHelper.registerModelLayers(ModBoats.KING_BOAT_ID, false);
    }
}
