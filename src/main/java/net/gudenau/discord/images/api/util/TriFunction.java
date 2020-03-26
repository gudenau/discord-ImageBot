package net.gudenau.discord.images.api.util;

/**
 * Like BiFunction but with 3 params.
 *
 * @author gudenau
 * @since 1.0.0
 * */
@FunctionalInterface
public interface TriFunction<P1, P2, P3, R>{
    R invoke(P1 param1, P2 param2, P3 param3);
}
