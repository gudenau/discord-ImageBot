package net.gudenau.discord.images.api.util;

/**
 * Like BiFunction but with 4 params.
 *
 * @author gudenau
 * @since 1.0.0
 * */
@FunctionalInterface
public interface QuadFunction<P1, P2, P3, P4, R>{
    R invoke(P1 param1, P2 param2, P3 param3, P4 param4);
}
