package red.jackf.whereisit.client;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import red.jackf.whereisit.FoundType;
import red.jackf.whereisit.WhereIsIt;
import red.jackf.whereisit.WhereIsItClient;

import java.util.Objects;

public class FoundItemPos {
    public BlockPos pos;
    public long time;
    public VoxelShape shape;
    public final float r;
    public final float g;
    public final float b;

    public FoundItemPos(BlockPos pos, long time, VoxelShape shape, float r, float g, float b) {
        this.pos = pos;
        this.time = time;
        this.shape = shape;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static FoundItemPos from(BlockPos pos, long time, VoxelShape shape, FoundType type) {
        if (type == FoundType.FOUND_DEEP) {
            return new FoundItemPos(pos, time, shape,
                ((WhereIsIt.CONFIG.getAlternateColour() >> 16) & 0xff) / 255f,
                ((WhereIsIt.CONFIG.getAlternateColour() >> 8) & 0xff) / 255f,
                ((WhereIsIt.CONFIG.getAlternateColour()) & 0xff) / 255f);
        } else {
            return new FoundItemPos(pos, time, shape,
                ((WhereIsIt.CONFIG.getColour() >> 16) & 0xff) / 255f,
                ((WhereIsIt.CONFIG.getColour() >> 8) & 0xff) / 255f,
                ((WhereIsIt.CONFIG.getColour()) & 0xff) / 255f);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoundItemPos that = (FoundItemPos) o;
        return Objects.equals(pos, that.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }
}